<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="../include/scripts.jsp" />
<link rel="stylesheet" type="text/css"
	href="../static/css/bootstrap.css">

<script>

	$(document)
			.ready(
					function() {
						$
								.ajax({
									url : '${pageContext.request.contextPath}/api/books/details/${bookID}',
									type : 'GET',
									success : function(show) {
										document.getElementById('t').innerHTML = show.title;
										document.getElementById('a').innerHTML = show.author;
									}
								});
					});
</script>

</head>

<body>

	<div>
		<div>
			<h1>Book</h1>
			<br /> <label>Title:</label>
			<div id="t"></div>

			<label>Author:</label>
			<div id="a"></div>

			<label>Reviews:</label>
			<c:forEach items="${reviews}" var="review">
				<!-- <label>Author: ${review.revAuthor}</label><br/> -->
				<label>${review.text}</label>
				<br />
				<!-- <label>Add date: ${review.addDate}</label><br/> -->
				<a
					href="${pageContext.request.contextPath}/ReviewDetails/${review.id}"
					class="btn btn-primary" role="button">Details</a>
				<a href="${pageContext.request.contextPath}/ReviewEdit/${review.id}"
					class="btn btn-primary" role="button">Edit</a>
				<a
					href="${pageContext.request.contextPath}/ReviewRemove/${review.id}"
					class="btn btn-primary" role="button">Remove</a>
				<br />
			</c:forEach>

			<div class="form-group text-center">
				<a href="${pageContext.request.contextPath}/BookEdit/${bookID}"
					class="btn btn-primary" role="button">Edit</a> <a
					href="${pageContext.request.contextPath}/BookRemove/${bookID}"
					class="btn btn-primary" role="button">Delete</a> <a
					href="${pageContext.request.contextPath}/main"
					class="btn btn-default" role="button">Home page</a>
			</div>
		</div>

	</div>
</body>
</html>