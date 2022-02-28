<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script>
	  function cancelMembership() {
		  if(window.confirm('本当に退会しますか？一度退会すると再度ご利用いただくことはできません')) {
			    //OKを選んだ場合
			    return true;
			} else {
			    //キャンセルを選んだ場合
				event.preventDefault();
			}
		}
	</script>
	<title>マイページ</title>
</head>
<body>
<div class="wrapper">
	<header>
		<%@ include file="header.jsp" %>
	</header>
	<main>
		<div class="container">
			<% if(loginUser != null) { %>
			
				<h2>登録情報</h2>
				<table>
				    <tr>
				    	<th>名前日</th>
						<td><%= loginUser.getFirstName() + loginUser.getLastName() %></td>
					</tr>
					<tr>
						<th>ナマエ</th>
						<td><%= loginUser.getKanaFirstName() + loginUser.getKanaLastName() %></td>
					</tr>
					<tr>
						<th>メールアドレス</th>
						<td><%= loginUser.getMail() %></td>
					</tr>
					<tr>
						<th>電話番号</th>
						<td><%= loginUser.getPhoneNumber() %></td>
					</tr>
					<tr>
						<th>住所</th>
						<td>〒<%= loginUser.getPostalCode().substring(0,3) %>-<%= loginUser.getPostalCode().substring(4,7) %></td>
					<tr>
						<th></th>
						<td><%= loginUser.getAddress1() %><%= loginUser.getAddress2() %><%= loginUser.getAddress3() %></td>
					</tr>
				</table>
				<% session.setAttribute("loginUser",loginUser); %>
				<p><a href="editUserInfo.jsp">編集する</a></p>
					
				<h2>お気に入り</h2>
				<p><a href="myfavoriteservlet">お気に入りを見る</a></p>
				<h2>注文履歴一覧</h2>
				<p><a href="orderList.jsp">注文履歴一覧を見る</a></p>
					
				<p><a href="cancelmembershipservlet" onclick="cancelMembership()">退会する</a></p>
					
			<% } else { %>
				<p>ログインしてください。</p>
			<% } %>
		</div>
	</main>
	<footer>
		<%@ include file="footer.jsp" %>
	</footer>
</div>
</body>
</html>