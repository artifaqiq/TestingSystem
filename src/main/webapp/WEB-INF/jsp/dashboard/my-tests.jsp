<%--
  Created by Artur Lomako
--%>
<%@ page import="com.netcracker.dev3.lomako.constants.CommandPath" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>My tests</title>

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

<div style="padding: 2%">

    <c:choose>
        <c:when test="${testCount == 0}">
            <p>You have not tests</p>
        </c:when>
        <c:otherwise>

            <c:forEach var="i" begin="0" end="${testCount - 1}">
                <div class="panel panel-default col-sm-6">
                    <div class="panel-heading">
                        <div style="display: inline-block" class="text-left"><strong>${tests[i].name}</strong></div>
                        <div style="display: inline-block" class="pull-right"><a
                                href="<%= CommandPath.DELETE_TEST %>&id=${tests[i].id}">Delete</a></div>
                        <div style="display: inline-block" class="pull-right"><a
                                href="<%= CommandPath.EDIT_TEST %>&id=${tests[i].id}">Edit  </a></div>

                    </div>
                    <div class="panel-body">${tests[i].description}</div>
                    <div class="panel-footer"><i>${tests[i].created}</i></div>
                </div>
            </c:forEach>
        </c:otherwise>
    </c:choose>

    <div class="col-sm-6 col-sm-offset-3">
        <form action="<%= CommandPath.CREATE_TEST %>" method="post">
            <button type="submit" class="btn btn-block btn-success"
                    data-type="plus" data-field="quant[2]">
                <span class="glyphicon glyphicon-plus"></span>
            </button>
        </form>
    </div>
</div>

</section>
</body>
</html>
