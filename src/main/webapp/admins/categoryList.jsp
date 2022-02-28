<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="common.model.CategoryDao"%>
<%@ page import="common.model.CategoryBean"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="../common/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  	<script src="../common/bootstrap/js/bootstrap.min.js"></script>
	<title>商品カテゴリ一覧</title>
</head>
<body>
<div class="wrapper">

	<% LoginAdminBean logincheck = (LoginAdminBean)session.getAttribute("admin"); %>
	<% if(logincheck == null) { %>
	
		<% request.setAttribute("login_check","操作にはログインをする必要があります"); %>
		<%@ include file="login.jsp" %>
		
	<%-- <% } else if(request.getAttribute("category_error") != null) { %>
	
		<p style="color: red;"><%= request.getAttribute("category_error") %></p> --%>
	
	<% } else { %>
	
		<header>
			<%@ include file="header.jsp" %>
		</header>
		<main>
			<div class="container">
				<div class="row">
			
					<form action="addcategoryservlet" method="get">
				        <input type="text" name="category" required>
				        <input type="submit" value="追加"/>
				    </form>
			
					<% CategoryDao categoryDao = new CategoryDao(); %>
					<% ArrayList<CategoryBean> categoryBeanList  = categoryDao.selectcategory(); %>
					<p>カテゴリ名</p>
					<% for (CategoryBean bean : categoryBeanList) {%>
						<p><%= bean.getName() %></p>
						<p><a href="editCategory.jsp?category_id=<%= bean.getCategoryId() %>">編集</a></p>
						<% if (bean.getIsActive() == 1) { %>
							<p><a href="categorystatusservlet?status=changefalse&category_id=<%= bean.getCategoryId() %>">無効にする</a></p>
						<% } else {%>
							<p><a href="categorystatusservlet?status=changetrue&category_id=<%= bean.getCategoryId() %>">有効にする</a></p>
						<% } %>
					<% } %>
					
				</div>
			</div>
		</main>
		<footer>
		<%@ include file="footer.jsp" %>
	</footer>
		
	<% } %>
	
</div>
</body>
</html>