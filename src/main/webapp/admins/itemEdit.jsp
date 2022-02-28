<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="common.model.ItemBean"%>
<%@ page import="common.model.CategoryBean"%>
<%@ page import="common.model.CategoryDao"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="../common/css/itemList.css">
	<link href="../common/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  	<script src="../common/bootstrap/js/bootstrap.min.js"></script>
	<title>商品編集</title>
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
		 		<% ItemBean itemBean = (ItemBean) session.getAttribute("editItem"); %>
				
				<% CategoryDao categorydao = new CategoryDao();%>
				<% ArrayList<CategoryBean> categoryBeanList = categorydao.selectcategory(); %>
				
				<% if ( itemBean.getImageBlob() != null) { %>
					<img src="adminsgetimageservlet?item_id=<%= itemBean.getProductId() %>" alt="画像" width="100" height="100">
				<% } %>
				
				<form action="itemeditservlet" method="post" enctype=multipart/form-data>
					<table class="itemEdit_form">
						<tbody>
		                	<tr>
		                    	<th>商品画像</th>
		                        <td><input type="file" name="image" accept="image/*"></td>
		                    </tr>
		                    <tr>
		                    	<th>商品名</th>
		                        <td><input type="text" name="name" value="<%= itemBean.getName() %>"></td>
		                    </tr>
		                    <tr>
		                    <th>カテゴリ</th>
		                        <td>
			                        <select name="category_id">
				                        <% for (CategoryBean bean : categoryBeanList) {%>
				                        	<% if (bean.getCategoryId() == itemBean.getCategoryId()) { %>
				                        	<option selected="selected" value=<%= bean.getCategoryId() %>><%= bean.getName()%></option>
				                        	<% } else { %>
				                        	<option value=<%= bean.getCategoryId() %>><%= bean.getName()%></option>
				                        	<% } %>
				                        <% } %>
			                        </select>
		                        </td>
		                    </tr>
		                    <tr>
		                    	<th>商品説明</th>
		                        <td><textarea name="introduction"><%= itemBean.getIntroduction() %></textarea></td>
		                    </tr>
		                    <tr>
		                    	<th>価格</th>
		                        <td><input type="text" name="price" value="<%= itemBean.getPrice() %>"></td>
		                    </tr>
		                    <tr>
		                    	<th>原材料</th>
		                        <td><textarea name="ingredient"><%= itemBean.getIngredient() %></textarea></td>
		                    </tr>
		                    <tr>
		                    	<th>アレルギー</th>
		                        <td><textarea name="allergy"><%= itemBean.getAllergy() %></textarea></td>
		                    </tr>
		                    <tr>
		                    	<th>販売ステータス</th>
		                    	<% if (itemBean.getIsSailing() == 1) { %>
			                        <td><input type="radio" name="is_sailing" value="1" checked="checked">販売中</td>
			                        <td><input type="radio" name="is_sailing" value="2">売り切れ</td>
			                        <td><input type="radio" name="is_sailing" value="3">販売中止</td>
		                        <% } else if (itemBean.getIsSailing() == 2) { %>
			                        <td><input type="radio" name="is_sailing" value="1">販売中</td>
			                        <td><input type="radio" name="is_sailing" value="2" checked="checked">売り切れ</td>
			                        <td><input type="radio" name="is_sailing" value="3">販売中止</td>
		                        <% } else { %>
			                        <td><input type="radio" name="is_sailing" value="1">販売中</td>
			                        <td><input type="radio" name="is_sailing" value="2">売り切れ</td>
			                        <td><input type="radio" name="is_sailing" value="3" checked="checked">販売中止</td>
		                        <% } %>
		                    </tr>
		                </tbody>
		            </table>
		            
		            <input type="hidden" name="item_id" value="<%= itemBean.getProductId() %>" />
		            
		            <div class="buttons">
		                <input class="common_button" type="submit" name="submit"  value="変更を保存する"/>
		            </div>
		        </form>
		    </div>
		</main>
	<% } %>
	<footer>
		<%@ include file="footer.jsp" %>
	</footer>
	</div>
</body>
</html>