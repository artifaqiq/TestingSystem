<%@ page import="com.netcracker.dev3.lomako.constants.CommandPath" %><%--
  Created by Artur Lomako
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Tag cloud</title>

    <jsp:include page="/WEB-INF/jsp/templates/head.jsp"/>

    <script src="https://s.codepen.io/assets/libs/modernizr.js" type="text/javascript"></script>
    <script src="/static/js/lib/jquery-3.2.0.min.js"></script>
    <link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,600,700' rel='stylesheet' type='text/css'>
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="/static/js/lib/angular.min.js"></script>

    <link href="/static/css/menu.css" rel="stylesheet">
    <link href="/static/css/edit-test.css" rel="stylesheet">

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="http://www.goat1000.com/jquery.tagcanvas.min.js"></script>
    <script src="/static/js/dashboard/tag-cloud.js"></script>
</head>
<body>

<jsp:include page="/WEB-INF/jsp/templates/menu.jsp"/>

<div id="myCanvasContainer">
    <canvas width="800" height="800" id="myCanvas">
    </canvas>
</div>
<div id="tags"  style="font-size: 50%">
    <c:forEach var="i" begin="0" end="${tags.size()}">
        <a href="<%= CommandPath.TESTS_BY_TAG %>&tag=${tags[i].title}" style="font-size: 12.32ex">${tags[i].title}</a>
    </c:forEach>

</section>
</div>
</body>
</html>
