<%@ page import="com.yourapp.TagType" %>



<div class="fieldcontain ${hasErrors(bean: tagTypeInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="tagType.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${tagTypeInstance?.name}"/>

</div>

