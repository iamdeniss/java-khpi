<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>CoffeeLover - Главная</title>
	<link rel="stylesheet" href="css/style_main.css">
    <link href="https://fonts.googleapis.com/css?family=PT+Sans:400,400i,700,700i&amp;subset=cyrillic" rel="stylesheet">
    <link rel="stylesheet" href="css/animate.css">
    <link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.min.css">
    <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
    <script src="js/jquery.viewportchecker.js"></script>
</head>
<body>
	<header>
        <nav id="header_nav">
            <center>
                <ul>
                    <li><a href="">Главная</a></li>
                    <li><a href="<c:url value="/shop.do"/>">Shop</a></li>
                    <c:choose>
                    	<c:when test="${sessionScope.login eq null}">
                    		<li><a href="enter.jsp">Вход/Регистрация</a></li>
                    	</c:when>
                    	<c:otherwise>
                    		<li style="position: absolute; width: 265px; margin-left: 340px"><a href="basket.jsp">${sessionScope.login}</a></li>
                    		<li><a href="<c:url value="/logout.do"/>">Выход</a></li>
                    	</c:otherwise>
                    </c:choose>
                </ul>
            </center>
        </nav>
        <div class="angle_down">
            <a href=".absents"><i class="fa fa-angle-down fa-3x" aria-hidden="true"></i></a>
        </div>
    </header>
    <center class="absents">
        <div id="quote">
            <blockquote>
                <p>Ради кофе можно пойти на все. Даже на работу.</p>
                — <cite>Билл Гейтс</cite>
            </blockquote>
        
        </div>
    </center>
    <div class="images1">
        <center>
            <img src="photo/coffee.jpg" width="49%">
            <img src="photo/coffee-ingridients.jpg" width="49%">
        </center>
    </div>
    <center class="absents">
        <div id="quote">
            <blockquote>
                <p>Кофе - это не напиток. Это длинные уютные разговоры, приятные встречи и милые свидания; это бодрое утро и мягкий молочный вечер, кофе - это настроение! Настроение жить.</p>
            </blockquote>
        </div>
    </center>
    <div class="images2">
        <center>
            <img src="photo/coffee-machine.jpg" width="49%">
            <img src="photo/coffee-preparing.jpg" width="49%">
        </center>
    </div>
    <center class="absents">
        <div id="quote">
            <blockquote>
                <p>Для вдохновения мне нужны только раскрытый рояль, тишина и чашечка кофе.</p>
                — <cite>Иоганн Штраус</cite>
            </blockquote>
        </div>
    </center>
    <div class="images3">
        <center>
            <img src="photo/coffee-and-flowers.jpg" width="49%">
            <img src="photo/coffee-cheers.jpg" width="49%">
        </center>
    </div>
    <footer class="foot">
        <center>
            <p class="cpyrght">&copy; 2018 CoffeeLover, All Rights Reserved&emsp;</p>
        </center>
    </footer>
    <script>
        var $page = $('html, body');
        $('a[href*="."]').click(function() {
            $page.animate({
                scrollTop: $($.attr(this, 'href')).offset().top
            }, 1200);
            return false;
        });
    </script>
    <script>
        jQuery(document).ready(function() {
            jQuery('.absents').addClass("hidden").viewportChecker({
                classToAdd: 'visible animated fadeIn',
                offset: 70
            });
            jQuery('.images1').addClass("hidden").viewportChecker({
                classToAdd: 'visible animated fadeIn',
                offset: 70
            });
            jQuery('.images2').addClass("hidden").viewportChecker({
                classToAdd: 'visible animated fadeIn',
                offset: 70
            });
            jQuery('.images3').addClass("hidden").viewportChecker({
                classToAdd: 'visible animated fadeIn',
                offset: 70
            });
            jQuery('.foot').addClass("hidden").viewportChecker({
                classToAdd: 'visible animated fadeIn',
                offset: 70
            });
        });
    </script>
</body>
</html>