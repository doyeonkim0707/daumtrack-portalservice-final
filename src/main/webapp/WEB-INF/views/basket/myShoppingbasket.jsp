<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"    uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>사용자 바구니</title>
</head>
<body>
<div>${userName}님의 장바구니</div>
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
    <c:forEach items="${userBasket}" var="products">
      <tr>
        <td><img src="${products.url}" width="90" height="90"> </td>
        <td><a href="productInfo?id=${products.id}">${products.name}</a></td>
        <td><fmt:formatNumber type="currency" value="${products.price}" pattern="###,###"></fmt:formatNumber></td>
        <td>${products.distributor}</td>
        <td><button onclick="location.href='/cancel?id=${products.id}'">주문취소</button></td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
<div>
  <p>총가격 <fmt:formatNumber type="currency" value="${sum}" pattern="###,###"></fmt:formatNumber></p>
</div>
</body>
</html>
