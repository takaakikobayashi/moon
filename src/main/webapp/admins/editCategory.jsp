<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="common.model.CategoryDao"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="../common/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  	<script src="../common/bootstrap/js/bootstrap.min.js"></script>
	<title>商品カテゴリ編集</title>
</head>
<body>
<div class="wrapper">
	<% LoginAdminBean logincheck = (LoginAdminBean)session.getAttribute("admin"); %>
	<% if(logincheck == null) { %>
	
		<% request.setAttribute("login_check","操作にはログインをする必要があります"); %>
		<%@ include file="login.jsp" %>
	
	<% } else { %>
		<header>
			<%@ include file="header.jsp" %>
		</header>
		<main>
			<div class="container">
		
				<% int category_id = Integer.parseInt(request.getParameter("category_id")); %>
				<% CategoryDao categoryDao = new CategoryDao(); %>
		
				<form action="categoryeditservlet" method="post">
					<table class="categoryEdit_form">
						<tbody>
		                	<tr>
		                    	<th>カテゴリ名</th>
		                        <td><input type="text" name="name" value="<%= categoryDao.getName(category_id).getName() %>"></td>
		                    </tr>
		            	</tbody>
		            </table>
		            
		            <input type="hidden" name="category_id" value="<%= Integer.parseInt(request.getParameter("category_id")) %>" />
		            
		            <div class="buttons">
		                <input class="common_button" type="submit" name="submit"  value="変更を保存する"/>
		            </div>
	        	</form>
			</div>
		</main>
		<footer>
			<%@ include file="footer.jsp" %>
		</footer>
	<% } %>
</div>
</body>
</html>