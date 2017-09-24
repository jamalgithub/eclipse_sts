<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url var="actionUrl" value="save" />

<a href="?locale=en">
	<img src="<c:url value="/web-resources/images/en.png" />" title="<spring:message code="locale.label.en"/>"/>
</a>
<a href="?locale=fr">
	<img src="<c:url value="/web-resources/images/fr.png" />" title="<spring:message code="locale.label.fr"/>"/>
</a>