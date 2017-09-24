<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<spring:message var="pageTitle" code="listBook.pageTitle" />

<html>
<head>
<title>${pageTitle}</title>

<link rel="stylesheet" href='<c:url value="/web-resources/css/pure-0.4.2.css"/>'>

<link rel="stylesheet" href='<c:url value="/web-resources/css/font-awesome-4.0.3/css/font-awesome.css"/>'>

<link rel="stylesheet" href='<c:url value="/web-resources/css/jquery-ui-1.10.4.custom.css"/>'>

<style type="text/css">
th {
	text-align: left
}
</style>

</head>

<body>
	<div style="width: 95%; margin: 0 auto;">
		<div>
	    	<%@ include file="../i18n.jsp"%>
	    </div>
		<div id="bookDialog" style="display: none;">
			<%@ include file="bookForm.jsp"%>
		</div>

		<h1>${pageTitle}</h1>

		<button class="pure-button pure-button-primary" onclick="addBook()">
			<i class="fa fa-plus"></i> <spring:message code="listBook.label.add"/>
		</button>
		<br>
		<table class="pure-table pure-table-bordered pure-table-striped">
			<thead>
				<tr>
					<th width="4%"><spring:message code="listBook.label.sn"/></th>
					<th width="12%"><spring:message code="listBook.label.name"/></th>
					<th width="12%"><spring:message code="listBook.label.code"/></th>
					<th width="12%"><spring:message code="listBook.label.price"/></th>
					<th width="12%"><spring:message code="listBook.label.author"/></th>
					<th width="12%"><spring:message code="listBook.label.isbn"/></th>
					<th width="12%"><spring:message code="listBook.label.publisher"/></th>
					<th width="12%"><spring:message code="listBook.label.publishedOn"/></th>
					<th width="12%"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${bookList}" var="book" varStatus="loopCounter">
					<tr>
						<td><c:out value="${loopCounter.count}" /></td>
						<td><c:out value="${book.name}" /></td>
						<td><c:out value="${book.code}" /></td>
						<td><c:out value="${book.price}" /></td>
						<td><c:out value="${book.authors}" /></td>
						<td><c:out value="${book.isbn}" /></td>
						<td><c:out value="${book.publisher}" /></td>
						<td><c:out value="${book.publishedOn}" /></td>
						<td>
							<nobr>
								<button class="pure-button pure-button-primary"	onclick="editBook(${book.id});">
									<i class="fa fa-pencil"></i> <spring:message code="listBook.label.edit"/>
								</button>
								<a class="pure-button pure-button-primary"
									onclick="return confirm('Are you sure you want to delete this book?');"
									href="delete/${book.id}"> 
									<i class="fa fa-times"></i> <spring:message code="listBook.label.delete"/>
								</a>
							</nobr>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

	<!--  It is advised to put the <script> tags at the end of the document body so they don't block rendering of the page -->
	<script type="text/javascript"
		src='<c:url value="/web-resources/js/lib/jquery-1.10.2.js"/>'></script>
	<script type="text/javascript"
		src='<c:url value="/web-resources/js/lib/jquery-ui-1.10.4.custom.js"/>'></script>
	<script type="text/javascript"
		src='<c:url value="/web-resources/js/lib/jquery.ui.datepicker.js"/>'></script>
	<script type="text/javascript"
		src='<c:url value="/web-resources/js/js-for-listBooks.js"/>'></script>
</body>
</html>