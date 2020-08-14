$(function () {
    $('.btn-success').on('click', function (event) {
        var id = this.id;
        console.log(id);
        var xhttp = new XMLHttpRequest();

        xhttp.onreadystatechange = function() {

            if (this.readyState == 4 && this.status == 200) {
                window.location.assign("valider-compte?id="+ id);
            }
        };
        
        xhttp.open("POST", "valider-compte?id="+ id, true);
        xhttp.send();
        return false;
    });
});

$(function () {
    $('.btn-danger').on('click', function (event) {
        var id = this.id;
        console.log(id);
        var xhttp = new XMLHttpRequest();

        xhttp.onreadystatechange = function() {

            if (this.readyState == 4 && this.status == 200) {
                window.location.assign("supprimer-compte?id="+ id);
            }
        };
        
        xhttp.open("POST", "supprimer-compte?id="+ id, true);
        xhttp.send();
        return false;
    });
});