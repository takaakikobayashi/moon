<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="members.model.OrderDao"%>
<%@ page import="common.model.ItemDao"%>
<%@ page import="members.model.OrderBean"%>
<%@ page import="members.model.OrderDetailBean"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="../common/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  	<script src="../common/bootstrap/js/bootstrap.min.js"></script>
	<title>製作対応商品</title>
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
				<h3 class="title">対応必要商品</h3>
				<% if (order_list.isEmpty()) { %>
					<p>対応必要商品はありません</p>
				<% } else { %>
					<table border="1">
						<tr>
							<th>購入日</th>
							<th>商品名</th>
							<th>ステータス</th>
							<th>ステータス更新</th>
						</tr>
						<% for (OrderBean bean : order_list) {%>
						    <form action="updateorderstatusservlet" method="get">
								<tr>
							    	<td><%= bean.getCreatedAt() %></td>
							      	<% int item_id = bean.getProductId(); %>
									<td><%= itemDao.selectItem(item_id).getName() %></td>
									<td>
										<select name="orderstatus">
											<% if (bean.getProductionStatus() == 1) { %>
											    <option value="1" selected>入金確認中</option>
											    <option value="2">製作待ち</option>
											    <option value="3">製作中</option>
											    <option value="4">製作完了</option>
											    <option value="5">発送完了</option>
											    <option value="6">キャンセル</option>
											<% } else if (bean.getProductionStatus() == 2) { %>
											    <option value="2" selected>製作待ち</option>
											    <option value="3">製作中</option>
											    <option value="4">製作完了</option>
											    <option value="5">発送完了</option>
											    <option value="6">キャンセル</option>
											<% } else if (bean.getProductionStatus() == 3) { %>
											    <option value="3" selected>製作中</option>
											    <option value="4">製作完了</option>
											    <option value="5">発送完了</option>
											    <option value="6">キャンセル</option>
											<% } else if (bean.getProductionStatus() == 4) { %>
											    <option value="4" selected>製作完了</option>
											    <option value="5">発送完了</option>
											    <option value="6">キャンセル</option>
											<% } else if (bean.getProductionStatus() == 5) { %>
											    <option value="5" selected>発送完了</option>
											    <option value="6">キャンセル</option>
											<% } else if (bean.getProductionStatus() == 6) { %>
											    <option value="6">キャンセル</option>
											<% } %>
										</select>
									</td>
									<input type="hidden" name="order_id" value="<%= bean.getOrderId() %>" />
									<td><input type="submit" value="ステータスを更新する"></td>
								</tr>
							</form>
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