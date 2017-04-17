<%--
  Created by Artur Lomako
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>${tr.translate("test_solving")}</title>

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

    <script src="/static/js/test/solve-test-app.js"></script>
    <link href="/static/css/test/solve.css" rel="stylesheet">

</head>

<body ng-app="CreateTestApp" class="col-sm-12" ng-controller="Controller as C">

<jsp:include page="/WEB-INF/jsp/templates/menu.jsp"/>

<div class="col-sm-6">

    <div class="col-sm-12">
        <!-- Name-->
        <div class="page-header">
            <h2>
                <div>{{C.test.name}}</div>
                <small>
                    {{C.test.description}}
                </small>
            </h2>
        </div>

        <!-- Tasks -->
        <div ng-repeat="task in C.test.tasks">

            <!-- Task -->
            <div class="well col-sm-12">

                <h3>{{task.text}}</h3>

                <div ng-repeat="answer in task.answers">
                    <div class="checkbox">
                        <label class="{{answer.class}}">
                            <input ng-model="answer.isCorrect"
                                   ng-true-value="true"
                                   ng-false-value="false"
                                   type="checkbox">
                            {{answer.text}}
                        </label>
                    </div>
                </div>

            </div>


        </div>

        <div ng-if="C.points === undefined">
            <button ng-click="C.submit()" class="btn btn-success">
                Submit
            </button>
        </div>
        <div ng-if="C.points !== undefined" class="page-header">
            <h3>Result: {{C.points}}</h3>
        </div>

    </div>

</div>

</section>
</body>
</html>
