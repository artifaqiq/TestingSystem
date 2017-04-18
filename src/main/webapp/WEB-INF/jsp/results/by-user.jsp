<%@ page import="com.netcracker.dev3.lomako.constants.CommandPath" %><%--
  Created by Artur Lomako
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test results</title>

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

</head>
<body>
<jsp:include page="/WEB-INF/jsp/templates/menu.jsp"/>
<c:choose>
    <c:when test="${test_results.size() == 0}">
        There are not test results
    </c:when>
    <c:otherwise>
        <c:forEach var="i" begin="0" end="${test_results.size() - 1}">
            <div style="margin: 0.5%" class="widget-box sample-widget">
                <div class="widget-header">
                    <a href="<%= CommandPath.SOLVE_TEST %>&id=${test_results[i].test.id}">
                        <h2>
                            <strong>${test_results[i].test.name}</strong>
                        </h2>
                    </a>
                </div>
                <div class="widget-content">
                    <div class="panel">
                        <div class="panel-body"><h3>Result: <strong>${test_results[i].points}</strong></h3></div>

                    </div>
                </div>
            </div>
        </c:forEach>
    </c:otherwise>
</c:choose>

</section>
</body>
</html>
