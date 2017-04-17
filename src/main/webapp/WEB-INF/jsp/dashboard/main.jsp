<%--
  Created by Artur Lomako
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Dashboard</title>

    <jsp:include page="/WEB-INF/jsp/templates/head.jsp"/>

    <script src="https://s.codepen.io/assets/libs/modernizr.js" type="text/javascript"></script>
    <script src="/static/js/lib/jquery-3.2.0.min.js"></script>
    <link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,600,700' rel='stylesheet' type='text/css'>
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link href="/static/css/templates/menu.css" rel="stylesheet">

</head>

<body>

<jsp:include page="/WEB-INF/jsp/templates/menu.jsp"/>
<div class="content">
    <div class="content-header">
        <h1>Dashboard</h1>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    </div>
    <div class="widget-box sample-widget">
        <div class="widget-header">
            <h2>Mathematics</h2>
        </div>
        <div class="widget-content">
            About mathematics
        </div>
    </div>
    <div class="widget-box sample-widget">
        <div class="widget-header">
            <h2>Mathematics</h2>
            <a class="fa fa-pencil fa-lg" href="#"></a>
            <a class="fa fa-trash fa-lg" href="#"></a>
        </div>
        <div class="widget-content">
            <div class="panel">
                <div class="panel-body">Description</div>
                <div class="panel-footer"><i>Date</i></div>
            </div>
        </div>
    </div>
    <div class="widget-box sample-widget">
        <div class="widget-header">
            <h2>Widget Header</h2>
            <i class="fa fa-cog"></i>
        </div>
        <div class="widget-content">
            <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/87118/sample-data-1.png">
        </div>
    </div>
    <div class="widget-box sample-widget">
        <div class="widget-header">
            <h2>Widget Header</h2>
            <i class="fa fa-cog"></i>
        </div>
        <div class="widget-content">
            <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/87118/sample-data-1.png">
        </div>
    </div>
</div>
</section>

</body>
</html>
