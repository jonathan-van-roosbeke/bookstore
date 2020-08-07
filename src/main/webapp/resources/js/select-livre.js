$(function(){
    $('.livre').click(function() {
        var id = this.id;
        console.log(id);

        // location.href='SelectionLivreServlet?id='+id;

        var xhttp = new XMLHttpRequest();

        xhttp.onreadystatechange = function() {

            if (this.readyState == 4 && this.status == 200) {
                window.location.assign("SelectionLivreServlet?id="+ id);
            }
        };
        xhttp.open("GET", "SelectionLivreServlet?id="+ id, true);
        xhttp.send();
        return false;
    });
});