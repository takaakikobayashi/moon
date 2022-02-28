<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="common.model.CategoryBean"%>
<%@ page import="common.model.CategoryDao"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="../common/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  	<script src="../common/bootstrap/js/bootstrap.min.js"></script>
	<title>商品追加</title>
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
			<% CategoryDao categorydao = new CategoryDao();%>
			<% ArrayList<CategoryBean> categoryBeanList = categorydao.selectcategory(); %>
			<h2>商品情報入力</h2>
			<form action="itemregisterservlet" method="post" enctype=multipart/form-data>
				<table class="itemRegister_form">
					<tbody>
	                	<tr>
	                    	<th>商品画像</th>
	                        <td><input type="file" name="image" accept="image/*"></td>
	                    </tr>
	                    <tr>
	                    	<th>商品名</th>
	                        <td><input type="text" name="name" required></td>
	                    </tr>
	                    <tr>
	                    	<th>カテゴリ</th>
	                        <td>
	                        <select name="category_id" required>
		                        <% for (CategoryBean bean : categoryBeanList) {%>
		                        	<option value=<%= bean.getCategoryId() %>><%= bean.getName()%></option>
		                        <% } %>
	                        </select>
	                        </td>
	                    </tr>
	                    <tr>
	                    	<th>商品説明</th>
	                        <td><textarea name="introduction"></textarea></td>
	                    </tr>
	                    <tr>
	                    	<th>価格</th>
	                        <td><input type="text" name="price" required></td>
	                    </tr>
	                    <tr>
	                    	<th>原材料</th>
	                        <td><textarea name="ingredient"></textarea></td>
	                    </tr>
	                    <tr>
	                    	<th>アレルギー</th>
	                        <td><textarea name="allergy"></textarea></td>
	                    </tr>
	                </tbody>
	            </table>
	            
	            <div class="buttons">
	                <input class="common_button" type="submit" name="submit"  value="商品を登録する"/>
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