<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url var="actionUrl" value="save" />

<form:form id="bookForm" modelAttribute="book" method="post" action="${actionUrl}" class="pure-form pure-form-aligned">

	<fieldset>
		<legend></legend>

		<div class="pure-control-group">
			<label for="name"><spring:message code="bookForm.label.name"/></label>
			<form:input name = "customerId" path="name" placeholder="Book Name" />
		</div>
		<div class="pure-control-group">
			<label for="code"><spring:message code="bookForm.label.code"/></label>
			<form:input name="merocode" id = "merocode" path="code" placeholder="Code" maxlength="15" />
		</div>
		<div class="pure-control-group">
			<label for="price"><spring:message code="bookForm.label.price"/></label>
			<form:input path="price" placeholder="Price" maxlength="10" />
		</div>
		<div class="pure-control-group">
			<label for="authors"><spring:message code="bookForm.label.author"/></label>
			<form:input path="authors" placeholder="Authors" />
		</div>
		<div class="pure-control-group">
			<label for="isbn"><spring:message code="bookForm.label.isbn"/></label>
			<form:input path="isbn" placeholder="ISBN" />
		</div>
		<div class="pure-control-group">
			<label for="publisher"><spring:message code="bookForm.label.publisher"/></label>
			<form:input path="publisher" placeholder="Publisher" />
		</div>
		<div class="pure-control-group">
			<label for="publishedOn"><spring:message code="bookForm.label.publishedOn"/></label>
			<form:input path="publishedOn"	placeholder="YYYY-MM-DD" class="datepicker" />
		</div>

		<form:input path="id" type="hidden" />

	</fieldset>
</form:form>