<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>index</title>

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
		integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

	<link type="text/css" rel="stylesheet" href="./resources/css/stylesheet.css">

<body>
	<div class="container-fluid">

		<!-- On choisit le menu en fonction de l'utilisateur -->

		<c:choose>
			<c:when test="${utilisateur.statusUtilisateur == 1}">
				<%@ include file="../include/common/menu-client.html"%>
			</c:when>
			<c:when test="${utilisateur.statusUtilisateur == 2}">
				<%@ include file="../include/common/menu-admin.html"%>
			</c:when>
			<c:otherwise>
				<%@ include file="../include/common/menu-utilisateur.html"%>
			</c:otherwise>
		</c:choose>

		<!-- On affiche le nom de l'utilisateur si il est connecté -->

		<c:choose>
			<c:when test="${empty utilisateur}">
				<div class="user">
					<h3>Bonjour</h3>
				</div>
			</c:when>
			<c:otherwise>
				<div class="user">
					<h3>Bonjour ${utilisateur.prenom }</h3>
				</div>
			</c:otherwise>
		</c:choose>

		<!-- On ajoute le bouton "ajouter livre" si l'utilisateur est l'admin -->

		<c:choose>
			<c:when test="${utilisateur.statusUtilisateur == 2}">
				<div class="container ajout-livre">
					<a href="ajouter-livre" class="btn btn-primary">Ajouter un livre</a>
				</div>
			</c:when>
		</c:choose>

		<div class="row">
			<c:forEach items="${livres}" var="livres">
				<div class="col-sm-3 livre" name="id-livre" value="${livres.id}">
					<div class="card" style="width: 18rem;">
						<img src="resources/images/img-couverture-livre/${livres.nomImage}" class="card-img-top"
							alt="${livres.nomImage}">
						<div class="card-body">
							<h5 class="card-title">${livres.titre}</h5>
							<p class="card-text">${livres.auteur.nom}
								${livres.auteur.prenom}</p>
							<h6 class="card-text">${livres.prix}€</h6>

							<!-- Si admin = editer, si non ajouter livre -->

							<c:choose>
								<c:when test="${utilisateur.statusUtilisateur == 2}">
									<div class="action">
										<a href="editer-livre?id=${livres.id}" class="btn btn-primary">Editer</a>
										<!-- icone supprimer -->
										<a id="${livres.id}" href="#" class="trash">
											<svg width="1.5em" height="1.5em" viewBox="0 0 16 16" class="bi bi-trash"
												fill="#65B3C5" xmlns="http://www.w3.org/2000/svg"
												transform='translate(10 0)'>
												<path
													d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z" />
												<path fill-rule="evenodd"
													d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z" />
											</svg>
										</a>
									</div>
								</c:when>
								<c:otherwise>
									<a href="panier?method=ajouter&id=${livres.id}" class="btn btn-primary">Ajouter au
										panier</a>
								</c:otherwise>
							</c:choose>

						</div>
					</div>
				</div>
			</c:forEach>
		</div>

		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
			integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
			crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
			integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
			crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
			integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
			crossorigin="anonymous"></script>

		<c:choose>
			<c:when test="${utilisateur.statusUtilisateur != 2}">
				<script src="resources/js/select-livre.js"></script>
			</c:when>

			<c:when test="${utilisateur.statusUtilisateur == 2}">
				<script src="https://cdnjs.cloudflare.com/ajax/libs/bootbox.js/5.4.0/bootbox.js"></script>
				<script src="resources/js/modal.js"></script>
			</c:when>

		</c:choose>
</body>

</html>