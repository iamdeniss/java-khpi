<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>CoffeeLover - Shop</title>
	<link href="https://fonts.googleapis.com/css?family=PT+Sans:400,400i,700,700i&amp;subset=cyrillic" rel="stylesheet">
	<link rel="stylesheet" href="/coffeelover/website/css/style_shop.css">
	<script type="text/javascript" src="/coffeelover/website/js/jquery-3.1.1.min.js"></script>
</head>
<body>
	<header>
		<nav id="header_nav">
            <center>
                <ul>
                    <li><a href="/coffeelover/website/main.jsp">Главная</a></li>
                    <li><a href="">Shop</a></li>
                    <c:choose>
                    	<c:when test="${sessionScope.login eq null}">
                    		<li><a href="/coffeelover/website/enter.jsp">Вход/Регистрация</a></li>
                    	</c:when>
                    	<c:otherwise>
                    		<li style="position: absolute; width: 265px; margin-left: 340px"><a href="/coffeelover/website/basket.jsp">${sessionScope.login}</a></li>
                    		<li><a href="<c:url value="/logout.do"/>">Выход</a></li>
                    	</c:otherwise>
                    </c:choose>
                </ul>
            </center>
        </nav>
    </header>
	<center>
		<table align="center" class="color_table">
			<tr id="first_tr">
				<th>Название</th>
				<th>Товар</th>
				<th>Цена</th>
				<th>Описание</th>
				<th>Купить</th>
			</tr>
			<c:forEach begin="1" end="${names.size()}" varStatus="status">
			<tr>
				<c:choose>
					<c:when test="${status.index eq 0}">
						<td><c:out value="${names.get(0)}"/></td>
						<td><img src="/coffeelover/website/photo/${photos.get(0)}" width="250px"></td>
						<td><c:out value="${prices.get(0)}"/></td>
						<td><div class="description"><c:out value="${descriptions.get(0)}"/></div></td>
						<td class="last"></td>
					</c:when>
					<c:when test="${status.index eq 1}">
						<td><c:out value="${names.get(1)}"/></td>
						<td><img src="/coffeelover/website/photo/${photos.get(1)}" width="250px"></td>
						<td><c:out value="${prices.get(1)}"/></td>
						<td><div class="description"><c:out value="${descriptions.get(1)}"/></div></td>
						<td class="last"></td>
					</c:when>
					<c:when test="${status.index eq 2}">
						<td><c:out value="${names.get(2)}"/></td>
						<td><img src="/coffeelover/website/photo/${photos.get(2)}" width="250px"></td>
						<td><c:out value="${prices.get(2)}"/></td>
						<td><div class="description"><c:out value="${descriptions.get(2)}"/></div></td>
						<td class="last"></td>
					</c:when>
					<c:when test="${status.index eq 3}">
						<td><c:out value="${names.get(3)}"/></td>
						<td><img src="/coffeelover/website/photo/${photos.get(3)}" width="250px"></td>
						<td><c:out value="${prices.get(3)}"/></td>
						<td><div class="description"><c:out value="${descriptions.get(3)}"/></div></td>
						<td class="last"></td>
					</c:when>
					<c:when test="${status.index eq 4}">
						<td><c:out value="${names.get(4)}"/></td>
						<td><img src="/coffeelover/website/photo/${photos.get(4)}" width="250px"></td>
						<td><c:out value="${prices.get(4)}"/></td>
						<td><div class="description"><c:out value="${descriptions.get(4)}"/></div></td>
						<td class="last"></td>
					</c:when>
					<c:when test="${status.index eq 5}">
						<td><c:out value="${names.get(5)}"/></td>
						<td><img src="/coffeelover/website/photo/${photos.get(5)}" width="250px"></td>
						<td><c:out value="${prices.get(5)}"/></td>
						<td><div class="description"><c:out value="${descriptions.get(5)}"/></div></td>
						<td class="last"></td>
					</c:when>
					<c:when test="${status.index eq 6}">
						<td><c:out value="${names.get(6)}"/></td>
						<td><img src="/coffeelover/website/photo/${photos.get(6)}" width="250px"></td>
						<td><c:out value="${prices.get(6)}"/></td>
						<td><div class="description"><c:out value="${descriptions.get(6)}"/></div></td>
						<td class="last"></td>
					</c:when>
				</c:choose>
			</tr>
			</c:forEach>
			
		</table>
		<input class="btn up" type="button" value="Вверх">
		<input class="btn down" type="button" value="Вниз">
		<input class="btn chk" type="button" value="Отметить">
		<input class="btn snd" type="button" value="Добавить в корзину" onclick="buy()">
	</center>
	<footer>
        <center>
            <p>&copy; 2018 CoffeeLover, All Rights Reserved&emsp;</p>
        </center>
    </footer>
	<script type="text/javascript">
		var index = 0;
		$("tr").click(function(){
			$(".color_table tr").css("background-color", "white");
			index = $(this).index();
			$(".color_table tr").eq(index).css("background-color", "#118BB3");
		 });
	</script>
	<script type="text/javascript">
		var rowLength = $('.color_table tr:last').index() + 1;
		var index = 0;
		var color = "rgb(17, 139, 179)";
		$(".up").click(function(){
			for(var i = 0; i < rowLength; i++)
			{
				if(($(".color_table tr").eq(i).css("background-color"))==color)
				{
					index = i;
					break;
				}
			}
			$(".color_table tr").eq(index).css("background-color", "");
			if(($(".color_table tr").eq(index).find("td").eq(4).css("background-color"))!=green)
				$(".color_table tr").eq(index).find("td").eq(4).css("background-color", "");
			if(index == 1)
				$(".color_table tr").eq(7).css("background-color", "#118BB3");
			else
				$(".color_table tr").eq(index-1).css("background-color", "#118BB3");
		 });
	</script>
	<script type="text/javascript">
		var rowLength = $('.color_table tr:last').index() + 1;
		var index = 0;
		var color = "rgb(17, 139, 179)";
		$(".down").click(function(){
			for(var i = 0; i < rowLength; i++)
			{
				if(($(".color_table tr").eq(i).css("background-color"))==color)
				{
					index = i;
					break;
				}
			}
			$(".color_table tr").eq(index).css("background-color", "");
			if(($(".color_table tr").eq(index).find("td").eq(7).css("background-color"))!=green)
				$(".color_table tr").eq(index).find("td").eq(7).css("background-color", "");
			if(index == 7)
				$(".color_table tr").eq(1).css("background-color", "#118BB3");
			else
				$(".color_table tr").eq(index+1).css("background-color", "#118BB3");
		 });
	</script>
	<script type="text/javascript">
		var rowLength = $('.color_table tr:last').index() + 1;
		var index = 0;
		var color = "rgb(17, 139, 179)";
		var green = "rgb(10, 206, 24)";
		$(".chk").click(function(){
			for(var i = 0; i < rowLength; i++)
			{
				if(($(".color_table tr").eq(i).css("background-color"))==color)
				{
					index = i;
					break;
				}
			}

			for(var i = 0; i < rowLength; i++) {
				if(($(".color_table tr").eq(i).css("background-color"))!=green & 
					($(".color_table tr").eq(i).css("background-color"))!=color) {
					$(".color_table tr").eq(i).find("td").eq(4).css("background-color", "#FFFFFF");
				}
			}

			if(($(".color_table tr").eq(index).find("td").eq(4).css("background-color"))==green)
				$(".color_table tr").eq(index).find("td").eq(4).css("background-color", "#118BB3");
			else $(".color_table tr").eq(index).find("td").eq(4).css("background-color", "#0ACE18");
		 });
	</script>
	<script type="text/javascript" src="/coffeelover/website/js/buy.js"></script>
</body>
</html>