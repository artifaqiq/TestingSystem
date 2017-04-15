<%@ page import="com.netcracker.dev3.lomako.constants.CommandPath" %><%--
  Created by Artur Lomako
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>${tr.translate("login")}</title>

    <jsp:include page="/WEB-INF/jsp/templates/head.jsp" />

    <script src="/static/js/lib/jquery-3.2.0.min.js"></script>

    <link href="/static/css/user/login-register.css" rel="stylesheet">
    <script src="/static/js/user/login-register.js"></script>
    <script src="/static/js/user/login.js"></script>
</head>
<body>

<div class="materialContainer">

    <jsp:include page="/WEB-INF/jsp/templates/notice.jsp" />

    <div class="box">

        <div class="title">${tr.translate("login")}</div>

        <form id="form" action="<%= CommandPath.LOGIN %>" method="post">

            <div class="input">
                <label for="email" id="email-lbl">Email</label>
                <input type="text" name="email" id="email">
                <span class="spin"></span>
            </div>


            <div class="input">
                <label for="pass" id="pass-lbl">${tr.translate("password")}</label>
                <input type="password" name="password" id="pass">
                <span class="spin"></span>
            </div>

        </form>

        <div class="button login">
            <button id="log-btn"><span id="reg-spn">${tr.translate("login")}</span> <i class="fa fa-check"></i></button>
        </div>

    </div>

    <a href="<%= CommandPath.REGISTER %>">
        ${tr.translate("register")}
    </a>

</div>
</body>
</html>
