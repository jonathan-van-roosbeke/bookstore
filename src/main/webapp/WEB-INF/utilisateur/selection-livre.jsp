<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.1/css/bootstrap.min.css"
		integrity="sha384-VCmXjywReHh4PwowAiWNagnWcLhlEJLA5buUprzK8rxFgeH0kww/aWY76TfkUoSX" crossorigin="anonymous">
	<link rel="stylesheet" href="./resources/css/stylesheet.css">
	<title>Livre</title>
</head>

<body>

	<div class="container-fluid">
		<c:choose>
			<c:when test="${utilisateur.statusUtilisateur == 1}">
				<%@ include file="../include/common/menu-admin.html"%>
			</c:when>
			<c:when test="${utilisateur.statusUtilisateur == 2}">
				<%@ include file="../include/common/menu-admin.html"%>
			</c:when>
			<c:otherwise>
				<%@ include file="../include/common/menu-utilisateur.html"%>
			</c:otherwise>
		</c:choose>

		<div class="row">
			<div class="col-xl-5 col-lg-5 col-md-5 col-sm-5 left">
				<div class="center_img">
					<img src="./resources/images/img-couverture-livre/${livre.nomImage}" alt="couverture de livre"> <a
						href="panier?method=ajouter&id=${livre.id}" class="btn btn-primary">Ajouter au panier</a>
				</div>
			</div>
			<div class="col-xl-7 col-lg-7 col-md-7 col-sm-7 right">
				<div class="center_info">
					<div class="info_livre">
						<h1>${livre.titre}</h1>
						auteur : <h6>${livre.auteur.nom} ${livre.auteur.prenom }</h6>
						<p>
							${livre.synopsis}
						</p>
					</div>
					<div class="info_complementaire">
						<h3>Information complementaire :</h3>
						<h6>nombre de pages : ${livre.nombrePage}</h6>
						<h6>quantit&eacute;e restante en stock : ${livre.quantiteStock}</h6>
					</div>
					<div class="center_prix">
						<h6>prix:</h6>
						<h1>${livre.prix} euros</h1>
					</div>
				</div>
			</div>
		</div>

		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
			integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
			crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
			integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
			crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.1/js/bootstrap.min.js"
			integrity="sha384-XEerZL0cuoUbHE4nZReLT7nx9gQrQreJekYhJD9WNWhH8nEW+0c5qq7aIo2Wl30J"
			crossorigin="anonymous"></script>
</body>

</html>