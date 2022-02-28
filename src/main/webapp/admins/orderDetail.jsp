<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="members.model.OrderDetailBean"%>
<%@ page import="members.model.OrderDao"%>
<%@ page import="common.model.ItemDao"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="../common/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  	<script src="../common/bootstrap/js/bootstrap.min.js"></script>
	<title>注文詳細</title>
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
			
				<% ArrayList<OrderDetailBean> orderDetailBean = (ArrayList<OrderDetailBean>) request.getAttribute("orderDetailBean"); %>
				
				<% if (orderDetailBean != null) { %>
				
					<table>
						<% for (OrderDetailBean bean : orderDetailBean) { %>
							<tr>
						    	<th>購入日</th>
								<td><%= bean.getCreatedAt() %></td>
							</tr>
							<% ItemDao itemDao = new ItemDao(); %>
							<tr>
								<th>商品名</th>
								<td><%= itemDao.getItemName(bean.getProductId()).getName() %></td>
							</tr>
							<tr>
								<th>価格</th>
								<td>¥<%= bean.getPrice() %></td>
							</tr>
							<tr>
								<th>個数</th>
								<td><%= bean.getAmount() %>個</td>
							</tr>
						<% } %>
						
						<% OrderDao orderDao = new OrderDao(); %>
						<% int order_id = (int)session.getAttribute("order_id"); %>
						<tr>
							<th>購入者名</th>
							<td><%= orderDao.getName(order_id).getFirstName() + orderDao.getName(order_id).getLastName() %></td>
						</tr>
						<tr>
							<th>配送住所</th>
							<td>〒<%= orderDao.getAddress(order_id).getPostalCode().substring(0,3) %>-<%= orderDao.getAddress(order_id).getPostalCode().substring(4,7) %></td>
						</tr>
						<tr>
							<th></th>
							<td><%= orderDao.getAddress(order_id).getAddress1() %><%= orderDao.getAddress(order_id).getAddress2() %><%= orderDao.getAddress(order_id).getAddress3() %></td>
						</tr>
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