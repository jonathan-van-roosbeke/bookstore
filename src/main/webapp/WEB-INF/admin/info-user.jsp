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
    <title>Infos utilisateur</title>
</head>

<body>
    <div class="container-fluid">

        <%@ include file="../include/common/menu-admin.html"%>

        <div class="container-table">
            <h1>Infos utilisateur</h1>
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">Nom</th>
                        <th scope="col">Prenom</th>
                        <th scope="col">E-mail</th>
                        <th scope="col">Status</th>
                        <th scope="col">Création du compte</th>
                        <th scope="col">Dernnière connexion</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>${utilisateur.nom}</td>
                        <td>${utilisateur.prenom}</td>
                        <td>${utilisateur.email}</td>
                        <td>${utilisateur.statusUtilisateur}</td>
                        <td>${utilisateur.dateDemande}</td>
                        <td>${utilisateur.dateConnexion}</td>
                    </tr>
                </tbody>
            </table>

            <h1>Adresse</h1>
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">Numero</th>
                        <th scope="col">Rue</th>
                        <th scope="col">Ville</th>
                        <th scope="col">CP</th>
                        <th scope="col">Pays</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>${utilisateur.adresse.numero}</td>
                        <td>${utilisateur.adresse.rue}</td>
                        <td>${utilisateur.adresse.ville}</td>
                        <td>${utilisateur.adresse.cp}</td>
                        <td>${utilisateur.adresse.pays}</td>
                    </tr>
                </tbody>
            </table>
            <form action="tous-comptes" method="get">
                <button type="submit" class="btn btn-primary">Retour arrière</button>
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
</body>

</html>