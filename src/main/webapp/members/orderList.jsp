<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="members.model.OrderDao"%>
<%@ page import="common.model.ItemDao"%>
<%@ page import="members.model.OrderBean"%>
<%@ page import="java.util.HashSet"%>
<%@ page import="java.util.Set"%>
<%@ page import="members.model.OrderDetailBean"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>注文履歴一覧</title>
</head>
<body>
<div class="wrapper">
	<header>
		<%@ include file="header.jsp" %>
	</header>
	<main>
		<div class="container">
			<% if(loginUser != null) { %>
			
				<% OrderDao orderDao = new OrderDao(); %>
				<% ItemDao itemDao = new ItemDao(); %>
				<% ArrayList<OrderBean> order_list = orderDao.getOrderList(); %>
				<h2>注文履歴一覧</h2>
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
								    <td><%= bean.getPrice() %></td>
								    <td><p class="item_button"><a href="orderdetailservlet?order_id=<%= bean.getOrderId() %>&order_status=<%= bean.getOrderStatus() %>">注文詳細</a></p></td>
								    <% session.setAttribute("order_check",bean.getOrderId()); %>
								</tr>
	    					<% } else { %>
						    	<tr>
						      		<td><%= bean.getCreatedAt() %></td>
						      		<% int item_id = bean.getProductId(); %>
								    <td><%= itemDao.selectItem(item_id).getName() %></td>
								    <td><%= bean.getPrice() %></td>
								    <td><p class="item_button"><a href="orderdetailservlet?order_id=<%= bean.getOrderId() %>&order_status=<%= bean.getOrderStatus() %>">注文詳細</a></p></td>
								    <% session.setAttribute("order_check",bean.getOrderId()); %>
								</tr>
							<% } %>
				    	<% } %>
					</table>
				<% } %>
				
			<% } else { %>
			
				<p></p>
				
			<% } %>
		</div>
	</main>
	<footer>
		<%@ include file="footer.jsp" %>
	</footer>
</div>
</body>
</html>