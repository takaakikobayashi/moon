<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="../common/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	  	<script src="../common/bootstrap/js/bootstrap.min.js"></script>
	<title>ログイン</title>
</head>
<body>
<div class="wrapper">
	<header>
		<%@ include file="header.jsp" %>
	</header>
	<main class="login_page">
		<div class="container">
    		<h1>従業員用ログイン</h1>

			<% if (request.getAttribute("login_check") != null) { %>
				<p style="color: red;"><%= request.getAttribute("login_check") %></p>
			<% } %>
			<% if (request.getAttribute("login_error") != null) { %>
				<p style="color: red;"><%= request.getAttribute("login_error") %></p>
			<% } %>
			<form action="adminsloginservlet" method="get">
				<table class="login_form">
			    	<tbody>
			        	<tr>
			            	<th>ログインID</th>
			               	<td><input type="email" name="mail" required></td>
			            </tr>
			            <tr>
			                <th>パスワード</th>
			                <td><input type="password" name="password" required /></td>
			            </tr>
			        </tbody>
			    </table>
			
			    <div class="buttons">
			    	<input class="common_button" type="submit" name="submit"  value="ログイン"/>
			    </div>
			</form>
		</div>
    </main>
    <footer>
		<%@ include file="footer.jsp" %>
	</footer>
	</div>
</body>
</html>