<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>CoffeeLover - Оформление заказа</title>
	<link href="https://fonts.googleapis.com/css?family=PT+Sans:400,400i,700,700i&amp;subset=cyrillic" rel="stylesheet">
	<link rel="stylesheet" href="css/style_makeOrder.css">
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
         	<h1>Оформление заказа</h1>
         	<table class="basketTable">
         		<tr class="headers">
         			<th>№</th>
         			<th>Название товара</th>
         			<th>Цена</th>
         		</tr>
         		<c:forEach items="${sessionScope.myGoods}" var="good" varStatus="status">
         			<tr>
         				<td><c:out value="${status.index+1}"/></td>
         				<td><c:out value="${good.name}"/></td>
         				<td><c:out value="${good.price} грн."/></td>
         			</tr>
         		</c:forEach>
         		<tr>
           			<td colspan="2">Всего:</td>
           			<td>${sessionScope.total} грн.</td>
            	</tr>
         	</table>
         	<form method="POST" name="form" action="<c:url value="/makeOrder.do"/>" class="myForm" style="margin-top: 10px">
       			<input type="text" name="adress" placeholder="Адресс" onfocus="this.placeholder=''" onblur="this.placeholder='Адресс'" required>&#8195;
       			<input type="text" name="cardNumber" placeholder="Номер карты" onfocus="this.placeholder=''" onblur="this.placeholder='Номер карты'" required><br>
       			<button type="submit">Заказать</button>
         	</form>
        </div>
    </center>
    <footer>
        <center>
            <p>&copy; 2018 CoffeeLover, All Rights Reserved&emsp;</p>
        </center>
    </footer>
</body>
</html>