$(document).ready(function () {
    $('#login').keyup(function () {
        var login = $('#login').val();
        if(login.length > 0) {
            $.ajax({
                url: 'user-check',
                type: 'GET',
                data: { login: login },
                success: function (responseText) {
                    $('#response').text(responseText);
                    $('#response').removeClass("error");
                    $('#response').addClass("valide");
                },
                error: function (responseText) {
                    $('#response').text(responseText.responseText);
                    $('#response').removeClass("valide");
                    $('#response').addClass("error");
                }
            });
        }
        else {
            $('#response').text("");
        }
    });
});