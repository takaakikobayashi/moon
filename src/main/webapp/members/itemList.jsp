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
	<link rel="stylesheet" href="../common/css/itemList.css">
	<link href="../common/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  	<script src="../common/bootstrap/js/bootstrap.min.js"></script>
	<title>商品一覧</title>
</head>
<body>
<div class="wrapper">
	<header>
		<%@ include file="header.jsp" %>
	</header>
	<main>
		<div class="container">
			<div class="row">
				<!-- 	カテゴリ -->
				<div class="col-md-2">
			
					<% for (CategoryBean bean : categoryBeanList) {%>
						<% if (bean.getIsActive() == 1) { %>
							<p><a href="itemlistservlet?category_id=<%= bean.getCategoryId() %>"><%= bean.getName() %></a></p>
						<% } %>
					<% } %>
					
				</div>
				
				<!-- 商品一覧 -->
				<div class="col-md-10"> 
					<% ArrayList<ItemBean> itemList = (ArrayList<ItemBean>) request.getAttribute("itemList"); %>
		
					<% if (itemList.isEmpty()) { %>
						<p>商品が見つかりませんでした。</p>
					<% } else { %>
						<h3 class="title">商品一覧</h3>
						<div id="item" class="clearfix">
							<div class="itemlist">
								<% for (ItemBean bean : itemList) {%>
									<% if (bean.getIsSailing() != 3) { %>
										<li>
											<dl>
												<% if ( bean.getImageBlob() != null) { %>
													<dt><img src="membersgetimageservlet?item_id=<%= bean.getProductId() %>" alt="画像" width="100" height="100"></dt>
												<% } else { %>
													<dt><img src="../common/images/noitem.png" alt="画像" width="100" height="100"></dt>
												<% } %>
												<dd><p><%= bean.getName() %></p></dd>
												<dd><p>価格： ¥<%= bean.getPrice() %></p></dd>
												<dd><p class="item_button"><a href="itemdetailservlet?item_id=<%= bean.getProductId() %>">商品詳細</a></p></dd>
											</dl>
										</li>
									<% } %>
								<% } %>
							</div>
						</div>
					<% } %>
					
				</div>
				
			</div>
		</div>
	</main>
	<footer>
		<%@ include file="footer.jsp" %>
	</footer>
</div>
</body>
</html>