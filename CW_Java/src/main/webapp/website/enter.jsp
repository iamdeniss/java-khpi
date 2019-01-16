<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>CoffeeLover - Welcome</title>
	<link rel="stylesheet" href="css/style_enter.css">
	<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
</head>
<body>
	<header>
		<nav id="header_nav">
            <center>
                <ul>
                    <li><a href="main.jsp">Главная</a></li>
                    <li><a href="<c:url value="/shop.do"/>">Shop</a></li>
                    <li><a href="">Вход/Регистрация</a></li>
                </ul>
            </center>
        </nav>
    </header>
    <div class="formm">
	    <center>
		    <div id="enterr">
		            <form action="<c:url value="/enter.do"/>" method="post">
		            	<p><input type="text" name="login" class="login field" placeholder="Login" onfocus="this.placeholder=''" onblur="this.placeholder='Login'" required></p>
		                <p><input type="password" name="password" class="password field" placeholder="Пароль" onfocus="this.placeholder=''" onblur="this.placeholder='Пароль'" required></p>
		                <div>
		                	<button class="validBtn" type="submit" name="enter">Вход</button>
		                	<button class="validBtn" type="submit" name="registration">Регистрация</button>
		                </div>
		            </form>
		    </div>
	    </center>
	</div>
	<footer>
        <center>
            <p>&copy; 2018 CoffeeLover, All Rights Reserved&emsp;</p>
        </center>
    </footer>
</body>
</html>