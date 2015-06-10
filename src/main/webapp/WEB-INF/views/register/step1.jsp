<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>회원가입</title>
</head>
<body>
  <h2>회원 정보 입력 </h2>
  <form:form action="step2" method="post" commandName="registerRequest">
    <P>
      <label>ID
        <form:input path="id"/>
      </label>
    </P>
    <P>
      <label>Password
        <form:password path="password"/>
      </label>
    </P>
    <P>
      <label>name
        <form:input path="name"/>
      </label>
    </P>
    <p>
      <label>권한
        <form:select path="authority">
          <form:option value="1" label="판매자"/>
          <form:option value="2" label="구매자"/>
        </form:select>
      </label>
    </p>
    <input type="submit" value="회원가입">
    <input type="button" value="취소" onclick="location.href='../'">
  </form:form>
</body>
</html>
