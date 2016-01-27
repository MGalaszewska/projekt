<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>

<script>
		$(document).ready(function()
				{		
				$.ajax
					(
						{
							url: '${pageContext.request.contextPath}/api/books/showall',
							type: 'GET',
							success: function(dane)
							{ 
								var d = dane.length;
								var table = document.getElementById("table");
								for (var i = 0; i < d; i++)
								{
									    tr = $('<tr/>');
									    tr.append("<td>"+dane[i].title+"</td>");
									    tr.append("<td>"+dane[i].author+"</td>");
									    td = $('<td/>');
									    td.append("<a href='${pageContext.request.contextPath}/bookdetails/"+dane[i].id+"' class='btn btn-xs btn-warning' role='button'> Details </a> ");
									    tr.append(td);
									    $(table).append(tr);
								}
							}
						}	
					);
				}
			);
	</script>

</head>
<link rel="stylesheet" type="text/css" href="../include/ksiegarnia.css">
<body>
<div>
    <div>
        <h1>Books</h1>
        <div>
        	<a href="${pageContext.request.contextPath}/addbook">Add</a>
         </div>
        <br/>

        <table id="table">
               <tr>
                     <th>Title</th>
                     <th>Author</th>
                     <th></th>
              </tr>
	</table>
    </div>

</body>
</html>