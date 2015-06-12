<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>상품 수정</title>
</head>
<body>
<form:form modelAttribute="productItem" method="post" enctype="multipart/form-data">
  <fieldset>
    <legend>${userId}</legend>
    <p>
      <form:label for="fileData" path="fileData">상품 이미지</form:label>
      <form:input path="fileData" type="file"/>
      <img src="${productItem.url}" width="50" height="50">
    </p>

    <p>
      <form:label for="name" path="name" >상품명</form:label>
      <form:input path="name"/>
    </p>

    <p>
      <form:label for="price" path="price">가격</form:label>
      <form:input path="price"/>
    </p>
    <p>
      <form:label for="description" path="description">상품상세설명</form:label>
      <form:textarea path="description" rows="5" cols="50"/>
    </p>
    <p>
      <input type="submit" value="수정" />
      <input type="button" value="취소" onclick="javascript:history.back()">
    </p>
  </fieldset>
</form:form>
</body>
</html>
