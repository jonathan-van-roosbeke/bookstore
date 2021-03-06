<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Panier</title>

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

		<c:choose>
			<c:when test="${utilisateur.statusUtilisateur == 1}">
				<%@ include file="../include/common/menu-client.html"%>
			</c:when>
			<c:otherwise>
				<%@ include file="../include/common/menu-utilisateur.html"%>
			</c:otherwise>
		</c:choose>

		<div class="row">
			<div class="col-sm-12">

				<c:if test="${empty panier.all}">
					<div class="jumbotron jumbotron-fluid">
						<div class="container">
							<h1 class="display-4">Votre panier est vide</h1>
							<a class="btn btn-primary btn-lg" href="/bookstore/index" role="button">Shopping
								maintenant</a>
						</div>
					</div>
				</c:if>

				<c:if test="${!empty panier.all}">
					<table class="table">
						<thead>
							<tr>
								<th scope="col">Ref</th>
								<th scope="col">Nom</th>
								<th scope="col">Quantité</th>
								<th scope="col">Prix unité</th>
								<th scope="col">Prix total</th>
								<th scope="col"></th>
							</tr>
						</thead>

						<c:forEach items="${panier.all}" var="article">
							<tbody>
								<tr>
									<th scope="row">${article.livre.id}</th>
									<td>${article.livre.titre}</td>
									<td><input class="quantite" type="number" min="1"
										name="quantite" value="${article.quantite}" /></td>
									<td>${article.livre.prix}</td>
									<td>${article.total}</td>
									<td><a class="delBtn"
										href="panier?method=supprimer&id=${article.livre.id}"
										class="btn btn-primary">Supprimer</a></td>
								</tr>
							</tbody>
						</c:forEach>

						<tbody>
							<tr>
								<th scope="row"></th>
								<td></td>
								<td>${panier.totalQuantite}</td>
								<td></td>
								<td>${panier.totalPrix}€</td>
								<td><a href="/bookstore/commande-client?method=checkout"
									class="btn btn-primary">Passer la commande</a></td>
								<td></td>
							</tr>
						</tbody>
					</table>
				</c:if>
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