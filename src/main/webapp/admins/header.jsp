<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="admins.model.LoginAdminBean" %>
<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="../common/css/header.css">
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="../common/bootstrap/js/bootstrap.min.js"></script>
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
	
		<!-- ログインしていない場合 -->
		<% if(session.getAttribute("admin") == null) { %>
			<h1 class="logo"><a href="index.jsp"><img src="../common/images/logo.png" alt="画像" width="200" height="50"></a></h1>
		    <nav class="nav">
		      <ul class="menu-group">
		        <li class="menu-item"><a href="login.jsp">ログイン</a></li>
		      </ul>
		    </nav>
	    <!-- ログインしている場合 -->
	    <% } else { %>
		    <h1 class="logo"><a href="index.jsp"><img src="../common/images/logo.png" alt="画像" width="200" height="50"></a></h1>
		    <nav class="nav">
		      <ul class="menu-group">
		        <li class="menu-item"><a href="managementservlet">売上管理</a></li>
		        <li class="menu-item"><a href="itemListView.jsp">商品一覧</a></li>
		        <li class="menu-item"><a href="orderStatus.jsp">製作対応商品</a></li>
		        <li class="menu-item"><a href="adminslogoutservlet" onclick="exec()">ログアウト</a></li>
		      </ul>
		    </nav>
	    <% } %>
    
	</header>
</body>
</html>