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
	<a href="/member/loginForm">로그인</a>
	<a href="/member/reg">회원가입</a>
	<a href="/board/boardWriteView">글 작성</a>
	<a href="board/boardList">게시판목록</a>
</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
