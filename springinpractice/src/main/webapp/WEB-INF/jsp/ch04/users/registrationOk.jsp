<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<%@ include file="/WEB-INF/jsp/taglibs.jspf" %>

<c:url var="newRegistrationUrl" value="/users/new" />

<spring:message var="pageTitle" code="registrationOk.pageTitle" />

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title><c:out value="${pageTitle}" /></title>
	</head>
	<body>
		<h1><c:out value="${pageTitle}" /></h1>
		<p><spring:message code="registrationOk.message.thanks" /></p>
		<p><a href="${newRegistrationUrl}"><spring:message code="registrationOk.label.registerAnother" /></a></p>
	</body>
</html>
