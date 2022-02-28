<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="members.model.CartBean"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>注文情報入力</title>
</head>
<body>
<div class="wrapper">
	<header>
		<%@ include file="header.jsp" %>
	</header>
	<main>
		<div class="container">
			<% if (session.getAttribute("cart_item") != null) { %>
				<%  ArrayList<CartBean> buy_item = (ArrayList<CartBean>) session.getAttribute("cart_item"); %>
				
				<h2>注文情報入力</h2>
				<form action="orderconfirmationservlet" method="post">
					<table class="orderInformation_form">
						<tbody>
		                	<tr>
		                    	<th>氏名（姓）</th>
		                        <td><input type="text" name="first_name"></td>
		                    </tr>
		                    <tr>
		                    	<th>氏名（名）</th>
		                        <td><input type="text" name="last_name"></td>
		                    </tr>
		                    <tr>
		                    	<th>メールアドレス</th>
		                        <td><input type="email" name="mail"></td>
		                    </tr>
		                    <tr>
		                    	<th>郵便番号※ハイフンなしで入力してください</th>
		                        <td><input type="text" name="postal_code"></td>
		                    </tr>
		                    <tr>
		                    	<th>都道府県</th>
		                        <td>
		                        	<input type="text" name="address1" list="prefectures">
		                        		<datalist id="prefectures">
		                        			<option value="北海道">
		                        			<option value="東京都">
		                        			<option value="沖縄県">
		                        		</datalist>
		                        </td>
		                    </tr>
		                    <tr>
		                    	<th>住所1（市区町村・番地）</th>
		                        <td><input type="text" name="address2"></td>
		                    </tr>
		                    <tr>
		                    	<th>住所2（建物名）</th>
		                        <td><input type="text" name="address3"></td>
		                    </tr>
		                    <tr>
		                        <th>電話番号</th>
		                        <td><input type="tel" name="phone_number"/></td>
		                    </tr>
		                    <tr>
		                    	<th>支払方法</th>
		                        <td>
		                        	<select name="payment">
			                        	<option value="1">クレジットカード払い</option>
			                        	<option value="2">銀行振込</option>
			                        	<option value="3">代引き</option>
		                        	</select>
		                        </td>
		                    </tr>
		                    <tr>
		                    	<th>クレジットカード情報</th>
		                        <td><input type="text" name="credit"></td>
		                    </tr>
		                    <tr>
		                    	<th>ポイント支払い</th>
		                        <td><input type="text" name="point"></td>
		                    </tr>
		                    <tr>
		                    	<th>備考欄</th>
		                        <td><textarea name="remarks"></textarea></td>
		                    </tr>
		                </tbody>
		            </table>
		            
		            <input type="hidden" name="buy_item" value="buy_item" />
		            
		            <div class="buttons">
		                <input class="common_button" type="submit" name="submit"  value="注文内容を確認する"/>
		            </div>
		        </form>
			
			<% } else {%>
			
			<p>商品をカートに追加してください</p>
			
			<% } %>
		</div>
	</main>
	<footer>
		<%@ include file="footer.jsp" %>
	</footer>
</div>
</body>
</html>