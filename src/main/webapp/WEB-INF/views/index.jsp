<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"    uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<meta charset="utf-8" />
	<title>홈쇼핑몰</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />

	<link rel="stylesheet" type="text/css" href="/resources/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="/resourcesfont-awesome/css/font-awesome.min.css" />

	<script type="text/javascript" src="/resourcesjs/jquery-1.10.2.min.js"></script>
	<script type="text/javascript" src="/resourcesbootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">

	<div class="page-header">
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

	<%--<c:forEach items="${productList}" var="products">
		<tr>
			<td><img src="${products.url}" width="90" height="90"> </td>
			<td><a href="productInfo?id=${products.id}">${products.name}</a></td>
			<td><fmt:formatNumber type="currency" value="${products.price}" pattern="###,###"></fmt:formatNumber></td>
			<td>${products.distributor}</td>
		</tr>
	</c:forEach>--%>

	<!-- Offers List - START -->
	<div class="container">
		<div class="row">
			<c:forEach items="${productList}" var="products">
				<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4" style="cursor: pointer;" onclick="location.href='productInfo?id=${products.id}'">
				<div class="listing listing-default">
					<div class="shape">
						<div class="shape-text">buy</div>
					</div>
					<div class="listing-content" style="margin-bottom: 10px">

						<h3 class="lead" style="font-size: 1.2em; margin-bottom: 10px">${products.name}</h3>
						<div>
							<img src="${products.url}" width="50" height="50" align="left">
							<%--<span style="padding-left: 10px">상품명 : ${products.name}</span><br>--%>
							<span style="padding-left: 10px">가격 : <fmt:formatNumber type="currency" value="${products.price}" pattern="###,###"></fmt:formatNumber></span><br>
							<span style="padding-left: 10px">판매자 : ${products.distributor}</span>
						</div>
					</div>
				</div>
			</div>
			</c:forEach>
		</div>
	</div>

	<style>
		.shape {
			border-style: solid;
			border-width: 0 70px 40px 0;
			float: right;
			height: 0px;
			width: 0px;
			-ms-transform: rotate(360deg); /* IE 9 */
			-o-transform: rotate(360deg); /* Opera 10.5 */
			-webkit-transform: rotate(360deg); /* Safari and Chrome */
			transform: rotate(360deg);
		}
		.listing {
			background: #fff;
			border: 1px solid #ddd;
			box-shadow: 0 10px 20px rgba(0, 0, 0, 0.2);
			margin: 15px 0;
			overflow: hidden;
		}
		.listing:hover {
			-webkit-transform: scale(1.1);
			-moz-transform: scale(1.1);
			-ms-transform: scale(1.1);
			-o-transform: scale(1.1);
			transform: rotate scale(1.1);
			-webkit-transition: all 0.4s ease-in-out;
			-moz-transition: all 0.4s ease-in-out;
			-o-transition: all 0.4s ease-in-out;
			transition: all 0.4s ease-in-out;
		}
		.shape {
			border-color: rgba(255,255,255,0) #d9534f rgba(255,255,255,0) rgba(255,255,255,0);
		}
		.listing-radius {
			border-radius: 7px;
		}
		.listing-danger {
			border-color: #d9534f;
		}
		.listing-danger .shape {
			border-color: transparent #d9533f transparent transparent;
		}
		.listing-success {
			border-color: #5cb85c;
		}
		.listing-success .shape {
			border-color: transparent #5cb75c transparent transparent;
		}
		.listing-default {
			border-color: #999999;
		}
		.listing-default .shape {
			border-color: transparent #999999 transparent transparent;
		}
		.listing-primary {
			border-color: #428bca;
		}
		.listing-primary .shape {
			border-color: transparent #318bca transparent transparent;
		}
		.listing-info {
			border-color: #5bc0de;
		}
		.listing-info .shape {
			border-color: transparent #5bc0de transparent transparent;
		}
		.listing-warning {
			border-color: #f0ad4e;
		}
		.listing-warning .shape {
			border-color: transparent #f0ad4e transparent transparent;
		}
		.shape-text {
			color: #fff;
			font-size: 12px;
			font-weight: bold;
			position: relative;
			right: -40px;
			top: 2px;
			white-space: nowrap;
			-ms-transform: rotate(30deg); /* IE 9 */
			-o-transform: rotate(360deg); /* Opera 10.5 */
			-webkit-transform: rotate(30deg); /* Safari and Chrome */
			transform: rotate(30deg);
		}
		.listing-content {
			padding: 0 20px 10px;
		}
	</style>
	<!-- Offers List - END -->

</div>

</body>
</html>