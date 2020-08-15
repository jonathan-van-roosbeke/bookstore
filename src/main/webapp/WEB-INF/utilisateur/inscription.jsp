<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.1/css/bootstrap.min.css"
        integrity="sha384-VCmXjywReHh4PwowAiWNagnWcLhlEJLA5buUprzK8rxFgeH0kww/aWY76TfkUoSX" crossorigin="anonymous">
    <link rel="stylesheet" href="./resources/css/stylesheet.css">
    <title>Inscription</title>
</head>

<body>

    <div class="container-fluid">
        <%@ include file="../include/common/menu-utilisateur.html" %>

        <div class="container-fluid">
            <div class="row">
                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 bg-image">
                </div>
                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 inscription">

                    <form action="inscription" method="POST" class="needs-validation" novalidate>
                        <div class="form-row">
                            <div class="col-md-12 mb-3">
                                <label for="nom">Nom</label>
                                <input type="text" class="form-control" id="nom" name="nom" placeholder="nom" required>
                            </div>
                            <div class="col-md-12 mb-3">
                                <label for="prenom">Prenom</label>
                                <input type="text" class="form-control" id="prenom" name="prenom" placeholder="prenom"
                                    required>
                            </div>
                            <div class="col-md-12 mb-3">
                                <label for="email">E-mail</label>
                                <input type="text" class="form-control" id="email" name="email" placeholder="email"
                                    required>
                            </div>
                            <div class="col-md-12 mb-3">
                                <label for="login">Login</label>
                                <input type="text" class="form-control" id="login" name="login" placeholder="login"
                                    required>
                                    <div id="response"></div>
                            </div>
                            <div class="col-md-12 mb-3">
                                <label for="password">Password</label>
                                <input type="text" class="form-control" id="password" name="password"
                                    placeholder="password" required>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="col-md-4 mb-3">
                                <label for="numero">N°</label>
                                <input type="text" class="form-control" id="numero" name="numero" placeholder="num"
                                    required>
                            </div>
                            <div class="col-md-8 mb-3">
                                <label for="rue">Rue</label>
                                <input type="text" class="form-control" id="rue" name="rue" placeholder="rue" required>
                            </div>
                            <div class="col-md-12 mb-3">
                                <label for="ville">Ville</label>
                                <input type="text" class="form-control" id="ville" name="ville" placeholder="ville"
                                    required>
                            </div>
                            <div class="col-md-12 mb-3">
                                <label for="cp">Code postal</label>
                                <input type="text" class="form-control" id="cp" name="cp" placeholder="cp" required>
                            </div>
                            <div class="col-md-12 mb-3">
                                <label for="cp">Pays</label>
                                <input type="text" class="form-control" id="pays" name="pays" placeholder="pays"
                                    required>
                            </div>
                        </div>

                        <button class="btn btn-primary" type="submit">Submit form</button>
                    </form>

                </div>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.js"
        integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.1/js/bootstrap.min.js"
        integrity="sha384-XEerZL0cuoUbHE4nZReLT7nx9gQrQreJekYhJD9WNWhH8nEW+0c5qq7aIo2Wl30J"
        crossorigin="anonymous"></script>
    <script src="resources/js/check-login.js"></script>
</body>

</html>