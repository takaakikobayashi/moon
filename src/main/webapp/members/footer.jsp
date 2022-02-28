<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="common.model.CategoryDao"%>
<%@ page import="common.model.CategoryBean"%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="../common/css/footer.css">
  <link rel="stylesheet" href="../common/css/common.css">
  <link href="../common/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="../common/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
  <footer class="footer">
  	<div class="container-fluid">
  		<div class="row">
  			<div class="col-md-3">
  				<ul class="list-unstyled">
	  				<li><a href="aboutShop.jsp">支払い方法</a></li><br>
	  				<li><a href="aboutShop.jsp">キャンセルについて</a></li><br>
	  				<li><a href="aboutShop.jsp">配送について</a></li>
  				</ul>
  			</div>
  			<div class="col-md-3">
  				<ul class="list-unstyled">
  					<li>商品カテゴリ</li><br>
  					<% if (categoryBeanList.isEmpty()) { %>
  						<p>商品カテゴリが登録されていません</p>
					<% } else { %>
						<% for (CategoryBean bean : categoryBeanList) {%>
							<% if (bean.getIsActive() == 1) { %>
								<p><a href="itemlistservlet?category_id=<%= bean.getCategoryId() %>"><%= bean.getName() %></a></p>
							<% } %>
						<% } %>
					<% } %>
  				</ul>
  			</div>
  			<div class="col-md-3">
  				<ul class="list-unstyled">
  					<li>予算から選ぶ</li><br>
  					<li><a href="itemlistservlet?check_price=under3000">2000円台以下の商品</a></li><br>
  					<li><a href="itemlistservlet?check_price=3000">3000円台の商品</a></li><br>
  					<li><a href="itemlistservlet?check_price=4000">4000円台の商品</a></li><br>
  					<li><a href="itemlistservlet?check_price=over5000">5000台円以上の商品</a></li><br>
  				</ul>
  			</div>
  			<div class="col-md-3">
  				<ul class="list-unstyled">
  				<li><a href="aboutShop.jsp">お店について</a></li><br>
  				<li>お問い合わせ</li><br>
  				<li>メールアドレス</li>
  				<li>moon@email.com</li><br>
  				<li>電話番号</li>
  				<li>080-0000-0000</li>
  				</ul>
  			</div>
  		</div>
  		<div class="row">
	  		<div class="col-md-6">
	  			<ul class="list-unstyled">
	  				<li><img src="../common/images/logo.png" alt="画像" width="120" height="30"></li>
	  				<li>©️ Moon All Rights Reserved.</li>
	  			</ul>
	  		</div>
	  		<div class="col-md-3">
	  			<p><a href="notation.jsp">特定商取引法について</a></p>
	  		</div>
	  		<div class="col-md-3">
	  			<p><a href="privacyPolicy.jsp">プライバシーポリシー</a></p>
	  		</div>
  		</div>
  	</div>
  </footer>
</body>
</html>