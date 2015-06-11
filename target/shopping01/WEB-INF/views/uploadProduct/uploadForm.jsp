<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
  <META http-equiv="Content-Type" content="text/html;charset=UTF-8">
  <title>상품 등록</title>
</head>
<body>
<form:form modelAttribute="productItem" method="post" enctype="multipart/form-data">
  <fieldset>
    <legend>${userName}</legend>
    <p>
      <form:label for="fileData" path="fileData">상품 이미지</form:label>
      <form:input path="fileData" type="file"/>
    </p>

    <p>
      <form:label for="name" path="name">상품명</form:label>
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
      <input type="submit" value="등록" />
      <input type="button" value="취소" onclick="javascript:history.back()">
    </p>

  </fieldset>
</form:form>
</body>
</html>


<%--
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title></title>
</head>
<body>

  <form:form method="POST" commandName="addProductCommand" action="step2" enctype="multipart/form-data">
    <table width=700 border=1>
      <tr>
        <td><b>이미지 경로</b></td>
        <td align=left onkeydown = "event.returnValue=false;">
          <input path="file" type="file"/>
        </td>
      </tr>
      <tr>
        <td><b>상품명</b></td>
        <td align=left>
          <form:input path="name" type="text"/>
        </td>
      </tr>
      <tr>
        <td><b>가격</b></td>
        <td align=left>
          <form:input path="price" type="text"/>
        </td>
      </tr>
      <tr>
        <td><b>상품 설명</b></td>
        <td align=left>
          <form:textarea path="description" rows="5" cols="50"/>
        </td>
      </tr>
      <tr>
        <td colspan=2 align="center">
          <input type="submit" value="등록">
          <input type="button" value="뒤로가기" onclick="javascript:history.back()">
        </td>
      </tr>
    </table>
  </form:form>
</body>
</html>--%>
