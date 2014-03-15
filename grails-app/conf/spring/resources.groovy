// Place your Spring DSL code here
beans = {
    tenantResolver(com.yourapp.DomainTenantResolver)
    tenantRepository(com.yourapp.CachingTenantRepository)
}


// Activate these bean definitions
// Documentation http://grails.org/doc/latest/guide/single.html#14.2%20Configuring%20Additional%20Beans
// tenantResolver(com.yourapp.DomainTenantResolver)
// tenantRepository(com.yourapp.CachingTenantRepository)
