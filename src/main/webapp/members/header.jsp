<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="common.model.CategoryDao"%>
<%@ page import="common.model.CategoryBean"%>
<%@ page import="members.model.LoginUserBean" %>
<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="../common/css/header.css">
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<link href="../common/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="../common/bootstrap/js/bootstrap.min.js"></script>
	<% LoginUserBean loginUser = (LoginUserBean)session.getAttribute("member"); %>
	<script>
		function exec() {
			if(window.confirm('本当にログアウトしますか？')) {
			    //OKを選んだ場合
			    return true;
			} else {
			    //キャンセルを選んだ場合
				event.preventDefault();
			}
		}
	</script>
</head>
<body>
	<header>
		<h1 class="logo"><a href="index.jsp"><img src="../common/images/logo.png" alt="画像" width="200" height="50"></a></h1>
		<!-- ログインしていない場合 -->
		<% if(loginUser == null) { %>
		    <nav class="nav">
		      <ul class="menu-group">
		        <li class="menu-item"><a href="signup.jsp">新規登録</a></li>
		        <li class="menu-item"><a href="login.jsp">ログイン</a></li>
		        <li class="menu-item"><a href="itemListView.jsp">商品一覧</a></li>
		        <li class="menu-item"><a href="cart.jsp">カート</a></li>
		        <li class="menu-item">
		        	<form action="searchservlet" method="post" accept-charset="UTF-8">
		        		<input type="search" style="width: 150px;" name="search_word">
		        		<input type="submit" value="検索"/>
		        	</form>
		        </li>
		      </ul>
		    </nav>
	    <!-- ログインしている場合 -->
	    <% } else { %>
		    <nav class="nav">
		      <ul class="menu-group">
		      	<li class="menu-item"><%= loginUser.getFirstName() %>さん</li>
		        <li class="menu-item"><a href="mypage.jsp">マイページ</a></li>
		        <li class="menu-item"><a href="logoutservlet" onclick="exec()">ログアウト</a></li>
		        <li class="menu-item"><a href="itemListView.jsp">商品一覧</a></li>
		        <li class="menu-item"><a href="cart.jsp">カート</a></li>
		        <li class="menu-item">
		        	<form action="searchservlet" method="post" accept-charset="UTF-8">
		        		<input type="search" style="width: 150px;" name="search_word">
		        		<input type="submit" value="検索"/>
		        	</form>
		        </li>
		      </ul>
		    </nav>
	    <% } %>
	    <% CategoryDao categoryDao = new CategoryDao(); %>
		<% ArrayList<CategoryBean> categoryBeanList  = categoryDao.selectcategory(); %>
	</header>
</body>
</html>