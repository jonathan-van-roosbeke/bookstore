<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.1/css/bootstrap.min.css"
	integrity="sha384-VCmXjywReHh4PwowAiWNagnWcLhlEJLA5buUprzK8rxFgeH0kww/aWY76TfkUoSX"
	crossorigin="anonymous">
<link rel="stylesheet" href="./resources/css/stylesheet.css">
<title>Lister commande</title>
</head>

<body>
	<div class="container-fluid">

		<%@ include file="../include/common/menu-admin.html"%>

		<div class="row">
			<div class="col-sm-12">

				<c:if test="${empty commandes}">
					<div class="jumbotron jumbotron-fluid">
						<div class="container">
							<h1 class="display-4">Il n'y a pas encore de commandes</h1>
							<a class="btn btn-primary btn-lg" href="/bookstore/index"
								role="button">Retour</a>
						</div>
					</div>
				</c:if>

				<c:if test="${!empty commandes}">
					<table class="table">
						<br>
						<h1>Tous les commandes</h1>
						<thead class="thead-dark">
							<tr>
								<th scope="col">Numéro de commande</th>
								<th scope="col">Date</th>
								<th scope="col">Status</th>
								<th scope="col">Prix total</th>
								<th scope="col">Détail</th>
								<th scope="col">Action</th>
							</tr>
						</thead>

						<c:forEach items="${commandes}" var="commande">
							<tbody>
								<tr>
									<th scope="row">${commande.numeroCmd}</th>
									<td>${commande.date}</td>
									<td><c:choose>
											<c:when test="${commande.status==0 }"> En cours de préparation</c:when>
											<c:when test="${commande.status==1 }"> En cours de livraison</c:when>
											<c:when test="${commande.status==2 }"> Livré</c:when>
											<c:when test="${commande.status==3 }"> Annulé</c:when>
										</c:choose></td>
									<td>${commande.totalCmd}</td>
									<td><a
										href="commande-admin?method=detail&id=${commande.numeroCmd}">Voir
											la détail</a></td>
									<td><c:choose>
											<c:when test="${commande.status==0 }">
												<a
													href="commande-admin?method=updateStatus&numeroCmd=${commande.numeroCmd}">Envoyer
													la commande</a>
											</c:when>
											<c:when test="${commande.status==1 }"> Attendre la confirmation de client</c:when>
											<c:when test="${commande.status==2 || commande.status==3}"> Terminer</c:when>

										</c:choose></td>
								</tr>
							</tbody>
						</c:forEach>
					</table>
					<div><%@ include file="../include/common/pagination.jsp"%></div>
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