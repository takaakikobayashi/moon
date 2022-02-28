<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="members.model.LoginUserBean"%>
<%@ page import="members.model.MemberDao"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="../common/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  	<script src="../common/bootstrap/js/bootstrap.min.js"></script>
	<title>会員詳細</title>
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
				<div class="row">
					<% LoginUserBean memberBean = (LoginUserBean) request.getAttribute("memberBean"); %>
		
					<table>
					    <tr>
							<th>名前</th>
							<td><%= memberBean.getFirstName() + memberBean.getLastName() %></td>
						</tr>
						<tr>
							<th>ナマエ</th>
							<td><%= memberBean.getKanaFirstName() + memberBean.getKanaLastName() %></td>
						</tr>
						<tr>
							<th>メールアドレス</th>
							<td><%= memberBean.getMail() %></td>
						</tr>
						<tr>
							<th>郵便番号</th>
							<td>〒<%= memberBean.getPostalCode().substring(0,3) %>-<%= memberBean.getPostalCode().substring(4,7) %></td>
						</tr>
						<tr>
							<th></th>
							<td><%= memberBean.getAddress1() %><%= memberBean.getAddress2() %><%= memberBean.getAddress3() %></td>
						</tr>
					</table>
				</div>
			</div>
		</main>
		<footer>
			<%@ include file="footer.jsp" %>
		</footer>
	<% } %>
</div>
</body>
</html>