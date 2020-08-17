$(function () {
    $('.tr-hover').on('click', function (event) {
        var login = this.children[1].id;
        var xhttp = new XMLHttpRequest();

        xhttp.onreadystatechange = function() {

            if (this.readyState == 4 && this.status == 200) {
                window.location.assign("select-user?id="+ login);
            }
        };
        
        xhttp.open("GET", "select-user?id="+ login, true);
        xhttp.send();
        return false;
    });
});