<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!--에러 처리 해야됨 -->
<html>
<head>
    <title>로그인</title>
</head>
<body>
    <form:form commandName="loginCommand">
        <p>
            <label>id
                <form:input path="id"/>
            </label>
        </p>
        <p>
            <label>password
                <form:input path="password"/>
            </label>
        </p>
        <input type="submit" value="로그인">
        <input type="button" value="취소" onclick="location.href='../'">
   </form:form>
</body>
</html>
