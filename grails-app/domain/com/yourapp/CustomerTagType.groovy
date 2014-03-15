package com.yourapp

import grails.plugin.multitenant.core.annotation.MultiTenant

@MultiTenant
class CustomerTagType {

    String name

    static constraints = {
        name(nullable: false, blank: false, unique: 'tenantId')
    }
}
