<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>상품 정보</title>
</head>
<body>
  <div>
    <label>${productInfo.name}</label>
    <button onclick="location.href='/'">목록</button>
    <c:if test ="${userId eq productInfo.distributor}">
      <button onclick="location.href='/editProduct?id=${productInfo.id}'">수정</button>
    </c:if>
  </div>
  <div>
    <img src="${productInfo.url}" width="400" height="400">
    <div>
      <p>가격 : <fmt:formatNumber type="currency" value="${productInfo.price}" pattern="###,###"></fmt:formatNumber>원</p>
      <p>판매자: ${productInfo.distributor}</p>
      <form action="/shoppingBasket" method="post">
        <input type="hidden" name="id", value="${productInfo.id}">
        <%--<button onclick="location.href='/shoppingBasket?id=${productInfo.id}'">구매</button>--%>
        <input type="submit" value="구매">
      </form>

    </div>
  </div>
  <div>상품상세설명</div>
  <p>${productInfo.description}</p>
</body>
</html>
