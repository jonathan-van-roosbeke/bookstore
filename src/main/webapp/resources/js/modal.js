$(function () {
    $('.trash').on('click', function (event) {
        var id = this.id;
        console.log(id);
        event.preventDefault();
        bootbox.dialog({
            title: 'Attention',
            message: "<p>Etes-vous sur de vouloir supprimer le livre?</p>",
            size: 'large',
            buttons: {
                cancel: {
                    label: "Annuler",
                    className: 'btn',
                    callback: function(){
                        console.log('Custom cancel clicked');
                        window.location = 'index';
                    }
                },
                
                ok: {
                    label: "Ok",
                    className: 'btn',
                    callback: function(){
                        console.log('Custom OK clicked');
                        window.location = 'supprimer-livre?id=' + id;
                    }
                }
            }
        });
    });
});


