<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Datail d'une commande</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link rel="stylesheet" href="./resources/css/stylesheet.css">

<script src="https://code.jquery.com/jquery-3.5.1.min.js"
	integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
	crossorigin="anonymous"></script>
<script type="text/javascript" src="resources/js/panier.js"></script>

</head>
<body>
	<div class="container-fluid">

		<%@ include file="../include/common/menu-admin.html"%>

		<div class="row">
			<div class="col-sm-12">


				<table class="table">
					<thead>
						<tr>
							<th scope="col" rowspan="5">Numero de commande : ${numeroCmd}</th>
							<th scope="col"></th>
							<th scope="col"></th>
							<th scope="col"></th>
							<th scope="col"></th>
						</tr>
					</thead>

					<thead>
						<tr>
							<th scope="col">No.</th>
							<th scope="col">Nom</th>
							<th scope="col">Quantité</th>
							<th scope="col">Prix unité</th>
							<th scope="col">Prix total</th>
						</tr>
					</thead>

					<c:forEach items="${detailCmd}" var="article">
						<tbody>
							<tr>
								<th scope="row">${article.id}</th>
								<td>${article.titre}</td>
								<td>${article.quantite}</td>
								<td>${article.prix}</td>
								<td>${article.totalPrix}</td>
							</tr>
						</tbody>
					</c:forEach>
					
					<tbody>
							<tr>
								<th scope="row"></th>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td><a href="commande-admin?method=afficherAll"
									class="btn btn-primary">Retour</a></td>
								<td></td>
							</tr>
						</tbody>
					
				</table>
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.1/js/bootstrap.min.js"
		integrity="sha384-XEerZL0cuoUbHE4nZReLT7nx9gQrQreJekYhJD9WNWhH8nEW+0c5qq7aIo2Wl30J"
		crossorigin="anonymous"></script>
</body>
</html>