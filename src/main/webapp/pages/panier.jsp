<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Panier</title>

<link type="text/css" rel="stylesheet" href="static/style.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">

</head>
<body>
	<div class="container-fluid">

		<div class="row">

			<div class="col-sm-12">
				<nav class="navbar navbar-expand-lg navbar-light bg-light">
					<a class="navbar-brand">Bienvenu !</a>
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>

					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav mr-auto">
							<li class="nav-item active"><a class="nav-link"
								href="/bookstore/ListLivreServlet">Home <span
									class="sr-only">(current)</span>
							</a></li>
							<li class="nav-item"><a class="nav-link" href="#">S'identifier</a></li>
							<li class="nav-item"><a class="nav-link" href="#">S'inscrire</a></li>
							<li class="nav-item"><a class="nav-link"
								href="/bookstore/pages/panier.jsp">Panier</a></li>

						</ul>
						<form class="form-inline my-2 my-lg-0">
							<input class="form-control mr-sm-2" type="search"
								placeholder="Search" aria-label="Search">
							<button class="btn btn-outline-success my-2 my-sm-0"
								type="submit">Search</button>
						</form>
					</div>
				</nav>
			</div>
		</div>

		<div class="row">
			<div class="col-sm-12">

				<c:if test="${empty panier.all}">
					<div class="jumbotron jumbotron-fluid">
						<div class="container">
							<h1 class="display-4">Votre panier est vide</h1>
							<a class="btn btn-primary btn-lg" href="/bookstore/ListLivreServlet" role="button">Shopping maintenant</a>
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
								<th scope="col"></th>
							</tr>
						</thead>

						<c:forEach items="${panier.all}" var="article">
							<tbody>
								<tr>
									<th scope="row">${article.livre.id}</th>
									<td>${article.livre.titre}</td>
									<td>${article.quantite}</td>
									<td>${article.livre.prix}</td>
									<td>${article.total}</td>
									<td><a href="#" class="btn btn-primary">Modifier</a></td>
									<td><a href="#" class="btn btn-primary">Supprimer</a></td>
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
								<td><a href="#" class="btn btn-primary">Passer la
										commande</a></td>
								<td></td>
							</tr>
						</tbody>



					</table>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>