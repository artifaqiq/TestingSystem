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

    self.saveButtonClass = "btn-success";

    $http({
        method: 'GET',
        url: '/Controller?command=read_test&id=' + self.testId
    }).then(function (response) {
        self.test = response.data;
    }, function (response) {
    });

    self.service = {
        update: function () {
            $http({
                method: 'POST',
                url: '/Controller?command=update_test&id=' + self.testId,
                data: self.test
            }).then(function (response) {
                self.saveButtonClass = "btn-success";
            }, function (response) {
                console.error(response);
            })
        }
    };

    self.change = function () {
        self.saveButtonClass = "btn-warning";
    };

    self.editing = false;

    self.save = function() {
        self.service.update();
    };

    self.addTag = function () {

        self.test.tags.push({
            id: 0,
            text: ""
        });
        self.saveButtonClass = "btn-warning";
    };

    self.addAnswer = function (task) {
        task.answers.push({
            title: "",
            isCorrect: false
        })
        self.saveButtonClass = "btn-warning";
    };

    self.addTask = function () {
        self.test.tasks.push({
            text: "",
            points: 0,
            answers: [
                {
                    text: "",
                    isCorrect: false

                }
            ]
        })
        self.saveButtonClass = "btn-warning";
    };

    self.range = function (n) {
        x = [];
        for (var i = 0; i < n; i++) {
            x.push(i);
        }
        return x;
    };
    self.remove = function (array, object) {
        var index = array.indexOf(object);
        if (index !== -1) {
            array.splice(index, 1);
        }
        self.saveButtonClass = "btn-warning";
    };
});
