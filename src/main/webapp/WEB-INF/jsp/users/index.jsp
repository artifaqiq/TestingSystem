<%@ page import="com.netcracker.dev3.lomako.constants.CommandPath" %><%--
  Created by Artur Lomako
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>

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

<c:forEach var="i" begin="0" end="${users.size() - 1}">
    <div style="margin-top: 1%" class="panel panel-default col-sm-7">
        <div class="panel-heading">
            <strong>
                ${users[i].firstName} ${users[i].lastName} (${users[i].email})
            </strong>
        </div>
        <div class="panel-body">
            <div>
               <a href="<%=CommandPath.TEST_RESULTS_BY_USER%>&id=${users[i].id}">Solved tests</a>
            </div>
            <div>
               <a href="<%=CommandPath.MY_TESTS%>&id=${users[i].id}">Tests</a>
            </div>
        </div>
        <div class="panel-footer">
            <i>Registered since ${users[i].created}</i>
        </div>
    </div>
</c:forEach>

</section>
</body>
</html>
