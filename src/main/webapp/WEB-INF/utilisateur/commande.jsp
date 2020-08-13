<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mes commandes</title>

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

		<%@ include file="../include/common/menu-client.html"%>

		<div class="row">
			<div class="col-sm-12">

				<c:if test="${empty commandes}">
					<div class="jumbotron jumbotron-fluid">
						<div class="container">
							<h1 class="display-4">Vous n'avez pas encore de commandes</h1>
							<a class="btn btn-primary btn-lg" href="/bookstore/index"
								role="button">Shopping maintenant</a>
						</div>
					</div>
				</c:if>

				<c:if test="${!empty commandes}">
					<table class="table">
						<thead>
							<tr>
								<th scope="col">Numero de commande</th>
								<th scope="col">Date</th>
								<th scope="col">Status</th>
								<th scope="col">Prix total</th>
								<th scope="col"></th>
							</tr>
						</thead>

						<c:forEach items="${commandes}" var="commande">
							<tbody>
								<tr>
									<th scope="row">${commande.numeroCmd}</th>
									<td>${commande.date}</td>
									<td><c:choose>
											<c:when test="${commande.status==0 }"> En cours de préparation</c:when>
											<c:when test="${commande.status==1 }"> En cours de livraison<a
													href="#" class="btn btn-primary">Reçu</a>
											</c:when>
											<c:when test="${commande.status==2 }"> Livré</c:when>
										</c:choose></td>
									<td>${commande.totalCmd}</td>
									<td><a
										href="commande-client?method=detail&id=${commande.numeroCmd}">Voir
											la détail</a></td>
								</tr>
							</tbody>
						</c:forEach>
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