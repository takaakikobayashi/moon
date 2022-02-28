<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/footer.css">
	<title>ログイン</title>
</head>
<body>
<div class="wrapper">
	<header>
		<%@ include file="header.jsp" %>
	</header>
	<main class="login_page">
	<div class="container">
    	<h1>ログイン</h1>
        <p>会員登録がお済みのお客様</p>
        <% if (request.getAttribute("login_error") != null) { %>
        	<p style="color: red;"><%= request.getAttribute("login_error") %></p>
        <% } %>

	        <form action="loginservlet" method="get">
	        	<table class="login_form">
	            	<tbody>
	                	<tr>
	                    	<th>ログインID</th>
	                        <td><input type="email" name="mail" required></td>
	                    </tr>
	                    <tr>
	                        <th>パスワード</th>
	                        <td><input type="password" name="password" required/></td>
	                    </tr>
	                </tbody>
	            </table>
	
	            <div class="buttons">
	                <input class="common_button" type="submit" name="submit"  value="ログイン"/>
	            </div>
	        </form>
	        
	        <p><a href="signup.jsp">会員登録がまだお済みでないお客様はこちら</a></p>
    </div>
    </main>
    <footer>
		<%@ include file="footer.jsp" %>
	</footer>
	</div>
</body>
</html>