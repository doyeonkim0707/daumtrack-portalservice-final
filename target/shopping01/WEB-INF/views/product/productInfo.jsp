<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015-06-11
  Time: 오후 7:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>상품 정보</title>
</head>
<body>
  <div>
    <label>${productInfo.name}</label>
    <button onclick="javascript:history.back()">목록</button>
    <c:if test ="${userId eq productInfo.distributor}">
      <button onclick="location.href='/editProduct?id=${productInfo.id}'">수정</button>
    </c:if>
  </div>
  <div>
    <img src="${productInfo.url}">
    <div>
      <p>가격 : ${productInfo.price}원</p>
      <p>판매자: ${productInfo.distributor}</p>
      <button>구매</button>
    </div>
  </div>
  <div>상품상세설명</div>
  <p>${productInfo.description}</p>
</body>
</html>
