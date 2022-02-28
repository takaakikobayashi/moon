<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="common.model.ItemBean"%>
<%@ page import="common.model.CategoryDao"%>
<%@ page import="common.model.CategoryBean"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="../common/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  	<script src="../common/bootstrap/js/bootstrap.min.js"></script>
	<title>卵スイーツ専門店 | Moon</title>
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
				<!-- カテゴリ -->
				<% CategoryDao categoryDao = new CategoryDao(); %>
				<% ArrayList<CategoryBean> categoryBeanList  = categoryDao.selectcategory(); %>
				<p><a href="categorylistservlet">商品カテゴリ一覧</a></p>
			
		 		<% for (CategoryBean bean : categoryBeanList) {%>
					<p><a href="adminsitemlistservlet?category_id=<%= bean.getCategoryId() %>"><%= bean.getName() %></a></p>
				<% } %>
				
		 		<% ArrayList<ItemBean> itemList = (ArrayList<ItemBean>) request.getAttribute("itemList"); %>
				<% if (itemList != null) {%>
		
					<% for (ItemBean bean : itemList) {%>
						<p><%= bean.getImageBlob() %></p>
						<p><%= bean.getName() %></p>
						<p><%= bean.getPrice() %></p>
						<p class="item_button"><a href="adminsitemdetailservlet?item_id=<%= bean.getProductId() %>">商品詳細</a></p>
					<% } %>
					
				<% } else { %>
					<%@ include file="itemListView.jsp" %>
				<% } %>
			</div>
		</main>
	<% } %>
	<footer>
		<%@ include file="footer.jsp" %>
	</footer>
</div>
</body>
</html>