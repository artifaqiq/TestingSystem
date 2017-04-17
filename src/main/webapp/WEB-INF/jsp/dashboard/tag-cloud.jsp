<%--
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

    <link href="/static/css/templates/menu.css" rel="stylesheet">
    <link href="/static/css/test/create.css" rel="stylesheet">

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="http://www.goat1000.com/jquery.tagcanvas.min.js"></script>
    <script src="/static/js/dashboard/tag-cloud.js"></script>
</head>
<body>

<jsp:include page="/WEB-INF/jsp/templates/menu.jsp"/>

<div id="myCanvasContainer">
    <canvas width="800" height="800" id="myCanvas">
        <p>Anything in here will be replaced on browsers that support the canvas element</p>
    </canvas>
</div>
<div id="tags"  style="font-size: 50%">
    <a href="#" style="font-size: 2.83ex">1000</a>
    <a href="#" style="font-size: 3.61ex">background</a>
    <a href="#" style="font-size: 9.64ex">canvas</a>
    <a href="#" style="font-size: 4.47ex">chart</a>
    <a href="#" style="font-size: 3.46ex">charts</a>
    <a href="#" style="font-size: 12.32ex">cloud</a>
    <a href="#" style="font-size: 3.74ex">clouds</a>
    <a href="#" style="font-size: 3.16ex">example</a>
    <a href="#" style="font-size: 3.74ex">goat</a>
    <a href="#" style="font-size: 3.16ex">goat1000</a>
    <a href="#" style="font-size: 8.36ex">graph</a>
    <a href="#" style="font-size: 4.36ex">graphs</a>
    <a href="#" style="font-size: 3.32ex">html</a>
    <a href="#" style="font-size: 10.68ex">html5</a>
    <a href="#" style="font-size: 4.69ex">image</a>
    <a href="#" style="font-size: 4.8ex">javascript</a>
    <a href="#" style="font-size: 5.47ex">jpeg</a>
    <a href="#" style="font-size: 2.65ex">jpegsaver</a>
    <a href="#" style="font-size: 8.77ex">jquery</a>
    <a href="#" style="font-size: 2.65ex">lib</a>
    <a href="#" style="font-size: 5.92ex">library</a>
    <a href="#" style="font-size: 3.32ex">link</a>
    <a href="#" style="font-size: 13.23ex">php</a>
    <a href="#" style="font-size: 2.83ex">plugin</a>
    <a href="#" style="font-size: 4.58ex">saver</a>
    <a href="#" style="font-size: 3.32ex">screensaver</a>
    <a href="#" style="font-size: 2.65ex">script</a>
    <a href="#" style="font-size: 13ex">svg</a>
    <a href="#" style="font-size: 4.47ex">svggraph</a>
    <a href="#" style="font-size: 12.44ex">tag</a>
    <a href="#" style="font-size: 2.65ex">tagcanvas</a>
    <a href="#" style="font-size: 3.46ex">tagcloud</a>
    <a href="#" style="font-size: 2.65ex">text</a>
    <a href="#" style="font-size: 3.16ex">word</a>
</section>
</div>
</body>
</html>
