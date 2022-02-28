<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="members.model.OrderDao"%>
<%@ page import="members.model.MemberDao"%>
<%@ page import="members.model.LoginUserBean"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="../common/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  	<script src="../common/bootstrap/js/bootstrap.min.js"></script>
	<title>会員一覧</title>
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
				<% MemberDao memberDao = new MemberDao(); %>
				<% ArrayList<LoginUserBean> member_list = memberDao.getMemberList(); %>
				<h3 class="title">会員一覧</h3>
				<table border="1">
				    <tr>
						<th>名前</th>
					    <th>ナマエ</th>
					    <th>メールアドレス</th>
					    <th>会員詳細</th>
				    </tr>
				    <% for (LoginUserBean bean : member_list) {%>
					    <tr>
					  		<td><%= bean.getFirstName() + bean.getLastName() %></td>
							<td><%= bean.getKanaFirstName() + bean.getKanaLastName() %></td>
							<td><%= bean.getMail() %></td>
							<td><p class="common_button"><a href="memberdetailservlet?member_id=<%= bean.getMemberId() %>">会員詳細を確認する</a></p></td>
						</tr>
				    <% } %>
				</table>
			</div>
		</main>
		<footer>
			<%@ include file="footer.jsp" %>
		</footer>
	<% } %>
</div>
</body>
</html>