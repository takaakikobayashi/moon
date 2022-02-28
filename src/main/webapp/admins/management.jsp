<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="members.model.OrderBean"%>
<%@ page import="members.model.LoginUserBean"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="../common/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  	<script src="../common/bootstrap/js/bootstrap.min.js"></script>
	<title>売上管理</title>
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
				<% ArrayList<OrderBean> earningsList = (ArrayList<OrderBean>) request.getAttribute("earnings"); %>
				<% int total_month_price01 = 0; %>
				<% int total_month_price02 = 0; %>
				<% int total_month_price03 = 0; %>
				<% int total_month_price04 = 0; %>
				<% int total_month_price05 = 0; %>
				<% int total_month_price06 = 0; %>
				<% int total_month_price07 = 0; %>
				<% int total_month_price08 = 0; %>
				<% int total_month_price09 = 0; %>
				<% int total_month_price10 = 0; %>
				<% int total_month_price11 = 0; %>
				<% int total_month_price12 = 0; %>
				<% int all_earnings = 0; %>
				<% int january_earnings = 0; %>
				<% int february_earnings = 0; %>
				<% int march_earnings = 0; %>
				<% int april_earnings = 0; %>
				<% int may_earnings = 0; %>
				<% int june_earnings = 0; %>
				<% int july_earnings = 0; %>
				<% int august_earnings = 0; %>
				<% int september_earnings = 0; %>
				<% int october_earnings = 0; %>
				<% int november_earnings = 0; %>
				<% int december_earnings = 0; %>
				<h3>月ごとの売上</h3>
				<table>
					<tr>
						<th>1月</th>
						<th>2月</th>
						<th>3月</th>
						<th>4月</th>
						<th>5月</th>
						<th>6月</th>
						<th>7月</th>
						<th>8月</th>
						<th>9月</th>
						<th>10月</th>
						<th>11月</th>
						<th>12月</th>
					</tr>
					<% for (OrderBean bean : earningsList) { %>
						<% bean.getTotalPrice(); %>
						<% Calendar cl = Calendar.getInstance(); %>
						<% SimpleDateFormat msdf = new SimpleDateFormat("MM"); %>
						<% String month = msdf.format(bean.getCreatedAt()); %>
						<tr>
							<% if (month.equals("01")) { %>
								<% int month_price01 = bean.getTotalPrice(); %>
								<% total_month_price01 = total_month_price01 + month_price01;  %>
							<% } else if (month.equals("02")) { %>
								<% int month_price02 = bean.getTotalPrice(); %>
								<% total_month_price02 = total_month_price02 + month_price02;  %>
							<% } else if (month.equals("03")) { %>
								<% int month_price03 = bean.getTotalPrice(); %>
								<% total_month_price03 = total_month_price03 + month_price03;  %>
							<% } else if (month.equals("04")) { %>
								<% int month_price04 = bean.getTotalPrice(); %>
								<% total_month_price04 = total_month_price04 + month_price04;  %>
							<% } else if (month.equals("05")) { %>
								<% int month_price05 = bean.getTotalPrice(); %>
								<% total_month_price05 = total_month_price05 + month_price05;  %>
							<% } else if (month.equals("06")) { %>
								<% int month_price06 = bean.getTotalPrice(); %>
								<% total_month_price06 = total_month_price06 + month_price06;  %>
							<% } else if (month.equals("07")) { %>
								<% int month_price07 = bean.getTotalPrice(); %>
								<% total_month_price07 = total_month_price07 + month_price07;  %>
							<% } else if (month.equals("08")) { %>
								<% int month_price08 = bean.getTotalPrice(); %>
								<% total_month_price08 = total_month_price08 + month_price08;  %>
							<% } else if (month.equals("09")) { %>
								<% int month_price09 = bean.getTotalPrice(); %>
								<% total_month_price09 = total_month_price09 + month_price09;  %>
							<% } else if (month.equals("10")) { %>
								<% int month_price10 = bean.getTotalPrice(); %>
								<% total_month_price10 = total_month_price10 + month_price10;  %>
							<% } else if (month.equals("11")) { %>
								<% int month_price11 = bean.getTotalPrice(); %>
								<% total_month_price11 = total_month_price11 + month_price11;  %>
							<% } else if (month.equals("12")) { %>
								<% int month_price12 = bean.getTotalPrice(); %>
								<% total_month_price12 = total_month_price12 + month_price12;  %>
							<% } %>
							<% all_earnings += bean.getTotalPrice(); %>
					<% } %>
							<td>¥<%= total_month_price01 %></td>
							<td>¥<%= total_month_price02 %></td>
							<td>¥<%= total_month_price03 %></td>
							<td>¥<%= total_month_price04 %></td>
							<td>¥<%= total_month_price05 %></td>
							<td>¥<%= total_month_price06 %></td>
							<td>¥<%= total_month_price07 %></td>
							<td>¥<%= total_month_price08 %></td>
							<td>¥<%= total_month_price09 %></td>
							<td>¥<%= total_month_price10 %></td>
							<td>¥<%= total_month_price11 %></td>
							<td>¥<%= total_month_price12 %></td>
						</tr>
				</table>
				<p>売上合計：¥<%= all_earnings %></p>
				<h2>会員一覧</h2>
				<p><a href="memberList.jsp">会員一覧へ</a></p>
				<h2>注文履歴一覧</h2>
				<p><a href="orderList.jsp">注文履歴一覧へ</a></p>
			</div>
		</main>
	<% } %>
	<footer>
		<%@ include file="footer.jsp" %>
	</footer>
	</div>
</body>
</html>