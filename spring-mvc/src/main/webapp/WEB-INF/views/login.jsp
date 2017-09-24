<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/taglibs.jspf" %>

<c:url var="postLoginUrl" value="/j_spring_security_check" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Please log in</title>
		<link rel="stylesheet" href='<c:url value="/web-resources/css/style.css"/>'>		
	</head>
	<body onload="document.f.j_username.focus()">		
		<div class="login">
			<div>
				<%@ include file="i18n.jsp"%>
			</div>
			<h3><spring:message code="authentication.label.header"/></h3>
			
			<form name="f" class="main" action="${postLoginUrl}" method="post">				
				<c:choose>
					<c:when test="${param.failed eq 'error1'}">
						<div class="warning alert error">
							<spring:message code="authentication.error1.message"/>						
						</div>
					</c:when>
					<c:when test="${param.failed eq 'error2'}">
						<div class="warning alert error">
							<spring:message code="authentication.error2.message"/>						
						</div>
					</c:when>
					<c:when test="${param.failed eq 'error'}">
						<div class="warning alert error">
							<spring:message code="authentication.error.message"/>						
						</div>
					</c:when>					
					<c:otherwise/>											
				</c:choose>
				<div class="panel grid" style="width:420px">
					<div class="gridRow yui-gf">
						<div class="fieldLabel yui-u first"><spring:message code="authentication.label.username"/></div>
						<div class="yui-u"><input type="text" name="j_username" class="short" /></div>
					</div>
					<div class="gridRow yui-gf">
						<div class="fieldLabel yui-u first"><spring:message code="authentication.label.password"/></div>
						<div class="yui-u"><input type="password" name="j_password" class="short" /></div>
					</div>
					<div class="gridRow yui-gf">
						<div class="yui-u first"></div>
						<div class="yui-u"><input type="checkbox" name="_spring_security_remember_me" /><spring:message code="authentication.label.rememberme"/></div>
					</div>
					<div class="gridRow yui-gf">
						<div class="yui-u first"></div>
						<div class="yui-u">
							<input type="submit" value="<spring:message code="authentication.value.login"/>" />
							<input type="reset" value="<spring:message code="authentication.value.reset"/>">
						</div>
					</div>
				</div>
			</form>
		</div>
	</body>
</html>
