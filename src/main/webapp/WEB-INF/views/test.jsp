<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"    uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>shopping-mall 메인화면</title>
</head>
<body>
<div>
  <c:if test="${null == userId}">
    <button id="registerBtn" onclick="location.href='registerUser/step1'">회원가입</button>
    <button id="loginBtn" onclick="location.href='login/loginForm'">로그인</button>
  </c:if>
  <c:if test="${! empty userId}">
    <c:choose>
      <c:when test="${authority eq '1'}">
        ${userId}님 안녕하세요.
        <button id="addProductBtn" onclick="location.href='/product'">상품등록</button>
        <button id="logoutBtn" onclick="location.href='/logout'">로그아웃</button>
      </c:when>
      <c:when test="${authority eq '2'}">
        ${userId}님 안녕하세요.
        <button id="logoutBtn" onclick="location.href='/logout'">로그아웃</button>
      </c:when>
    </c:choose>
  </c:if>
</div>
<div id="Content" >
  <table border="1" cellspacing="0" cellpadding="0">
    <caption></caption>
    <thead>
    <tr>
      <th width="200">상품이미지</th>
      <th width="300">상품명</th>
      <th width="300">가격</th>
      <th width="300">판매자</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${productList}" var="products">
      <tr>
        <td><img src="${products.url}" width="90" height="90"> </td>
        <td><a href="productInfo?id=${products.id}">${products.name}</a></td>
        <td><fmt:formatNumber type="currency" value="${products.price}" pattern="###,###"></fmt:formatNumber></td>
        <td>${products.distributor}</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>