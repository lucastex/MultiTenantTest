
<%@ page import="com.yourapp.CustomerTagType" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'customerTagType.label', default: 'CustomerTagType')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-customerTagType" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-customerTagType" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'customerTagType.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="tenantId" title="${message(code: 'customerTagType.tenantId.label', default: 'Tenant Id')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${customerTagTypeInstanceList}" status="i" var="customerTagTypeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${customerTagTypeInstance.id}">${fieldValue(bean: customerTagTypeInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: customerTagTypeInstance, field: "tenantId")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${customerTagTypeInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
