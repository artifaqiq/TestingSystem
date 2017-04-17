/**
 * Created by Artur Lomako on 4/17/17.
 */
/**
 * Created by Artur Lomako on 4/14/17.
 */

var app = angular.module('CreateTestApp', []);

function getParameterByName(name, url) {
    if (!url) {
        url = window.location.href;
    }
    name = name.replace(/[\[\]]/g, "\\$&");
    var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
        results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, " "));
}


app.controller('Controller', function ($http) {
    console.log(window.location);
    var self = this;
    self.testId = getParameterByName("id");

    self.points = undefined;

    $http({
        method: 'GET',
        url: '/Controller?command=read_test_for_solve&id=' + self.testId
    }).then(function (response) {
        console.log(response);
        self.test = response.data;
        self.orignal = JSON.parse(JSON.stringify(self.test));

    }, function (response) {
        console.error(response);
    });

    self.service = {
        submit: function () {
            $http({
                method: 'POST',
                url: '/Controller?command=send_solved_test&id=' + self.testId,
                data: self.test
            }).then(function (response) {
                console.log(response);
                self.points = response.data.points;
            }, function (response) {
                console.error(response);
            })
        }
    };

    self.editing = false;

    self.submit = function () {
        self.service.submit();

        for(var i = 0; i < self.test.tasks.length; i++) {
            for(var j = 0; j < self.test.tasks[i].answers.length; j++) {
                if(self.test.tasks[i].answers[j].isCorrect
                    === self.orignal.tasks[i].answers[j].isCorrect
                    && self.test.tasks[i].answers[j].isCorrect === true) {
                    self.test.tasks[i].answers[j].class = "success";

                } else if (self.test.tasks[i].answers[j].isCorrect
                    !== self.orignal.tasks[i].answers[j].isCorrect) {
                    self.test.tasks[i].answers[j].class = "error";
                }
            }
        }

    };


    self.range = function (n) {
        x = [];
        for (var i = 0; i < n; i++) {
            x.push(i);
        }
        return x;
    };

});
