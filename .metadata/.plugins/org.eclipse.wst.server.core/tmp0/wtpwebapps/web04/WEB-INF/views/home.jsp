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
	<a href="/member/memberLoginView">login</a>
	<a href="/member/memberJoinView">sign in</a>
	<a href="/board/boardWriteView">boardWrite</a>
	<a href="board/boardList">boardList</a>
</h1>
<h2>한글</h2>
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
