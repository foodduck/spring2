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
	 	<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
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
				url : "/member/memberCheckID",
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
	<style>
		#effect {display:none; width:1200px; height:390px;}
	</style>
	<body>
<div class="container">

	<div class="content">
			<form action="/member/memberUpdate" method="post" id="regForm" name="vo" onsummit="return regData(this)">
				<div class="form-group has-feedback">
					<label class="control-label" for="userid">아이디</label>
					<input class="form-control" type="text" id="userid" name="userid" value="${member.getUserid() }" pattern="^[A-za-z]{5,15}$" placeholder="5~15자의 영문과 숫자" autofocus required />
					<button class="idChkBtn" type="button" id="idChkBtn" onclick="fn_idChk();">중복확인</button>
					<input type="hidden" id="idChk" value="N"/>
				</div>
				<div class="form-group has-feedback">
					<label class="control-label" for="userpass">패스워드</label>
					<input class="form-control" type="password" id="userpass" name="userpass"  value="${member.getUserpass() }" pattern="^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$" placeholder="문자, 숫자, 특수문자를 포함한 8~15자" required/>
				</div>
				<div class="form-group has-feedback">
					<label class="control-label" for="userpass2">패스워드 확인</label>
					<input class="form-control" type="password" id="userpass2" name="userpass2" placeholder="문자, 숫자, 특수문자를 포함한 8~15자" required/>
				</div>
				<div class="form-group has-feedback">
					<label class="control-label" for="username">성명</label>
					<input class="form-control" type="text" id="username" name="username"  value="${member.getUsername() }" placeholder="이름을 입력하세요" required/>
				</div>
				<div class="form-group has-feedback">
					<label class="control-label" for="email">이메일</label>
					<input class="form-control" type="text" id="email" name="email"  value="${member.getEmail() }" pattern="\w+@\w+\.\w+" placeholder="이메일을 입력하세요" required/>
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