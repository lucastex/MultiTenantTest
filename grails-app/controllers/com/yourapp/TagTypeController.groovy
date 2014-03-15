package com.yourapp

import grails.transaction.Transactional

import static org.springframework.http.HttpStatus.*

@Transactional(readOnly = true)
class TagTypeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond TagType.list(params), model:[tagTypeInstanceCount: TagType.count()]
    }

    def show(TagType tagTypeInstance) {
        respond tagTypeInstance
    }

    def create() {
        respond new TagType(params)
    }

    @Transactional
    def save(TagType tagTypeInstance) {
        if (tagTypeInstance == null) {
            notFound()
            return
        }

        if (tagTypeInstance.hasErrors()) {
            respond tagTypeInstance.errors, view:'create'
            return
        }

        tagTypeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'tagTypeInstance.label', default: 'TagType'), tagTypeInstance.id])
                redirect tagTypeInstance
            }
            '*' { respond tagTypeInstance, [status: CREATED] }
        }
    }

    def edit(TagType tagTypeInstance) {
        respond tagTypeInstance
    }

    @Transactional
    def update(TagType tagTypeInstance) {
        if (tagTypeInstance == null) {
            notFound()
            return
        }

        if (tagTypeInstance.hasErrors()) {
            respond tagTypeInstance.errors, view:'edit'
            return
        }

        tagTypeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'TagType.label', default: 'TagType'), tagTypeInstance.id])
                redirect tagTypeInstance
            }
            '*'{ respond tagTypeInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(TagType tagTypeInstance) {

        if (tagTypeInstance == null) {
            notFound()
            return
        }

        tagTypeInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'TagType.label', default: 'TagType'), tagTypeInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tagTypeInstance.label', default: 'TagType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
