<%--
  Created by Artur Lomako
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>${tr.translate("task_editing")}</title>

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

    <link href="/static/css/menu.css" rel="stylesheet">
    <link href="/static/css/edit-test.css" rel="stylesheet">

    <script src="/static/js/test/create/create-test-app.js"></script>

</head>

<body ng-app="CreateTestApp" class="col-sm-12" ng-controller="Controller as C">

<jsp:include page="/WEB-INF/jsp/templates/menu.jsp"/>

<div class="col-sm-6">
    <div class="content-header">
        <h1>${tr.translate("edit")}</h1>
    </div>

    <div>
        <!-- Name-->
        <div class="form-group">
            <label for="name"><h3><strong>${tr.translate("name")}:</h3></label>
            <input ng-model="C.test.name" ng-change="C.change()" type="text" class="form-control" id="name" style="font-size: large">
        </div>

        <!-- Description-->
        <div class="form-group">
            <label for="desctiption"><h3><strong>${tr.translate("description")}:</strong></h3></label>
            <textarea ng-model="C.test.description" ng-change="C.change()" class="form-control" rows="5" id="desctiption"></textarea>
        </div>

        <!-- Tags -->
        <div class="form-group">
            <label></h3><strong>${tr.translate("tags")}:</strong></h3></label>
            <div ng-repeat="tag in C.test.tags">
                <div class="col-sm-10">
                    <input ng-model="tag.title" ng-change="C.change()" type="text" class="form-control">
                </div>
                <div class="col-sm-2">
                    <button ng-click="C.remove(C.test.tags, tag)" type="button"
                            class="btn btn-danger btn-number ">
                        <span class="glyphicon glyphicon-remove"></span>
                    </button>
                </div>
            </div>

            <div style="margin-top: 2%">
                <button ng-click="C.addTag()" type="button" style="margin-top: 2%" class="btn btn-block btn-success btn-number col-sm-6">
                    <span>${tr.translate("add_tag")}</span>
                </button>

            </div>

        </div>

        <!-- Strategy -->
        <label for="strategy"><h3><strong>${tr.translate("strategy")}:</strong></h3></label>
        <div id="strategy">
            <div class="radio">
                <label><input ng-model="C.test.resultCalculationStrategyWay" ng-change="C.change()" value="STRICT" type="radio"
                              name="optradio">Strict</label><br/>
                <label><input ng-model="C.test.resultCalculationStrategyWay"  ng-change="C.change()" value="SCALED" type="radio"
                              name="optradio">Scaled</label>
            </div>
        </div>

        <!-- Tasks -->
        <label for="tasks"><h3><strong>${tr.translate("tasks")}:</strong></h3></label>
        <div ng-repeat="task in C.test.tasks" id="tasks">

            <!-- Task -->
            <div class="well col-sm-12">

                <!-- Name-->
                <label class="col-sm-12">${tr.translate("text")}</label>
                <!-- Text -->
                <div class="col-sm-10">
                    <textarea ng-model="task.text" ng-change="C.change()" type="text" rows="5" class="form-control"></textarea>
                </div>

                <div class="col-sm-2 center">
                    <button ng-click="C.remove(C.test.tasks, task)" type="button"
                            class="btn btn-danger btn-number" data-field="quant[2]">
                        <span class="glyphicon glyphicon-remove"></span>
                    </button>
                </div>

                <!-- Add answer -->

                <!-- Points -->
                <div  class="form-group col-sm-3">
                    <label for="points">${tr.translate('points')}:</label>
                    <select ng-init="task.pointsForCorrectAnswer = task.pointsForCorrectAnswer.toString()"
                            ng-model="task.pointsForCorrectAnswer" ng-change="C.change()" class="form-control" id="points">
                        <option ng-repeat="x in C.range(100)">{{x}}</option>
                    </select>
                </div>

                <!-- Answers -->
                <div class="col-sm-12">
                    <label for="answers">${tr.translate('answers')}:</label>
                    <div ng-repeat="answer in task.answers" id="answers" class="col-sm-12">

                        <!-- Answer -->
                        <!-- Is correct? -->
                        <div class="checkbox col-sm-1">
                            <label><input ng-model="answer.isCorrect" ng-change="C.change()" type="checkbox"></label>
                        </div>

                        <!-- Text -->
                        <div class="col-sm-9">
                            <input ng-model="answer.text" ng-change="C.change()" type="text" class="form-control" id="answer-text">
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
                    <button ng-click="C.addAnswer(task)" type="button" class="btn btn-block btn-success btn-number">
                        <span>${tr.translate('add_answer')}</span>
                    </button>
                </div>

                <div class="col-sm-12">

                </div>

            </div>


        </div>

        <div class="col-sm-12">
            <button ng-click="C.addTask()" type="button" class="btn btn-success btn-block btn-number" data-type="plus"
                    data-field="quant[2]">
                <span>${tr.translate("add_task")}</span>
            </button>
        </div>

        <button ng-click="C.save()" class="col-sm-12 btn {{C.saveButtonClass}} btn-block" style="margin-top: 3%">
            <h5><strong>${tr.translate('save')}</strong></h5>
        </button>

    </div>


</div>


<div class="col-sm-6">

    <div class="content-header">
        <h1>${tr.translate("preview")}</h1>
    </div>
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


    </div>

</div>

</div>
</section>
</body>
</html>
