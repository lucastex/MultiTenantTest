<%@ page import="com.yourapp.CustomerTagType" %>



<div class="fieldcontain ${hasErrors(bean: customerTagTypeInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="customerTagType.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${customerTagTypeInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: customerTagTypeInstance, field: 'tenantId', 'error')} required">
	<label for="tenantId">
		<g:message code="customerTagType.tenantId.label" default="Tenant Id" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="tenantId" type="number" value="${customerTagTypeInstance.tenantId}" required=""/>

</div>

