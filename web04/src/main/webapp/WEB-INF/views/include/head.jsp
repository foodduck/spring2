<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*" %>
<%@ page import="kr.co.vo.*" %>
<%
	MemberVO member = (MemberVO) session.getAttribute("member");
%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<!-- 파비콘 설정 -->
    <link rel="shortcut icon" href="${path }/include/source/ico/favicon.ico">
    <link rel="apple-touch-icon" href="${path }/include/source/ico/favicon.ico" sizes="16x16">
    <!-- 메타포 설정 -->
    <meta name="Author" content="환경부">
    <meta name="Keywords" content="환경부">
    <meta name="Description" content="환경부">
    <link rel="canonical" href="http://www.me.go.kr/home/web/main.do" />
    <!-- 오픈그래프 설정 -->
    <meta property="og:url" content="www.Ulleung-travel.kr">
    <meta property="og:site_name" content="환경부">
    <meta property="og:locale" content="서울시">
    <meta property="og:title" content="project4">
    <meta property="og:description" content="환경부 정책홍보">
    <meta property="og:country-name" content="TheJoeun.co">
    <!-- 폰트 로딩 -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&family=Noto+Sans+KR&display=swap" rel="stylesheet">
    <!-- 필수 API 설정 -->
    <script src="${path }/include/js/jquery-latest.js"></script>
    <script src="${path }/include/js/jquery.bxslider.min.js"></script>
    <!-- 외부 스타일 로딩-->
    <link rel="stylesheet" href="${path }/include/css/jquery.bxslider.min.css">
    <link rel="stylesheet" href="${path }/include/css/common.css">
    <!-- google 애널리틱스 연결 -->
    <!-- Global site tag (gtag.js) - Google Analytics -->
    <script async src="https://www.googletagmanager.com/gtag/js?id=UA-216606852-1"></script>
    <script>
    window.dataLayer = window.dataLayer || [];
    function gtag(){dataLayer.push(arguments);}
    gtag('js', new Date());

    gtag('config', 'UA-216606852-1');
    </script>
