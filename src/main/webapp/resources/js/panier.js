$(function() {
		$(".delBtn").click(function() {
			var titre = $(this).parents("tr").children("td:first").text();
			if (!confirm("Etre vous sur de supprimer " + titre + " ?")) {
				return false;
			}
		});

		$(".quantite").change(function() {
			var qte =  $(this).val();
			var id = $(this).parents("tr").children(":first").text();
			location.href="PanierServlet?method=modifier&id="+id+"&qte="+qte;
		})
	});