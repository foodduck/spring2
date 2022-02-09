<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
	<!-- 합쳐지고 최소화된 최신 CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<!-- 부가적인 테마 -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
 	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
 	<style type="text/css">
 	.form_group { list-style:none; }
 	.form_group li { padding:8px; clear:both; margin:8px; }
 	</style>
<title>로그인 페이지</title>
</head>
<script type="text/javascript">
	$(document).ready(function(){
		function regData(f){
			if($("#userid").val()==""){
				alert("아이디를 입력해주세요.");
				$("#userid").focus();
				return false;
			}
			if($("#userpass").val()==""){
				alert("비밀번호를 입력해주세요.");
				$("#userpass").focus();
				return false;
			}
		}
		$("#login_submit").click(function() {
			var userid = $("#userid").val();
			if(userid=="") {
				alert("아이디를 입력하시기 바랍니다.");
				$("#userid").focus();
				return false;
			}
			var res;
			$.ajax({
				url : "/member/memberCheckID",
				type : "post",		//get
				dataType : "json",
				data : {"userid" : userid},
				//한바퀴
				success : function(data){
					res = parseInt(data);
					if(res == 1){
						//$("#status").text("중복된 아이디입니다.");
						//alert("중복된 아이디입니다.");
						return false;
					}else if(res == 0){
						//$("#status").text("사용가능한 아이디입니다.");
						alert("존재하지 않는 아이디입니다.");
						return false;
					}
				}, 
				error:function(){
	                alert("에러입니다");
	                return false;
	            }
			});
		});
	});
</script>
<body>
<div class="container">
	
	<div class="content">
		<h2 class="title">로그인</h2>
		<form action="/member/memberLogin" method="post" id="regForm" name="vo" onsummit="return regData(this)">
			<fieldset class="frm_fr">
				<ul class="form_group has-feedback">
					<li class="login_row">
						<input type="text" class="form-control" id="userid" name="userid" placeholder="아이디 입력" required autofocus>
					</li> 
					<li class="login_row">
						<input type="password" id="userpass" name="userpass" class="form-control" maxlength="20"  placeholder="●●●●" required />
					</li> 
					<li class="login_row"><br>
						<input type="submit" class="btn btn-primary" value="로그인" id="login_submit" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="button" class="btn btn-primary" onclick="location.href='/member/memberJoinView'">회원가입</button>
					</li>
				</ul>
			</fieldset>
			<p class="msg"></p>
		</form>
	</div>
</div>
</body>
</html>
