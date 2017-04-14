<%--
  Created by Artur Lomako
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Artur Lomako</title>

    <jsp:include page="/WEB-INF/jsp/templates/head.jsp" />

    <script src="https://s.codepen.io/assets/libs/modernizr.js" type="text/javascript"></script>
    <script src="/static/js/lib/jquery-3.2.0.min.js"></script>
    <link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,600,700' rel='stylesheet' type='text/css'>
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

    <link href="/static/css/templates/menu.css" rel="stylesheet">

</head>

<body>

    <h1>
        <%= pageContext.getSession().getAttribute("email")%>
    </h1>
    <jsp:include page="/WEB-INF/jsp/templates/menu.jsp" />

</body>
</html>
