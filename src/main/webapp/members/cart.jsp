<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="members.model.CartBean"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="css/cart.css" rel="stylesheet">
	<title>カート</title>
</head>
<body>
<div class="wrapper">
	<header>
		<%@ include file="header.jsp" %>
	</header>
	<main>
		<div class="container">
	 		<div class="row">
	
				<% if (session.getAttribute("cart_item") != null) { %>
					<%  ArrayList<CartBean> cartList = (ArrayList<CartBean>) session.getAttribute("cart_item"); %>
					<% int i = 0; %>
					<% for (CartBean bean : cartList) {%>
						<div class="cartItem">
							<div class="itemImage">
								<% if ( bean.getImageBlob() != null) { %>
									<a href="itemdetailservlet?item_id=<%= bean.getProductId() %>">
										<p style="padding: 20px;"><img src="membersgetimageservlet?item_id=<%= bean.getProductId() %>" alt="画像" width="80" height="80"></p>
									</a>
								<% } else { %>
									<a href="itemdetailservlet?item_id=<%= bean.getProductId() %>">
										<p style="padding: 20px;"><img src="../common/images/noitem.png" alt="画像" width="80" height="80"></p>
									</a>
								<% } %>
							</div>
							<div>
								<a href="itemdetailservlet?item_id=<%= bean.getProductId() %>">
									<p><%= bean.getName()%></p>
									<p>価格： ¥<%= bean.getPrice()%></p>
								</a>
								<form action="amounteditservlet" method="get">
									<input type="hidden" name="cart_id" value="<%=i%>">
									<p>数量： <input type="number" name="amount" value="<%= bean.getAmount() %>" min="1" max="10" step="1"></p>
									<input type="submit" value="更新する">
								</form>
								<a href="cartdeleteservlet?cart_id=<%= i %>">カートから削除する</a>
								<% i++; %>
							</div>
						</div>
					<% } %>
					<% if (cartList.size() != 0) {%>
						<p><a href="orderInformation.jsp">購入手続きへ進む</a></p>
						<p><a href="cartemptyservlet">カートを空にする</a></p>
					<% } else { %>
						<p>カートに追加された商品はありません</p>
					<% } %>
				<% } else { %>
					<p>カートに追加された商品はありません</p>
				<% } %>
			
			</div>
		</div>
	</main>
	<footer>
		<%@ include file="footer.jsp" %>
	</footer>
</div>
</body>
</html>