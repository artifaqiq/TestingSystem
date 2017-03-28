<%--
  Created by Artur Lomako
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sing in</title>

    <jsp:include page="/jsp/templates/head.jsp" />

    <script src="<c:url value="/js/lib/jquery-3.2.0.min.js" />"></script>

    <link href="<c:url value="/css/user/login-register.css" />" rel="stylesheet">
    <script src="<c:url value="/js/user/login-register.js" />"></script>
    <script src="<c:url value="/js/user/login.js" />"></script>
</head>
<body>
<div class="materialContainer">


    <div class="box">

        <div class="title">Sign in</div>

        <div class="input">
            <label for="email" id="email-lbl">Email</label>
            <input type="text" name="name" id="email">
            <span class="spin"></span>
        </div>


        <div class="input">
            <label for="pass" id="pass-lbl">Password</label>
            <input type="password" name="pass" id="pass">
            <span class="spin"></span>
        </div>

        <div class="button login">
            <button id="reg-btn"><span id="reg-spn">Sign in</span> <i class="fa fa-check"></i></button>
        </div>

        <a href="" class="pass-forgot">Forgot your password?</a>

    </div>

</div>
</body>
</html>
