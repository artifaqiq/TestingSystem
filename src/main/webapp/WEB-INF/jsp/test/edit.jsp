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
    <!-- AngularJS-->
    <script src="/static/js/lib/angular.min.js"></script>

    <link href="/static/css/templates/menu.css" rel="stylesheet">
    <link href="/static/css/test/create.css" rel="stylesheet">

    <script src="/static/js/test/create/create-test-app.js"></script>

</head>

<body ng-app="CreateTestApp" class="col-sm-12" ng-controller="Controller as C">

<jsp:include page="/WEB-INF/jsp/templates/menu.jsp"/>

<div class="col-sm-6">
    <div class="content-header">
        <h1>Edit</h1>
    </div>

    <div>
        <!-- Name-->
        <div class="form-group">
            <label for="name">Name:</label>
            <input ng-model="C.test.name" type="text" class="form-control" id="name" style="font-size: large">
        </div>

        <!-- Description-->
        <div class="form-group">
            <label for="desctiption">Descrtiption:</label>
            <textarea ng-model="C.test.description" class="form-control" rows="5" id="desctiption"></textarea>
        </div>

        <!-- Strategy -->
        <label for="strategy">Strategy:</label>
        <div id="strategy">
            <div class="radio">
                <label><input ng-model="C.test.strategy" value="1" type="radio" name="optradio">Strict</label><br/>
                <label><input ng-model="C.test.strategy" value="2" type="radio" name="optradio">Scaled</label>
            </div>
        </div>

        <!-- Tasks -->
        <label for="tasks">Tasks:</label>
        <div ng-repeat="task in C.test.tasks" id="tasks">

            <!-- Task -->
            <div class="well col-sm-12">

                <!-- Name-->
                <label class="col-sm-12">Text</label>
                <!-- Text -->
                <div class="col-sm-10">
                    <textarea ng-model="task.text" type="text" rows="5" class="form-control"></textarea>
                </div>

                <div class="col-sm-2 center">
                    <button ng-click="C.remove(C.test.tasks, task)" type="button"
                            class="btn btn-danger btn-number" data-field="quant[2]">
                        <span class="glyphicon glyphicon-remove"></span>
                    </button>
                </div>

                <!-- Add answer -->

                <!-- Points -->
                <div class="form-group col-sm-3">
                    <label for="points">Points:</label>
                    <select class="form-control" id="points">
                        <option ng-repeat="x in C.range(100)">{{x}}</option>
                    </select>
                </div>

                <!-- Answers -->
                <div class="col-sm-12">
                    <label for="answers">Answers:</label>
                    <div ng-repeat="answer in task.answers" id="answers" class="col-sm-12">

                        <!-- Answer -->
                        <!-- Is correct? -->
                        <div class="checkbox col-sm-1">
                            <label><input ng-model="answer.isCorrect" type="checkbox"></label>
                        </div>

                        <!-- Text -->
                        <div class="col-sm-9">
                            <input ng-model="answer.text" type="text" class="form-control" id="answer-text">
                        </div>

                        <div class="col-sm-2">
                            <button ng-click="C.remove(task.answers, answer)" type="button"
                                    class="btn btn-danger btn-number ">
                                <span class="glyphicon glyphicon-remove"></span>
                            </button>
                        </div>

                        <!-- Add answer -->

                    </div>
                </div>
                <div class="col-sm-6 col-sm-offset-3" style="margin-top: 2%">
                    <button ng-click="C.addAnswer(task)" type="button" class="btn btn-block btn-success btn-number"
                            data-type="plus" data-field="quant[2]">
                        <span class="glyphicon glyphicon-plus"></span>
                    </button>
                </div>

                <div class="col-sm-12">

                </div>

            </div>


        </div>

        <div class="col-sm-12">
            <button ng-click="C.addTask()" type="button" class="btn btn-success btn-block btn-number" data-type="plus"
                    data-field="quant[2]">
                <span class="glyphicon glyphicon-plus"></span>
            </button>
        </div>

        <div>
            <h4>Model</h4>
            {{C.test}}
        </div>
    </div>


</div>

<div class="col-sm-6">
    <div class="content-header">
        <h1>Preview</h1>
    </div>

    <div class="col-sm-12">
        <!-- Name-->
        <div class="page-header">
            <h2><div>{{C.test.name}}</div>
                <small>
                    {{C.test.description}}
                </small>
            </h2>
        </div>

        <!-- Tasks -->
        <label for="tasks">Tasks:</label>
        <div ng-repeat="task in C.test.tasks">

            <!-- Task -->
            <div class="well col-sm-12">

                <h3>{{task.text}}</h3>

                <div class="col-sm-12">
                    <div ng-repeat="answer in task.answers" class="[ form-group ]">
                        <input type="checkbox" name="fancy-checkbox-default" id="fancy-checkbox-default" autocomplete="off" />
                        <div class="[ btn-group ] col-sm-12 ">
                            <label for="fancy-checkbox-default" class="[ btn btn-default ] col-sm-1">
                                <span class="[ glyphicon glyphicon-ok ]"></span>
                            </label>
                            <div class="col-sm-11">
                                {{answer.text}}
                            </div>
                        </div>
                    </div>
                </div>

            </div>


        </div>

    </div>
</div>


</div>
</section>
</body>
</html>
