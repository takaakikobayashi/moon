<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="members.model.OrderDao"%>
<%@ page import="common.model.ItemDao"%>
<%@ page import="members.model.OrderBean"%>
<%@ page import="java.util.HashSet"%>
<%@ page import="java.util.Set"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="../common/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  	<script src="../common/bootstrap/js/bootstrap.min.js"></script>
	<title>注文一覧</title>
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
				<% OrderDao orderDao = new OrderDao(); %>
				<% ItemDao itemDao = new ItemDao(); %>
				<% ArrayList<OrderBean> order_list = orderDao.getOrderList(); %>
				<h3 class="title">注文履歴一覧</h3>
				<% if (order_list.isEmpty()) { %>
					<p>注文履歴はありません</p>
				<% } else { %>
					<table border="1">
						<tr>
							<th>注文日</th>
							<th>注文商品</th>
							<th>支払金額</th>
							<th>注文詳細</th>
						</tr>
						<% Set<String> multiple = new HashSet<>(); %>
						<% for (OrderBean bean : order_list) {%>
						    <% String order_id = String.valueOf(bean.getOrderId()); %>
			    			<% if (!multiple.add(order_id)){ %>
			        			<tr>
							      	<td></td>
							      	<% int item_id = bean.getProductId(); %>
									<td><%= itemDao.selectItem(item_id).getName() %></td>
									<td>¥<%= bean.getPrice() %></td>
									<td><p class="item_button"><a href="adminsorderdetailservlet?order_id=<%= bean.getOrderId() %>">注文詳細</a></p></td>
									<% session.setAttribute("order_check",bean.getOrderId()); %>
								</tr>
			    			<% } else { %>
							    <tr>
							      	<td><%= bean.getCreatedAt() %></td>
							      	<% int item_id = bean.getProductId(); %>
									<td><%= itemDao.selectItem(item_id).getName() %></td>
									<td>¥<%= bean.getPrice() %></td>
									<td><p class="item_button"><a href="adminsorderdetailservlet?order_id=<%= bean.getOrderId() %>">注文詳細</a></p></td>
									<% session.setAttribute("order_check",bean.getOrderId()); %>
								</tr>
							<% } %>
						<% } %>
					</table>
				<% } %>
			</div>
		</main>
		<footer>
			<%@ include file="footer.jsp" %>
		</footer>
	<% } %>
</div>
</body>
</html>