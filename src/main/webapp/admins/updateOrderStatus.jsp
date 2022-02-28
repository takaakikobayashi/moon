<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="../common/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  	<script src="../common/bootstrap/js/bootstrap.min.js"></script>
	<title>注文ステータス更新</title>
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
				<form action="updateorderstatusservlet" method="post">
					<% String order_id = request.getParameter("order_id"); %>
					<table class="register_form">
						<tbody>
							<tr>
								<th>ステータスの更新</th>
								<td><input type="radio" name="orderstatus" value="2" required>製作待ち</td>
								<td><input type="radio" name="orderstatus" value="3" required>製作中</td>
								<td><input type="radio" name="orderstatus" value="4" required>製作完了</td>
								<td><input type="radio" name="orderstatus" value="5" required>発送完了</td>
								<td><input type="radio" name="orderstatus" value="6" required>キャンセル</td>
							</tr>
						</tbody>
					</table>
						
					<input type="hidden" name="order_id" value="order_id" />
						
					<div class="buttons">
			        	<input class="common_button" type="submit" name="submit"  value="更新"/>
			        </div>
				</form>
			</div>
		</main>
		<footer>
			<%@ include file="footer.jsp" %>
		</footer>
	<% } %>
</div>
</body>
</html>