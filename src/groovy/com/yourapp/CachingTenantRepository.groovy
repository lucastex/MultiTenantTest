package com.yourapp

import grails.plugin.multitenant.core.CurrentTenant
import grails.plugin.multitenant.core.CurrentTenantAwareRepository
import grails.plugin.multitenant.core.Tenant
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Dummy implementation of TenantRepository
 * TODO: Make your changes
 * @author Kim A. Betti
 */
public class CachingTenantRepository implements CurrentTenantAwareRepository {

    private static final Logger log = LoggerFactory.getLogger(this)

    CurrentTenant currentTenant // will be injected

    @Override
    Tenant getCurrentTenant() {
        Tenant tenantInstance = null
        Integer currentTenantId = currentTenant.get()
        if (currentTenantId != null) {
            tenantInstance = findByTenantId(currentTenantId)
        }

        tenantInstance
    }

    @Override
    Tenant findByTenantId(Integer tenantId) {
        Customer.get(tenantId); // Assuming that you use Customer's primary key as tenant id
    }
}
