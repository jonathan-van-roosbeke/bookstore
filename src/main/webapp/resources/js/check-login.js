$(document).ready(function () {
    $('#login').keyup(function () {
        var login = $('#login').val();
        if(login.length > 0) {
            $.ajax({
                url: 'user-check',
                type: 'POST',
                data: { login: login },
                success: function (responseText) {
                    $('#response').text(responseText);
                }
            });
        }
        else {
            $('#response').text("");
        }
    });
});