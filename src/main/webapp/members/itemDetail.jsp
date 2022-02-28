<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="common.model.ItemBean"%>
<%@ page import="members.model.ReviewDao"%>
<%@ page import="members.model.ReviewBean"%>
<%@ page import="members.model.FavoriteDao"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="../common/css/itemDetail.css" rel="stylesheet">
 	<link href="../common/bootstrap/css/bootstrap.min.css" rel="stylesheet">
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
 	<script src="../common/bootstrap/js/bootstrap.min.js"></script>
	<title>商品詳細</title>
</head>
<body>
<div class="wrapper">
	<header>
		<%@ include file="header.jsp" %>
	</header>
	<main>
		<div class="container">
			<div class="row">
				<% ItemBean itemBean = (ItemBean) request.getAttribute("itemBean"); %>
				<% ReviewDao reviewDao = new ReviewDao(); %>
				<% int item_id = itemBean.getProductId(); %>
				<% int quantity = reviewDao.getReviewQuantity(item_id);%>
				<% int sum = reviewDao.getReviewSum(item_id); %>
	
				<% if (itemBean != null) { %>
					<div class="itemDetail">
						<div class="col-md-5">
							<div class="itemImage">
								<% if ( itemBean.getImageBlob() != null) { %>
									<p style="padding: 10px;"><img src="membersgetimageservlet?item_id=<%= itemBean.getProductId() %>" alt="画像" width="300" height="300"></p>
								<% } else { %>
									<p style="padding: 10px;"><img src="../common/images/noitem.png" alt="画像" width="300" height="300"></p>
								<% } %>
							</div>
							<div style="padding-left: 20px;">
								<% if (quantity == 0) { %>
									<p>レビューはありません</p>
								<% } else { %>
									<% double review_average = sum/quantity; %>
									<p>レビュー（★<%= review_average %>）</p>
									<% ArrayList<ReviewBean> review_list = reviewDao.getReviewList(item_id); %>
									<% if (review_list != null) { %>
									
										<table border="1">
										    <% for (ReviewBean bean : review_list) {%>
										    	<% int review_star = bean.getReviewStar(); %>
										    
											    <tr>
												    <%if (review_star == 5) { %>
												      <td>★★★★★</td>
												    <%} else if (review_star == 4) { %>
												    	<td>★★★★☆</td>
												    <%} else if (review_star == 3) { %>
												    	<td>★★★☆☆</td>
												    <%} else if (review_star == 2) { %>
												    	<td>★★☆☆☆</td>
												    <%} else if (review_star == 1) { %>
												    	<td>★☆☆☆☆</td>
												    <% } %>
											      </tr>
											      <tr>
											      	<th class="float-none"><%= bean.getReviewTitle() %></th>
											      </tr>
											      <tr>
											      	<td class="float-none"><%= bean.getReview() %></td>
											    	</tr>
											<% } %>
									  	</table>
									  	
									<% }%>
								<% } %>
							</div>
						</div>
						<div class="col-md-7">
							<div style="padding-left: 50px; padding-top: 20px;">
								<% if (loginUser != null) { %>
								
									<% FavoriteDao favoriteDao = new FavoriteDao(); %>
									<% if (favoriteDao.checkFavorite(loginUser.getMemberId(),itemBean.getProductId())) { %>
										<p><a href="unfavoriteservlet?item_id=<%= itemBean.getProductId() %>">お気に入り解除</a></p>
									<% } else { %>
										<p><a href="favoriteservlet?item_id=<%= itemBean.getProductId() %>">お気に入り登録</a></p>
									<% } %>
									
								<% } %>
								
								<p><%= itemBean.getName() %></p>
								<p><%= itemBean.getIntroduction() %></p><br>
								<p>価格： ¥<%= itemBean.getPrice() %>(税込)</p>
								<% double excluding_tax = itemBean.getPrice()*0.01; %>
								<p><%= Math.round(excluding_tax)%>ポイント進呈</p>
								
								<% if (itemBean.getIsSailing() == 1) { %>
									<form action="cartaddservlet" method="get">
										<input type="hidden" name="item_id" value="<%=itemBean.getProductId()%>">
										<p>数量：<input type="number" name="amount" value="1" min="1" max="10" step="1"></p>
										<input type="submit" value="カートに追加">
									</form>
								<% } else { %>
									<p style="color: red;">売り切れ</p>
								<% } %>
								
								<a href="aboutShop.jsp">キャンセルについて</a>
								<% if (loginUser != null) { %>
									<a href="review.jsp?item_id=<%= itemBean.getProductId() %>">レビューを書く</a>
								<% } %>
								<p>商品詳細</p>
								<table border="1">
									<tr>
				      					<th>原材料</th>
				      				</tr>
				      				<tr>
				      					<td><%= itemBean.getIngredient() %></td>
				      				</tr>
				      			</table>
				      			<table border="1">
									<tr>
				      					<th>アレルゲン※</th>
				      				</tr>
				      				<tr>
				      					<td><%= itemBean.getAllergy() %></td>
				      				</tr>
				      			</table>
				      			<p>※原材料中に使用されているアレルゲン(27品目中)を表示しております。</p>
							</div>
						</div>
					</div>
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