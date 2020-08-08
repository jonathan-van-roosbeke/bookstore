$(function(){
    $('.livre').click(function() {
        var id = this.id;
        var xhttp = new XMLHttpRequest();

        xhttp.onreadystatechange = function() {

            if (this.readyState == 4 && this.status == 200) {
                window.location.assign("select?id="+ id);
            }
        };
        
        xhttp.open("GET", "select?id="+ id, true);
        xhttp.send();
        return false;
    });
});