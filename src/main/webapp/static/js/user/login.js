/**
 * Created by Artur Lomako on 3/28/17.
 */

$(function () {

    var validator = {};

    $('*').on('input change', function () {
        if (validator.isButtonAvailable()) {
            $("#reg-spn").css("color", "#279BE4");
            $("#reg-btn").css("border-color", "#279BE4");
        } else {
            $("#reg-spn").css("color", "rgba(0, 0, 0, 0.2)");
            $("#reg-btn").css("border-color", "rgba(0, 0, 0, 0.2)");
        }
    });

    $("#email").on('input', function () {
        if (validator.isEmailValid()) {
            $("#email-lbl").css("color", "green");
        } else {
            $("#email-lbl").css("color", "red");
        }
    });

    $("#pass").on('input', function () {
        if (validator.isPassVaild()) {
            $("#pass-lbl").css("color", "green");
        } else {
            $("#pass-lbl").css("color", "red");
        }
    });

    $("#log-btn").click(function (event) {
        if (validator.isButtonAvailable()) {
            $("#form").submit();
        }
    })


    validator.isEmailValid = function () {
        var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        return re.test($("#email").val());
    };

    validator.isPassVaild = function () {
        return $("#pass").val() != "";
    };


    validator.isButtonAvailable = function () {
        return validator.isEmailValid()
            && validator.isPassVaild()
    }

});