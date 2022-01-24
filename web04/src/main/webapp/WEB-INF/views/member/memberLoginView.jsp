<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
	<!-- 합쳐지고 최소화된 최신 CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<!-- 부가적인 테마 -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
 	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 	<style type="text/css">
 	.form_group { list-style:none; }
 	.form_group li { padding:8px; clear:both; margin:8px; }
 	</style>
<title>로그인 페이지</title>
</head>
<body>
<div class="container">
	
	<div class="content">
		<h2 class="title">로그인</h2>
		<form action="/member/memberLogin" method="post" id="regForm" name="vo">
			<fieldset class="frm_fr">
				<ul class="form_group has-feedback">
					<li class="login_row">
						<input type="text" class="form-control" id="userid" name="userid" placeholder="아이디 입력">
					</li> 
					<li class="login_row">
						<input type="password" id="userpass" name="userpass" class="form-control" maxlength="20" required />
					</li> 
					<li class="login_row"><br>
						<input type="submit" class="btn btn-primary" value="로그인" id="login_submit" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="button" class="btn btn-primary" onclick="location.href='/member/memberLogin">회원가입</button>
					</li>
				</ul>
			</fieldset>
			<p class="msg"></p>
		</form>
	</div>
</div>
</body>
</html>
