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
    <title>Edit livre</title>
</head>

<body>
    <div class="container-fluid">

        <%@ include file="../include/common/menu-admin.html"%>

        <div class="row">
            <div class="col-xl-5 col-lg-5 col-md-5 col-sm-5 left">
                <div class="center_img">
                    <img src="./resources/images/img-couverture-livre/${livre.nomImage}" alt="couverture de livre">
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text" id="inputGroupFileAddon01">Upload</span>
                        </div>
                        <div class="custom-file">
                            <input type="file" class="custom-file-input" id="inputGroupFile01">
                            <label class="custom-file-label" for="inputGroupFile01">Mettre à jour votre image</label>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xl-7 col-lg-7 col-md-7 col-sm-7 right">
                <div class="center_info">
                    <div class="info_livre">
                        <div class="input-group input-group-lg">
                            <!-- --------------------------titre livre-------------------------- -->
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="inputGroup-sizing-lg">Titre du Livre</span>
                            </div>
                            <input type="text" class="form-control" placeholder="${livre.titre}">
                        </div>

                        <!-- --------------------------Nom Prenom Auteur-------------------------- -->
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text">Nom et Prénom auteur</span>
                            </div>
                            <input type="text" class="form-control" placeholder="${livre.auteur.nom}">
                            <input type="text" class="form-control" placeholder="${livre.auteur.prenom}">
                        </div>

                        <!-- --------------------------Synopsys-------------------------- -->
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text">Synopsis</span>
                            </div>
                            <textarea class="form-control" placeholder="${livre.synopsis}"></textarea>
                        </div>

                    </div>
                    <div class="info_complementaire">
                        <h3>Information complementaire :</h3>
                        <!-- --------------------------Nombre page-------------------------- -->
                        <div class="input-group input-group-sm mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="inputGroup-sizing-sm">nombre de page du livre</span>
                            </div>
                            <input type="number" class="form-control" placeholder="${livre.nombrePage}">
                        </div>
                        <!-- -------------------------Quantite-------------------------- -->
                        <div class="input-group input-group-sm mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="inputGroup-sizing-sm">quantitée restante en
                                    stock</span>
                            </div>
                            <input type="number" class="form-control" placeholder="${livre.quantiteStock}">
                        </div>
                    </div>
                    <div class="center_prix">
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="inputGroup-sizing-default">Prix</span>
                            </div>
                            <input type="number" class="form-control" placeholder="${livre.prix}">
                        </div>
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