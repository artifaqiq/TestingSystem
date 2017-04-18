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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="/static/css/menu.css" rel="stylesheet">

</head>
<body>
<jsp:include page="/WEB-INF/jsp/templates/menu.jsp"/>

<div class="content">

    <div style="padding: 2%">

        <c:choose>
            <c:when test="${tests.size() == 0 || tests == null}">
                <div class="content-header">
                    <p>There are no tests</p>
                </div>
            </c:when>
            <c:otherwise>

                <c:forEach var="i" begin="0" end="${tests.size() - 1}">

                    <div class="widget-box sample-widget">
                        <div class="widget-header">
                            <a href="<%= CommandPath.SOLVE_TEST %>&id=${tests[i].id}"><h2>${tests[i].name}</h2></a>
                            <a class="fa fa-pencil fa-lg" href="<%= CommandPath.EDIT_TEST %>&id=${tests[i].id}"></a>
                            <a class="fa fa-trash fa-lg" href="<%= CommandPath.DELETE_TEST %>&id=${tests[i].id}"></a>
                            <a class="fa fa-user-o fa-lg" href="<%= CommandPath.TEST_RESULTS_BY_TEST%>&id=${tests[i].id}"></a>
                        </div>
                        <div class="widget-content">
                            <div class="panel">
                                <div class="panel-body">${tests[i].description}</div>
                                <div style="margin: 2%"><c:forEach var="j" begin="0" end ="${tests[i].getTags().size()}">
                                    <a href="<%= CommandPath.TESTS_BY_TAG %>&tag=${tests[i].tags[j].title}">${tests[i].tags[j].title}</a>
                                </c:forEach></div>
                                <div class="panel-footer"><i>${tests[i].created}</i></div>
                            </div>
                        </div>
                    </div>

                </c:forEach>
            </c:otherwise>
        </c:choose>

    </div>

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
