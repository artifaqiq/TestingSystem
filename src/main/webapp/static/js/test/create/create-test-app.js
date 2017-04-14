/**
 * Created by Artur Lomako on 4/14/17.
 */

var app = angular.module('CreateTestApp', [])

app.controller('Controller', function () {
    var self = this;

    self.test = {
        name: "",
        description: "",
        strategy: "1",
        tags: [],
        tasks: [
            {
                text: "",
                points: 0,
                answers: [
                    {
                        text: "",
                        isCorrect: false

                    }
                ]
            }
        ]
    };

    self.editing = false;

    self.addAnswer = function (task) {
        task.answers.push({
            text: "",
            isCorrect: false
        })
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
    }

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
    };
});