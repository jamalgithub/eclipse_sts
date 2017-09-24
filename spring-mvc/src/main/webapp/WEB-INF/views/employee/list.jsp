<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/taglibs.jspf" %>

<spring:message var="pageTitle" code="listEmployee.pageTitle" />
<c:url var="login" value="/login" />
<c:url var="logout" value="/j_spring_security_logout" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>  
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${pageTitle}</title>  
<link rel="stylesheet" href='<c:url value="/web-resources/css/style.css"/>'>
</head>  
<body>  
 <center>  
  <div>
  	<%@ include file="../i18n.jsp"%>
  </div>
  <div>
	<security:authorize access="isAuthenticated()">
		<spring:message code="authentication.label.greeting"/>
		<security:authentication property="principal.fullName" />
		<security:authentication property="principal.authorities"/> | 
		<a href="${logout}"><spring:message code="authentication.label.logout"/></a>
	</security:authorize>
  </div>
  <div style="color: teal; font-size: 30px">${pageTitle}</div>  
     
	<table>		    
		<tr>
			<th><spring:message code="listEmployee.label.fname"/></th>
			<th><spring:message code="listEmployee.label.lname"/></th>
			<th><spring:message code="listEmployee.label.email"/></th>
			<th><spring:message code="listEmployee.label.phone"/></th>
			<th><spring:message code="listEmployee.label.birthday"/></th>
			<th><spring:message code="listEmployee.label.gender"/></th>
			<th><spring:message code="listEmployee.label.version"/></th>
			<security:authorize access="hasRole('admin')">
				<th colspan="2">
					<a href="${pageContext.request.contextPath}/employee/add">
						<img src="<c:url value="/web-resources/images/add.png" />" title="<spring:message code="listEmployee.label.add"/>"/>					
					</a>
				</th>
			</security:authorize>				
		</tr>
		<c:if test="${not empty employeeList}"> 
			<c:forEach items="${employeeList}" var="employee">  
				<tr>  
					<td><c:out value="${employee.firstName}" /></td>  
					<td><c:out value="${employee.lastName}" /></td>  
					<td><c:out value="${employee.email}" /></td>  
					<td><c:out value="${employee.phone}" /></td>
					<td><c:out value="${employee.birthday}" /></td>
					<td><c:out value="${employee.gender}" /></td>
					<td><c:out value="${employee.version}" /></td>
					<security:authorize access="hasRole('admin')">
						<td>
							<a href="${pageContext.request.contextPath}/employee/edit/${employee.id}">
								<img src="<c:url value="/web-resources/images/edit.png" />" title="<spring:message code="listEmployee.label.edit"/>"/>							
							</a>
						</td>  
						<td>
							<a onclick="return confirm('<spring:message code="listEmployee.delete.confirm.message"/>');" href="${pageContext.request.contextPath}/employee/delete/${employee.id}">
								<img src="<c:url value="/web-resources/images/delete.png" />" title="<spring:message code="listEmployee.label.delete"/>"/>
							</a>
						</td>
					</security:authorize>  
				</tr>  
			</c:forEach>
		</c:if>   
	</table>   
     
 </center>  
</body>  
</html> 