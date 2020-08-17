$(function () {
    $('.btn-success').on('click', function (event) {
        var id = this.id;
        console.log(id);
        event.preventDefault();
        bootbox.dialog({
            title: 'Attention',
            message: "<p>Etes-vous sur de vouloir ajouter le compte?</p>",
            size: 'large',
            buttons: {
                cancel: {
                    label: "Annuler",
                    className: 'btn',
                    callback: function () {
                        console.log('Custom cancel clicked');
                        window.location = 'demande-compte';
                    }
                },

                ok: {
                    label: "Ok",
                    className: 'btn',
                    callback: function () {
                        var xhttp = new XMLHttpRequest();

                        xhttp.onreadystatechange = function () {
                            if (this.readyState == 4 && this.status == 200) {
                                window.location.assign("valider-compte?id=" + id);
                            }
                        };

                        xhttp.open("POST", "valider-compte?id=" + id, true);
                        xhttp.send();
                        return false;
                    }
                }
            }
        });
    });
});

$(function () {
    $('.btn-danger').on('click', function (event) {
        var id = this.id;
        console.log(id);
        event.preventDefault();
        bootbox.dialog({
            title: 'Attention',
            message: "<p>Etes-vous sur de vouloir supprimer le compte?</p>",
            size: 'large',
            buttons: {
                cancel: {
                    label: "Annuler",
                    className: 'btn',
                    callback: function () {
                        console.log('Custom cancel clicked');
                        window.location = 'demande-compte';
                    }
                },

                ok: {
                    label: "Ok",
                    className: 'btn',
                    callback: function () {
                        var xhttp = new XMLHttpRequest();
                        
                        xhttp.onreadystatechange = function () {
                            if (this.readyState == 4 && this.status == 200) {
                                window.location.assign("supprimer-compte?id=" + id);
                            }
                        };

                        xhttp.open("POST", "supprimer-compte?id=" + id, true);
                        xhttp.send();
                        return false;
                    }
                }
            }
        });
    });
});