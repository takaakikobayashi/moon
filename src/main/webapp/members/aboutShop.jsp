<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>お店について</title>
</head>
<body>
<div class="wrapper">
	<header>
		<%@ include file="header.jsp" %>
	</header>
	<main>
		<div class="container">
			<h2>当店自慢のシェフ</h2>
				<p>テスト太郎</p>
				<p>
				   <img src="images/chef.png" alt="画像" width="140" height="100"><br>
				   実家のスイーツ専門店で幼い頃から腕を磨き、<br>
				   フランスへ武者修行に旅立つ。<br>
				   フランスで卵にこだわったスイーツ店で武者修行のすえ日本に帰国<br>
				   学んだ技術と磨いた腕前を活かし美味しいスイーツを提供する。<br>
				</p>
			<h2>お支払い方法について</h2>
				<p>以下のお支払い方法からお選びください。</p>
				<p>・クレジットカード決済</p>
				<p>・代金引換</p>
				<p>・銀行振込（前払い）</p>
			<h2>キャンセルについて</h2>
				<p>
				   商品製作着手前までであればキャンセルを行うことができます。<br>
			       キャンセルは注文履歴から行いください。<br>
			       商品製作状況は注文ステータスでご確認いただけます。<br>
			       会員登録がお済みでないお客様のキャンセルはご注文から30分以内とさせていただきます。
			    </p>
			<h2>配送方法について</h2>
				<p>
					ヤマト運輸でお届けします。<br>
					時間指定いただくことが可能です。※日付指定はできません。<br>
					ご希望はご注文の際備考欄に記載ください。
				</p>
		</div>
	</main>
	<div class="push"></div>
	<footer>
		<%@ include file="footer.jsp" %>
	</footer>
</div>
</body>
</html>