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
                    <form action="login" method="post">
                        <h1>Login</h1>
                        <input type="text" id="login" class="form-control" name="login" placeholder="login" required
                            autofocus>
                        <br />
                        <input type="password" class="form-control" name="password" placeholder="password" required>
                        <button type="submit" class="btn btn-primary">Login</button>

                        <c:choose>
                            <c:when test="${error}">
                                <div class="error">
                                    <h6>une erreur s'est produite</h6>
                                </div>
                            </c:when>
                            <c:when test="${en_attente}">
                                <div class="error">
                                    <h6>Compte en attente de validation</h6>
                                </div>
                            </c:when>
                        </c:choose>

                    </form>
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