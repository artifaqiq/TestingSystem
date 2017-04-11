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
        if (validator.isRepassValid()) {
            $("#repass-lbl").css("color", "green");
        } else {
            $("#repass-lbl").css("color", "red");
        }
    });


    $("#repass").on('input', function () {
        if (validator.isRepassValid()) {
            $("#repass-lbl").css("color", "green");
        } else {
            $("#repass-lbl").css("color", "red");
        }
    });

    $("#first-name").on('input', function () {
        if (validator.isFirstNameValid()) {
            $("#first-name-lbl").css("color", "green");
        } else {
            $("#first-name-lbl").css("color", "red");
        }
    });

    $("#last-name").on('input', function () {
        if (validator.isLastNameValid()) {
            $("#last-name-lbl").css("color", "green");
        } else {
            $("#last-name-lbl").css("color", "red");
        }
    });

    validator.isEmailValid = function () {
        var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        return re.test($("#email").val());
    };

    validator.isRepassValid = function () {
        return ($("#repass").val() == $("#pass").val());
    };


    validator.isPasswordValid = false;
    validator.isPassVaild = function () {
        $("#pass").complexify({}, function (valid, complexity) {
            validator.isPasswordValid = (complexity > 20);
        });

        return validator.isPasswordValid;
    };

    validator.isFirstNameValid = function () {
        return ($("#first-name").val() != "");
    };

    validator.isLastNameValid = function () {
        return ($("#last-name").val() != "");
    };

    validator.isButtonAvailable = function () {

        return validator.isLastNameValid()
            && validator.isFirstNameValid()
            && validator.isEmailValid()
            && validator.isPassVaild()
            && validator.isRepassValid()


    }

});