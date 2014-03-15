package com.yourapp

import grails.plugin.multitenant.core.exception.TenantResolveException
import grails.plugin.multitenant.core.resolve.TenantResolver

import javax.servlet.http.HttpServletRequest

/**
 * TODO: Implement me!
 *
 * @see http://multi-tenant.github.com/grails-multi-tenant-single-db/
 */
class DomainTenantResolver implements TenantResolver {

    Integer resolve(HttpServletRequest request) throws TenantResolveException {
        return 1;
    }
}
