<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>CoffeeLover - Корзина</title>
	<link href="https://fonts.googleapis.com/css?family=PT+Sans:400,400i,700,700i&amp;subset=cyrillic" rel="stylesheet">
	<link rel="stylesheet" href="css/style_trash.css">
</head>
<body>
	<header>
		<nav id="header_nav">
            <center>
                <ul>
                    <li><a href="main.jsp">Главная</a></li>
                    <li><a href="<c:url value="/shop.do"/>">Shop</a></li>
                    <li><a href="basket.jsp">${sessionScope.login}</a></li>
                    <li><a href="<c:url value="/logout.do"/>">Выход</a></li>
                </ul>
            </center>
        </nav>
    </header>
    <center>
        <div class="tov">
        <c:choose>
        	<c:when test="${not empty sessionScope.myGoods}">
            	<h1>Товары для заказа</h1>
            	<table class="basketTable">
            		<tr class="headers">
            			<th>№</th>
            			<th>Название товара</th>
            			<th>Цена</th>
            			<th style="border-style:hidden"></th>
            		</tr>
            		<c:forEach items="${sessionScope.myGoods}" var="good" varStatus="status">
            			<tr>
            				<td><c:out value="${status.index+1}"/></td>
            				<td><c:out value="${good.name}"/></td>
            				<td><c:out value="${good.price} грн."/></td>
            				<td style="border-style:hidden">
            					<form action="<c:url value="/removeFromBasket.do?position=${status.index}"/>" method="post">
            						<input type="submit" value="X" style="background-color: #fff; border: none; color: #925C32">
            					</form>
            				</td>
            			</tr>
            		</c:forEach>
            		<tr>
            			<td colspan="2">Всего:</td>
            			<td>${sessionScope.total} грн.</td>
            		</tr>
            	</table>
            	<div style="margin-top: 20px"><a href="/coffeelover/website/makeOrder.jsp">Оформить заказ</a></div>
            </c:when>
            <c:otherwise>
            	<h1>No products</h1>
  			</c:otherwise>
        </c:choose>
        </div>
    </center>
    <footer>
        <center>
            <p>&copy; 2018 CoffeeLover, All Rights Reserved&emsp;</p>
        </center>
    </footer>
</body>
</html>