<%--
  Created by Artur Lomako
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>${tr.translate("register")}</title>

    <jsp:include page="/WEB-INF/jsp/templates/head.jsp"/>

    <script src=/static/js/lib/jquery-3.2.0.min.js"></script>
    <script src="/static/js/lib/jquery.complexify.min.js"></script>

    <link href= "/static/css/user/login-register.css" rel="stylesheet">
    <script src= "/static/js/user/login-register.js"></script>
    <script src= "/static/js/user/register.js"></script>
</head>
<body>
<div class="materialContainer">

    <jsp:include page="/WEB-INF/jsp/templates/notice.jsp"/>

    <div class="box">

        <div class="title">${tr.translate("register")}</div>

        <form id="form" method="post">

            <div class="input">
                <label for="email" id="email-lbl">Email</label>
                <input type="text" name="email" id="email">
                <span class="spin"></span>
            </div>

            <div class="input">
                <label for="first-name" id="first-name-lbl">${tr.translate("first_name")}</label>
                <input type="text" name="firstName" id="first-name">
                <span class="spin"></span>
            </div>

            <div class="input">
                <label for="last-name" id="last-name-lbl">${tr.translate("last_name")}</label>
                <input type="text" name="lastName" id="last-name">
                <span class="spin"></span>
            </div>

            <div class="input">
                <label for="pass" id="pass-lbl">${tr.translate("password")}</label>
                <input type="password" name="password" id="pass">
                <span class="spin"></span>
            </div>

            <div class="input">
                <label for="repass" id="repass-lbl">${tr.translate("password_confirm")}</label>
                <input type="password" id="repass">
                <span class="spin"></span>
            </div>

        </form>

        <div class="button login">
            <button id="reg-btn"><span id="reg-spn">${tr.translate("register")}</span></button>
        </div>
    </div>

</div>
</body>
</html>
