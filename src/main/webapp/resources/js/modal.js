$(document).ready(function() {
	// bind event handlers when the page loads.
	bindButtonClick();
});

function bindButtonClick() {
	$('.trash').on('click', function(event) {
		var id = this.id;
		event.preventDefault();
		bootbox.dialog({
			title : 'Attention',
			message : "<p>Etes-vous sur de vouloir supprimer le livre?</p>",
			size : 'large',
			buttons : {
				cancel : {
					label : "Annuler",
					className : 'btn',
					callback : function() {
						window.location = 'index';
					}
				},

				ok : {
					label : "Ok",
					className : 'btn',
					callback : function() {
						deleteBook(id);
					}
				}
			}
		});
	});
}

function deleteBook(id) {
	$.ajax({
		url : 'supprimer-livre?id=' + id,
		type : 'GET',
		success : function(responseText) {
			$('#mesLivres').replaceWith($('#mesLivres', responseText));
			
			$('#paginationNav').replaceWith($('#paginationNav', responseText));

			bindButtonClick();
		},
		error : function(responseText) {
			$('#suppressionImpossible').text(responseText.responseText);
		}
	});
}