<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="members.model.OrderBean"%>
<%@ page import="members.model.CartBean"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>注文確認</title>
</head>
<body>
<div class="wrapper">
	<main>
		<div class="container">
			<% if (session.getAttribute("order") != null) { %>
			
				<%  OrderBean order = (OrderBean) session.getAttribute("order"); %>
				<%  ArrayList<CartBean> buy_item = (ArrayList<CartBean>) session.getAttribute("cart_item"); %>
			
				<h2>以下の内容で注文を確定しますか？</h2>
					<table class="orderfinalization_form">
						<tbody>
		                	<tr>
		                    	<th>注文内容</th>
		                        <% for (CartBean bean : buy_item) {%>
		                        <td>
									<p><%= bean.getName()%></p>
									<p><%= bean.getPrice()%></p>
									<p><%= bean.getAmount() %></p>
								</td>
								<% } %>
		                    </tr>
		                    <tr>
		                    	<th>ポイント利用</th>
		                        <td><p><%-- <%= order.getPoint()%> --%></p></td>
		                    </tr>
		                    <tr>
		                    	<th>送料</th>
		                        <td><p>800</p></td>
		                    </tr>
		                    <tr>
		                    	<th>お支払金額</th>
		                        <td><p></p></td>
		                    </tr>
		                    <tr>
		                    	<th>獲得予定ポイント</th>
		                        <td><p></p></td>
		                    </tr>
		                    <tr>
		                    	<th>氏名（姓）</th>
		                        <td><%= order.getFirstName()%></td>
		                    </tr>
		                    <tr>
		                    	<th>氏名（名）</th>
		                        <td><%= order.getLastName()%></td>
		                    </tr>
		                    <tr>
		                    	<th>メールアドレス</th>
		                        <td><%= order.getMail()%></td>
		                    </tr>
		                    <tr>
		                    	<th>郵便番号</th>
		                        <td>〒<%= order.getPostalCode().substring(0,3)%>-<%= order.getPostalCode().substring(4,7)%></td>
		                    </tr>
		                    <tr>
		                    	<th>都道府県</th>
		                        <td><%= order.getAddress1()%></td>
		                    </tr>
		                    <tr>
		                    	<th>住所1（市区町村・番地）</th>
		                        <td><%= order.getAddress2()%></td>
		                    </tr>
		                    <tr>
		                    	<th>住所2（建物名）</th>
		                        <td><%= order.getAddress3()%></td>
		                    </tr>
		                    <tr>
		                        <th>電話番号</th>
		                        <td><%= order.getPhoneNumber()%></td>
		                    </tr>
		                    <tr>
		                    	<th>支払方法</th>
		                        <% if (order.getPayment() == 1) { %>
		                        	<td>クレジットカード</td>
		                        <% } else if (order.getPayment() == 2) { %>
		                        	<td>銀行振込</td>
		                        <% } else if (order.getPayment() == 3) { %>
		                        	<td>代引き</td>
		                        <% } %>
		                    </tr>
		                    <tr>
		                    	<th>クレジットカード情報</th>
		                        <td><%= order.getCredit()%></td>
		                    </tr>
		                    <tr>
		                    	<th>備考欄</th>
		                        <td><%= order.getRemarks()%></td>
		                    </tr>
		                </tbody>
		            </table>
		            
		            <div class="buttons">
		                <p><a href="orderfinalizeservlet">注文を確定する</a></p>
		            </div>
				
			<% } else {%>
				
				<p>注文情報を入力してください</p>
				
			<% } %>
		</div>
	</main>
</div>
</body>
</html>