<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="members.model.LoginUserBean"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>会員情報編集</title>
</head>
<body>
<div class="wrapper">
	<header>
		<%@ include file="header.jsp" %>
	</header>
	<main>
		<div class="container">
			<% LoginUserBean loginUserBean = (LoginUserBean) session.getAttribute("loginUser"); %>
			
			<form action="loginuserinfoeditservlet" method="get">
				<table class="loginUserInfoEdit_form">
					<tbody>
	                	<tr>
	                    	<th>名前</th>
	                        <td><input type="text" name="first_name" value="<%= loginUserBean.getFirstName() %>" required></td>
	                        <td><input type="text" name="last_name" value="<%= loginUser.getLastName() %>" required></td>
	                    </tr>
	                    <tr>
	                    	<th>ナマエ</th>
	                        <td><input type="text" name="kana_first_name" value="<%= loginUser.getKanaFirstName() %>" required></td>
	                        <td><input type="text" name="kana_last_name" value="<%= loginUser.getKanaLastName() %>" required></td>
	                    </tr>
	                    <tr>
	                    	<th>メールアドレス</th>
	                        <td><input type="email" name="mail" value="<%= loginUser.getMail() %>" required></td>
	                    </tr>
	                    <tr>
	                    <th>電話番号</th>
	                    <td><input type="tel" name="phone_number" autocomplete="tel" value="<%= loginUser.getPhoneNumber() %>" required></td>
	                    </tr>
	                    <tr>
	                    	<th>郵便番号</th>
	                        <td><input type="text" name="postal_code" pattern="\d{3}\d{4}" autocomplete="postal-code" value="<%= loginUser.getPostalCode() %>" required></td>
	                    </tr>
	                    <tr>
	                    	<th>住所</th>
	                        <td><input type="text" name="address1" value="<%= loginUser.getAddress1() %>" required></td>
	                        <td><input type="text" name="address2" value="<%= loginUser.getAddress2() %>" required></td>
	                        <td><input type="text" name="address3" value="<%= loginUser.getAddress3() %>" required></td>
	                    </tr>
	            	</tbody>
	            </table>
	            
	            <input type="hidden" name="member_id" value="<%= loginUser.getMemberId() %>" />
	            
	            <div class="buttons">
	                <input class="common_button" type="submit" name="submit"  value="変更を保存する"/>
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