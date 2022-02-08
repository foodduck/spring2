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
	
	//jQuery interface
	$(document).ready(function(){
		$("#show").click(function() {
	  		$("#effect").toggle("show");
		});
	});
	</script>
	<style>
		#effect {display:none; width:1200px; height:390px;}
	</style>
	<body>
<div class="container">

	<div class="content">
			<form action="/member/registery" method="post" id="regForm" name="vo" onsummit="return regData(this)">
				<div class="form-group has-feedback">
					<label class="control-label" for="userid">아이디</label>
					<input class="form-control" type="text" id="userid" name="userid" pattern="^[A-za-z]{5,15}$" placeholder="5~15자의 영문과 숫자" autofocus required />
					<button class="idChkBtn" type="button" id="idChkBtn" onclick="fn_idChk();">중복확인</button>
					<input type="hidden" id="idChk" value="N"/>
				</div>
				<div class="form-group has-feedback">
					<label class="control-label" for="userpass">패스워드</label>
					<input class="form-control" type="password" id="userpass" name="userpass" pattern="^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$" placeholder="문자, 숫자, 특수문자를 포함한 8~15자" required/>
				</div>
				<div class="form-group has-feedback">
					<label class="control-label" for="userpass2">패스워드 확인</label>
					<input class="form-control" type="password" id="userpass2" name="userpass2" placeholder="문자, 숫자, 특수문자를 포함한 8~15자" required/>
				</div>
				<div class="form-group has-feedback">
					<label class="control-label" for="username">성명</label>
					<input class="form-control" type="text" id="username" name="username" placeholder="이름을 입력하세요" required/>
				</div>
				<div class="form-group has-feedback">
					<label class="control-label" for="email">이메일</label>
					<input class="form-control" type="text" id="email" name="email" pattern="\w+@\w+\.\w+" placeholder="이메일을 입력하세요" required/>
				</div>
				<div class="form-group has-feedback">
					<label class="control-label" for="userterms">약관 동의</label>
					<input type="checkbox" id="userterms" name="userterms" required>
					<button id="show">약관 보기/닫기</button>
				</div>
				<div id="effect" class="ui-widget-content ui-corner-all">
				    <h3 class="ui-widget-header ui-corner-all">약관</h3>
				    <textarea cols=100 rows=15 readonly >
									      제1조 (목적)
					이 약관은 전기통신사업법령 및 정보통신망이용촉진 및 정보보호 등에 관한 법률에 따라 car21㈜ 및 관계사{car21 ㈜(이상, 자회사) ㈜한겨레플러스(이상, 제휴사)} (이하 `회사`)에서 제공하는 모든 서비스(이하 `서비스`)의 이용절차,조건등 서비스 이용과 관련한 회사와 회원의 권리 및 의무에 관련된 사항을 규정함을 목적으로 합니다.
					
					제2조 (약관의 효력과 변경)
					1.본 약관은 회원이 신규 가입 시 "약관에 동의합니다"라는 물음에 회원이 "동의" 버튼을 클릭 하는 것으로 효력이 발생됩니다.
					2.회사는 필요한 경우 약관을 변경할 수 있으며, 변경된 약관은 적용일 전 7일간 온라인 상의 공지나 전자 우편 등의 방법을 통해 회원에게 공지되고 적용일에 효력이 발생됩니다.
					3.회원은 변경된 약관에 동의하지 않을 경우, 서비스 이용을 중단하고 탈퇴할 수 있습니다.
					4.약관이 변경된 이후에도 계속적으로 서비스를 이용하는 경우에는 회원이 약관의 변경 사항에 동의한 것으로 봅니다.
					제3조 (약관 외 준칙)
					1.이 약관에 명시되지 않은 사항이 전기통신기본법, 전기통신사업법, 기타 관계법령에 규정 되어 있을 경우에는 그 규정에 따릅니다.
					2.회사는 약관 이외에 개별 서비스에 대한 세부적인 사항을 정할 수 있으며, 그 내용은 해당 서비스의 이용안내 및 별도의 이용 동의 절차를 통해 공지합니다
					제2장 회원 가입과 서비스 이용
					제4조 (이용계약)
					서비스 이용계약은 회원이 회사가 정한 약관에 동의하고, 회사에 가입 및 서비스 이용을 신청하며, 회사가 이를 허락하는 것 으로 이루어집니다.
					
					제5조 (이용신청)
					1.본 서비스를 이용하기 위해서는 회사가 정한 소정의 가입신청서에 이용자의 정보를 기록해야 합니다.
					2.가입신청 양식에 기재된 모든 이용자 정보는 반드시 실제 정보와 동일해야 합니다. 실제 정보를 입력하지 않거나 사실과 다른 정보를 입력한 사용자는 법적인 보호를 받을 수 없습니다.
					제6조 (이용신청의 승낙)
					1.회사는 회원이 모든 사항을 정확히 기재하여 신청할 경우 서비스 이용을 승낙합니다.
					단, 아래의 경우는 승낙을 거부하거나 취소할 수 있습니다.
					a .실명이 아닌 경우
					b .본인의 주민등록번호가 아닌 경우
					c .이용신청 시 필요내용을 허위로 기재하여 신청한 경우
					d .사회의 안녕 질서 또는 미풍양속을 저해할 목적으로 신청한 경우
					e .전기통신기본법, 전기통신사업법, 정보통신 윤리강령, 정보통신 윤리위원회 심의규정, 프로그램 보호법 및 기타관련 법령과 약관이 금지하는 행위를 한 경우
					f .마호에 해당하는 사유로 형사처벌을 받은 경우
					g .마호에 해당하는 사유로 다른 서비스제공회사로부터 서비스 이용이 거절된 경력이 있는 경우
					h .기타 회사가 정한 이용신청 요건에 맞지 않을 경우
					i .만14세 미만의 아동이 부모 등의 법정대리인의 동의를 얻지 않은 경우
					2.회사는 기술적인 이유나 정책 등의 이유로 인해 이용신청의 승낙을 보류할 수 있습니다.
					3.회사는 회원 가입을 위하여 필요한 정보를 요구할 수 있으며, 회원가입 이후에도 추가정보의 입력을 요구할 수 있습니다.
					회원가입 시 요구하는 구체적인 정보는 개인정보 취급방침에서 확인하실 수 있습니다.
					4.회사는 회원이 온/오프라인 이벤트에 참여하거나, 상품 구매시에 제출 또는 취득한 개인정보를 보유할 수 있으며,
					동 정보를 회원이 가입시 입력한 회원의 정보에 추가 또는 수정할 수 있습니다.
					5.4 항의 내용에 따라 추가 또는 수정하여 보유할 수 있는 개인정보는 다음과 같습니다. 전자우편주소, 우편번호, 주소,
					전화번호, 이동전화번호, 이벤트 응모일, 상품 구매일, 상품 구매내역, 자동차보험 만기일
					제7조 (회원 아이디 관리)
					1.회원의 아이디와 비밀번호에 관한 모든 관리책임은 회원에게 있습니다.
					2.회원이 등록한 아이디 및 비밀번호에 의하여 발생되는 사용상의 과실 또는 제 3자에 의한 부정사용 등에 대한 모든 책임은 해당 회원에게 있습니다.
					제8조 (계약 사항의 변경)
					회원은 서비스이용 신청 시 기재한 사항이 변경되었을 경우, 즉시 수정하여야 합니다.
				    </textarea>
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