<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>会員登録</title>
</head>
<body>
<div class="wrapper">
	<header>
		<%@ include file="header.jsp" %>
	</header>
	<main>
		<div class="container">
			<h2>会員登録</h2><br>
			会員登録をしていただくと便利にお買い物ができます。<br>
			1．お買い物ごとにポイントがつきます。（1ポイント＝1円でご利用可能）<br>
			2．ご登録の会員情報で購入時のお客様情報入力省略可能<br>
			3．過去の注文履歴を閲覧いただけます<br>
			4．ご注文から配送までご状況を確認いただけます<br>
			<% if (session.getAttribute("signup_error") != null) { %>
		        <p style="color: red;"><%= session.getAttribute("signup_error") %></p>
		        <% session.removeAttribute("signup_error"); %>
	        <% } %>
			<form action="memberregister" method="get">
				<p>下記の内容をご入力の上お進みください</p><br>
				<table class="register_form">
					<tbody>
						<tr>
							<th>氏名（姓）</th>
							<td><input type="text" name="first_name" required></td>
						</tr>
						<tr>
							<th>氏名（名）</th>
							<td><input type="text" name="last_name" required></td>
						</tr>
						<tr>
							<th>氏名（セイ）</th>
							<td><input type="text" name="kana_first_name" required></td>
						</tr>
						<tr>
							<th>氏名（メイ）</th>
							<td><input type="text" name="kana_last_name" required></td>
						</tr>
						<tr>
							<th>Email</th>
							<td><input type="email" name="mail" required></td>
						</tr>
						<tr>
							<th>パスワード</th>
							<td><input type="password" name="password" required></td>
						</tr>
						<tr>
							<th>郵便番号※ハイフンなし</th>
							<td><input type="text" name="postal_code" pattern="\d{3}\d{4}" autocomplete="postal-code" required></td>
						</tr>
						<tr>
							<th>都道府県</th>
							<td><input type="text" name="address1" required></td>
						</tr>
						<tr>
							<th>市区町村・番地</th>
							<td><input type="text" name="address2" required></td>
						</tr>
						<tr>
							<th>建物名・部屋番号</th>
							<td><input type="text" name="address3"></td>
						</tr>
						<tr>
							<th>電話番号※ハイフンなし</th>
							<td><input type="tel" name="phone_number" autocomplete="tel" required></td>
						</tr>
						<tr>
							<th>メールマガジンの送付</th>
							<td><input type="radio" name="newsletter" value="true" required>可</td>
							<td><input type="radio" name="newsletter" value="false" required>不可</td>
						</tr>
					</tbody>
				</table>
				<p><input type="checkbox" name="membership" required>会員規約に同意する</p>
				<p><input type="checkbox" name="privacy" required>個人情報保護方針に同意する</p>
				<div class="buttons">
		        	<input class="common_button" type="submit" name="submit"  value="登録"/>
		        </div>
			</form>
			<p><a href="login.jsp">会員登録がすでにお済みのお客様はこちら</a></p>
		</div>
	</main>
	<footer>
		<%@ include file="footer.jsp" %>
	</footer>
</div>
</body>
</html>