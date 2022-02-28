<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="members.model.OrderDao" %>
<%@ page import="members.model.ReviewDao" %>
<%@ page import="members.model.ReviewBean" %>
<% String item_id = request.getParameter("item_id"); %>
<!DOCTYPE html>
<html>
<link href="css/review.css" rel="stylesheet">
<head>
	<meta charset="UTF-8">
	<title>レビュー</title>
</head>
<body>
<div class="wrapper">
	<header>
		<%@ include file="header.jsp" %>
	</header>
	<main>
		<% int member_id = loginUser.getMemberId(); %>
		<% OrderDao orderdao = new OrderDao(); %>
		<% ReviewDao reviewdao = new ReviewDao(); %>
		<div class="container">
			<h2>レビュー</h2>
			<!-- 商品を注文したことがあり、レビューをまだ書いたことがない -->
			<% if (orderdao.checkOrder(item_id,member_id) == true && reviewdao.checkReview(item_id,member_id) == false) { %>
				<form action="reviewservlet" method="get">
					<table class="review_form">
						<tbody>
			            	<tr>
			                	<th>タップで評価する：</th>
			                    <td class="rate-form">
			                        <input id="star5" type="radio" name="rate" value="5">
									<label for="star5">★</label>
									<input id="star4" type="radio" name="rate" value="4">
									<label for="star4">★</label>
									<input id="star3" type="radio" name="rate" value="3">
									<label for="star3">★</label>
									<input id="star2" type="radio" name="rate" value="2">
									<label for="star2">★</label>
				                    <input id="star1" type="radio" name="rate" value="1">
									<label for="star1">★</label>
								</td>
			                </tr>
			                <tr>
			                    <th>レビュータイトル</th>
			                    <td><input type="text" name="review_title"></td>
			                </tr>
			                <tr>
			                    <th>レビュー内容</th>
			                    <td><textarea name="review"></textarea></td>
			                </tr>
			            </tbody>
		            </table>
		                    
		            <input type="hidden" name="item_id" value=<%= item_id %> />
		            <input type="hidden" name="member_id" value=<%= member_id %> />
		            
		            <div class="buttons">
		                <input class="common_button" type="submit" name="submit"  value="レビュー投稿をする"/>
		            </div>
		        </form>
		        <!-- 商品を注文したことがあり、すでにレビューも書いている -->
		    <% } else if (orderdao.checkOrder(item_id,member_id) == true && reviewdao.checkReview(item_id,member_id) == true) { %>
		        <% ReviewBean reviewEdit = reviewdao.getReview(Integer.parseInt(item_id),member_id); %>
		        <form action="revieweditservlet" method="get">
					<table class="reviewEdit_form">
		        		<tbody>
		                	<tr>
		                    	<th>評価</th>
		                    	<% if (reviewEdit.getReviewStar() == 5) { %>
			                        <td class="rate-form">
				                        <input id="star5" type="radio" name="rate" value="5" checked>
										<label for="star5">★</label>
										<input id="star4" type="radio" name="rate" value="4">
										<label for="star4">★</label>
										<input id="star3" type="radio" name="rate" value="3">
										<label for="star3">★</label>
										<input id="star2" type="radio" name="rate" value="2">
										<label for="star2">★</label>
					                    <input id="star1" type="radio" name="rate" value="1">
										<label for="star1">★</label>
									</td>
								<% } else if (reviewEdit.getReviewStar() == 4) { %>
									<td class="rate-form">
				                        <input id="star5" type="radio" name="rate" value="5">
										<label for="star5">★</label>
										<input id="star4" type="radio" name="rate" value="4" checked>
										<label for="star4">★</label>
										<input id="star3" type="radio" name="rate" value="3">
										<label for="star3">★</label>
										<input id="star2" type="radio" name="rate" value="2">
										<label for="star2">★</label>
					                    <input id="star1" type="radio" name="rate" value="1">
										<label for="star1">★</label>
									</td>
								<% } else if (reviewEdit.getReviewStar() == 3) { %>
									<td class="rate-form">
				                        <input id="star5" type="radio" name="rate" value="5">
										<label for="star5">★</label>
										<input id="star4" type="radio" name="rate" value="4">
										<label for="star4">★</label>
										<input id="star3" type="radio" name="rate" value="3" checked>
										<label for="star3">★</label>
										<input id="star2" type="radio" name="rate" value="2">
										<label for="star2">★</label>
					                    <input id="star1" type="radio" name="rate" value="1">
										<label for="star1">★</label>
									</td>
								<% } else if (reviewEdit.getReviewStar() == 2) { %>
									<td class="rate-form">
				                        <input id="star5" type="radio" name="rate" value="5">
										<label for="star5">★</label>
										<input id="star4" type="radio" name="rate" value="4">
										<label for="star4">★</label>
										<input id="star3" type="radio" name="rate" value="3">
										<label for="star3">★</label>
										<input id="star2" type="radio" name="rate" value="2" checked>
										<label for="star2">★</label>
					                    <input id="star1" type="radio" name="rate" value="1">
										<label for="star1">★</label>
									</td>
								<% } else if (reviewEdit.getReviewStar() == 1) { %>
									<td class="rate-form">
				                        <input id="star5" type="radio" name="rate" value="5">
										<label for="star5">★</label>
										<input id="star4" type="radio" name="rate" value="4">
										<label for="star4">★</label>
										<input id="star3" type="radio" name="rate" value="3">
										<label for="star3">★</label>
										<input id="star2" type="radio" name="rate" value="2">
										<label for="star2">★</label>
					                    <input id="star1" type="radio" name="rate" value="1" checked>
										<label for="star1">★</label>
									</td>
								<% } %>
		                    </tr>
		                    <tr>
		                    	<th>レビュータイトル</th>
		                        <td><input type="text" name="review_title" value="<%= reviewEdit.getReviewTitle() %>"></td>
		                    </tr>
		                    <tr>
		                    	<th>レビュー内容</th>
		                        <td><textarea name="review"><%= reviewEdit.getReview() %></textarea></td>
		                    </tr>
		            	</tbody>
		            </table>
		            
		            <input type="hidden" name="review_id" value="<%= reviewEdit.getReviewId() %>" />
		            <input type="hidden" name="member_id" value=<%= member_id %> />
		            
		            <div class="buttons">
		                <input class="common_button" type="submit" name="submit"  value="変更を保存する"/>
		            </div>
		        </form>
		        <!-- 商品を注文したことがない -->
		    <% } else if (orderdao.checkOrder(item_id,member_id) == false) { %>
		        <p>購入した商品のレビューをすることができます。</p>
		    <% } %>
		</div>
	</main>
	<footer>
		<%@ include file="footer.jsp" %>
	</footer>
</div>
</body>
</html>