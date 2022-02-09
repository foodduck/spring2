<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<meta charset="UTF-8"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Home</title>
</head>
<body>
<h1>
	<a href="/member/memberLoginView">로그인</a>
	<a href="/member/memberJoinView">회원가입</a>
	<a href="board/boardList">글목록</a>
	<c:if test="${member.userid != null}">
	<a href="/board/boardWriteView">글쓰기</a>
	<a href="/member/memberUpdateView">회원정보 수정</a>
	</c:if>
</h1>

<p>DB 연결 상태, 테이블 생성 여부를 확인해 주세요.</p>
<P>  The time on the server is ${serverTime}. </P>
<div class="wrap">
	<div class="content">
		
	</div>
</div>
</body>
</html>
