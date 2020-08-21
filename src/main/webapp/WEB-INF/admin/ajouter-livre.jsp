<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.1/css/bootstrap.min.css"
		integrity="sha384-VCmXjywReHh4PwowAiWNagnWcLhlEJLA5buUprzK8rxFgeH0kww/aWY76TfkUoSX" crossorigin="anonymous">
	<link rel="stylesheet" href="./resources/css/stylesheet.css">
	<title>Ajouter un livre</title>
</head>

<body>
	<div class="container-fluid">

		<%@ include file="../include/common/menu-admin.html"%>

		<div class="row">
			<div class="col-xl-5 col-lg-5 col-md-5 col-sm-5 left">
				<form method="POST" action="ajouter-livre" enctype="multipart/form-data">
					<div class="center_img">
						<img id="thumbnail" alt="affichage de la selection de l'image" />
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text" id="inputGroupFileAddon01">Upload</span>
							</div>
							<div class="custom-file">
								<input type="file" class="custom-file-input" id="inputGroupFile02" name="file"
									accept="image/png, image/jpeg" required>
								<label class="custom-file-label" for="inputGroupFile02">
									Choose file
								</label>
								
							</div>
							<c:choose>
							<c:when test="${not empty errorImg }">
								<div class="error">
									<h6>
										<c:out value="${errorImg}"></c:out>
									</h6>
								</div>
							</c:when>
						</c:choose>
							<div id="fichier-upload"></div>
						</div>
					</div>
						
				
					
			</div>
			<div class="col-xl-7 col-lg-7 col-md-7 col-sm-7 right">
				<div class="center_info">
					<div class="info_livre">
						<div class="input-group input-group-lg">
							<!-- --------------------------titre livre-------------------------- -->
							<div class="input-group-prepend">
								<span class="input-group-text" id="inputGroup-sizing-lg">
									Titre du Livre
								</span>
							</div>
							<input type="text" class="form-control" name="titre" placeholder="Titre livre" required>
						</div>
						<c:choose>
							<c:when test="${not empty error }">
								<div class="error">
									<h6>
										<c:out value="${error}"></c:out>
									</h6>
								</div>
							</c:when>
						</c:choose>
						<!-- --------------------------Nom Prenom Auteur-------------------------- -->
						<div class="input-group">
							<div class="input-group-prepend">
								<span class="input-group-text">Nom et Prénom auteur</span>
							</div>
							<input type="text" class="form-control" name="nom" placeholder="nom" required> <input
								type="text" class="form-control" name="prenom" placeholder="prenom" required>
						</div>

						<!-- --------------------------Synopsys-------------------------- -->
						<div class="input-group">
							<div class="input-group-prepend">
								<span class="input-group-text">Synopsis</span>
							</div>
							<textarea class="form-control" name="synopsis" required
								placeholder="Le Lorem Ipsum est simplement du faux texte employé dans la composition et la mise en page avant impression. Le Lorem Ipsum est le faux "></textarea>
						</div>

					</div>
					<div class="info_complementaire">
						<h3>Information complementaire :</h3>
						<!-- --------------------------Nombre page-------------------------- -->
						<div class="input-group input-group-sm mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text" id="inputGroup-sizing-sm">nombre
									de page du livre</span>
							</div>
							<input type="number" class="form-control" name="nombre-page" min="0" step=".1" required>
						</div>
						<!-- -------------------------Quantite-------------------------- -->
						<div class="input-group input-group-sm mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text" id="inputGroup-sizing-sm">quantitée
									restante en stock</span>
							</div>
							<input type="number" class="form-control" name="quantitee-stock" min="0" required>
						</div>
					</div>
					<div class="center_prix">
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text" id="inputGroup-sizing-default">Prix</span>
							</div>
							<input type="number" class="form-control" name="prix" min="0" step=".1" required>
						</div>
					</div>
					<div class="btn-validation">
						<input type="submit" value="Ajouter" class="btn btn-primary" />
					</div>
				</div>
				</form>
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
		<script src="resources/js/image-upload.js"></script>
		<script src="resources/js/display-img.js"></script>
</body>

</html>