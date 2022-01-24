<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<head>
		<!-- 합쳐지고 최소화된 최신 CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<!-- 부가적인 테마 -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	 	
	 	<!-- <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> -->
	 	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
		<title>회원가입</title>
	</head>
	<script type="text/javascript">
		$(document).ready(function(){
			// 취소
			$(".cancel").on("click", function(){
				location.href = "/";
			})
			
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
				if($("#userpass").val()!=$("#userpass2").val()){
					alert("입력하신 비밀번호와 비밀번호 확인이 서로 다릅니다.");
					$("#userpass").focus();
					return false;
				}
				if($("#username").val()==""){
					alert("성명을 입력해주세요.");
					$("#username").focus();
					return false;
				}
				
				var idChkVal = $("#idChk").val();
				
				if(idChkVal == "N"){
					alert("중복확인 버튼을 눌러주세요.");
					return false;
				}else if(idChkVal == "Y"){
					f.submit();
				}
			}
		});
		
		function fn_idChk(){
			var userid = $("#userid").val();
			if(userid=="") {
				alert("아이디를 입력하시기 바랍니다.");
				$("#userid").focus();
				return false;
			}
			var res;
			$.ajax({
				url : "/member/idChk",
				type : "post",		//get
				dataType : "json",
				data : {"userid" : userid},
				//한바퀴
				success : function(data){
					res = parseInt(data);
					if(res == 1){
						//$("#status").text("중복된 아이디입니다.");
						alert("중복된 아이디입니다.");
						return false;
					}else if(res == 0){
						//$("#status").text("사용가능한 아이디입니다.");
						$("#idChk").val("Y");
						alert("사용가능한 아이디입니다.");
						return false;
					}
				}, 
				error:function(){
	                alert("에러입니다");
	                return false;
	            }
			});
		}
	</script>
	<body>
<div class="container">

	<div class="content">
			<form action="/member/registery" method="post" id="regForm" name="vo" onsummit="return regData(this)">
				<div class="form-group has-feedback">
					<label class="control-label" for="userid">아이디</label>
					<input class="form-control" type="text" id="userid" name="userid" required />
					<button class="idChkBtn" type="button" id="idChkBtn" onclick="fn_idChk();">중복확인</button>
					<input type="hidden" id="idChk" value="N"/>
				</div>
				<div class="form-group has-feedback">
					<label class="control-label" for="userpass">패스워드</label>
					<input class="form-control" type="password" id="userpass" name="userpass"  required/>
				</div>
				<div class="form-group has-feedback">
					<label class="control-label" for="userpass2">패스워드 확인</label>
					<input class="form-control" type="password" id="userpass2" name="userpass2" required/>
				</div>
				<div class="form-group has-feedback">
					<label class="control-label" for="username">성명</label>
					<input class="form-control" type="text" id="username" name="username" required/>
				</div>
				<div class="form-group has-feedback">
					<label class="control-label" for="email">이메일</label>
					<input class="form-control" type="text" id="email" name="email" pattern="\w+@\w+\.\w+" required/>
				</div>
				<div class="form-group has-feedback">
					<button class="btn btn-success" type="submit" id="submit">회원가입</button>
					<button class="cancel btn btn-danger" type="button">취소</button>
				</div>
			</form>
			<div id="status">${qr}</div>
	</div>
</div>
	</body>
	
</html>