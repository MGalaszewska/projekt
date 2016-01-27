<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
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
									url : '${pageContext.request.contextPath}/api/reviews/details/${reviewID}',
									type : 'GET',
									success : function(show) {
										document.getElementById('revauthor').innerHTML = show.revAuthor;
										document.getElementById('date').innerHTML = show.addDate;
										document.getElementById('text').innerHTML = show.text;
									}
								});
					});
</script>
<script>
function edit(id) {
	window.location.href = "${pageContext.request.contextPath}/ReviewEdit/"+id;
}
</script>

<script>
function details(id) {
	window.location.href = "${pageContext.request.contextPath}/ReviewDetails/"+id;
}
</script>

</head>

<body>

	<div>
		<div>
			<br /> <label>Author:</label>
			<div id="revauthor"></div>

			<label>Create date:</label>
			<div id="date"></div>

			<label>Review:</label>
			<div id="text"></div>

			<div class="form-group text-center">
				<a href='javascript:edit(" + dane[i].id+ ")'
					class="btn btn-primary" role="button">Edit</a> <a
					href='javascript:remove(" + dane[i].id+ ")'
					class="btn btn-primary" role="button">Delete</a> <a
					href="${pageContext.request.contextPath}/main"
					class="btn btn-default" role="button">Home page</a>
			</div>
		</div>

	</div>
</body>
</html>