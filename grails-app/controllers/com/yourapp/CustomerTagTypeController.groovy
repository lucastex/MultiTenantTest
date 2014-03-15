package com.yourapp

import grails.transaction.Transactional

import static org.springframework.http.HttpStatus.*

@Transactional(readOnly = true)
class CustomerTagTypeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond CustomerTagType.list(params), model:[customerTagTypeInstanceCount: CustomerTagType.count()]
    }

    def show(CustomerTagType customerTagTypeInstance) {
        respond customerTagTypeInstance
    }

    def create() {
        respond new CustomerTagType(params)
    }

    @Transactional
    def save(CustomerTagType customerTagTypeInstance) {
        if (customerTagTypeInstance == null) {
            notFound()
            return
        }

        if (customerTagTypeInstance.hasErrors()) {
            respond customerTagTypeInstance.errors, view:'create'
            return
        }

        customerTagTypeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'customerTagTypeInstance.label', default: 'CustomerTagType'), customerTagTypeInstance.id])
                redirect customerTagTypeInstance
            }
            '*' { respond customerTagTypeInstance, [status: CREATED] }
        }
    }

    def edit(CustomerTagType customerTagTypeInstance) {
        respond customerTagTypeInstance
    }

    @Transactional
    def update(CustomerTagType customerTagTypeInstance) {
        if (customerTagTypeInstance == null) {
            notFound()
            return
        }

        if (customerTagTypeInstance.hasErrors()) {
            respond customerTagTypeInstance.errors, view:'edit'
            return
        }

        customerTagTypeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'CustomerTagType.label', default: 'CustomerTagType'), customerTagTypeInstance.id])
                redirect customerTagTypeInstance
            }
            '*'{ respond customerTagTypeInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(CustomerTagType customerTagTypeInstance) {

        if (customerTagTypeInstance == null) {
            notFound()
            return
        }

        customerTagTypeInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'CustomerTagType.label', default: 'CustomerTagType'), customerTagTypeInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'customerTagTypeInstance.label', default: 'CustomerTagType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
