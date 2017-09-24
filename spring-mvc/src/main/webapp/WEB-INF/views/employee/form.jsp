<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/taglibs.jspf" %>

<spring:message var="pageTitle" code="formEmployee.pageTitle" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>  
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<title>${pageTitle}</title>
<style>
.error {
    color: #ff0000;
    font-style: italic;
    font-weight: bold;
}
div.ui-datepicker{
 font-size:12px;
}
</style>

<link rel="stylesheet" href='<c:url value="/web-resources/css/jquery-ui-1.10.4.custom.css"/>'>

</head>  
<body>  
 <center>  
 
  <div style="color: teal; font-size: 30px">${pageTitle}</div>      
  
  <c:url var="actionUrl" value="/employee/save" />  
  <form:form id="employeeForm" modelAttribute="employeeForm" method="post" action="${actionUrl}" >  
	   <table width="600px" height="150px">  
		    <tr>  
			     <td><form:label path="firstName"><spring:message code="formEmployee.label.fname"/></form:label></td>  
			     <td><form:input path="firstName" placeholder=""/></td>
			     <td>			    
				     <form:errors path="firstName" htmlEscape="false" cssClass="error"/>				
			     </td>
		    </tr>  
		    <tr>  
			     <td><form:label path="lastName"><spring:message code="formEmployee.label.lname"/></form:label></td>  
			     <td><form:input path="lastName" placeholder=""/></td> 
			     <td>			    
				     <form:errors path="lastName" htmlEscape="false" cssClass="error"/>				
			     </td> 
		    </tr>  
		    <tr>  
			     <td><form:label path="email"><spring:message code="formEmployee.label.email"/></form:label></td>  
			     <td><form:input path="email" placeholder=""/></td>  
			     <td>			    
				     <form:errors path="email" htmlEscape="false" cssClass="error"/>				
			     </td>
		    </tr>  
		    <tr>  
			     <td><form:label path="phone"><spring:message code="formEmployee.label.phone"/></form:label></td>  
			     <td><form:input path="phone" placeholder=""/></td>
			     <td>			    
				     <form:errors path="phone" htmlEscape="false" cssClass="error"/>				
			     </td>  
		    </tr>
		    <tr>  
			     <td><form:label path="birthday"><spring:message code="formEmployee.label.birthday"/></form:label></td>  
			     <td><form:input path="birthday" placeholder="DD/MM/YYYY" class="datepicker"/></td>
			     <td>			    
				     <form:errors path="birthday" htmlEscape="false" cssClass="error"/>				
			     </td>  
		    </tr>
		    <tr>  
			     <td><form:label path="gender"><spring:message code="formEmployee.label.gender"/></form:label></td>  
			     <td>
			     	<form:select path="gender">
			     		<form:option value=""><spring:message code="formEmployee.label.gender.select"/></form:option>
			     		<form:option value="m"><spring:message code="formEmployee.label.gender.m"/></form:option>
			     		<form:option value="f"><spring:message code="formEmployee.label.gender.f"/></form:option>
			     	</form:select>
			     </td>
			     <td>			    
				     <form:errors path="gender" htmlEscape="false" cssClass="error"/>				
			     </td>  
		    </tr> 
		    <tr>  
			     <td></td>  
			     <td>
			     	<input type="submit" value="<spring:message code="formEmployee.label.save"/>" />
			     	<input type="reset" value="<spring:message code="formEmployee.label.reset"/>" />
			     	<a href="${pageContext.request.contextPath}/employee/list">
			     		<spring:message code="formEmployee.label.cancel"/>
			     	</a>
			     </td>	
		    </tr>  
	   </table>
	   <form:input path="id" type="hidden" />
	   <form:input path="version" type="hidden" />	  
  </form:form>
      
 </center>
 
<script type="text/javascript"	src='<c:url value="/web-resources/js/lib/jquery-1.10.2.js"/>'></script>
<script type="text/javascript" src='<c:url value="/web-resources/js/lib/jquery-ui-1.10.4.custom.js"/>'></script>
<script>
  $(".datepicker").datepicker({
		dateFormat : "dd/mm/yy",
		changeMonth : true,
		changeYear : true,
		showWeek: true,
	    //firstDay: 1
		//showButtonPanel : true
	}).attr("readonly","readonly");
</script>   
</body>  
</html>