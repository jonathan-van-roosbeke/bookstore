<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>index</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">

<link type="text/css" rel="stylesheet"
	href="./resources/css/stylesheet.css">
<body>

	<div class="container-fluid">
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
		
		<div class="row">
			
			<c:forEach items="${livres}" var="livres">
				<div class="col-sm-3 livre" id="${livres.id}">
					<div class="card" style="width: 18rem;">
						<img
							src="resources/images/img-couverture-livre/${livres.nomImage}"
							class="card-img-top" alt="${livres.nomImage}">
						<div class="card-body">
							<h5 class="card-title">${livres.titre}</h5>
							<p class="card-text">${livres.auteur.nom}
								${livres.auteur.prenom}</p>
							<h6 class="card-text">${livres.prix}€</h6>
							<a href="panier?method=ajouter&id=${livres.id}"
								class="btn btn-primary">Ajouter au panier</a>
						</div>
					</div>
				</div>
			</c:forEach>

		</div>

		<!-- Optional JavaScript -->
		<!-- jQuery first, then Popper.js, then Bootstrap JS -->
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
			integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
			crossorigin="anonymous"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
			integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
			crossorigin="anonymous"></script>
		<script
			src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
			integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
			crossorigin="anonymous"></script>
		<script src="resources/js/select-livre.js"></script>
</body>
</html>
