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
    <title>Lister commande</title>
</head>

<body>
    <div class="container-fluid">

        <%@ include file="../include/common/menu-admin.html"%>

        <div class="container-table">
            <h1>Demande de comptes</h1>
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">Id client</th>
                        <th scope="col">nom</th>
                        <th scope="col">prenom</th>
                        <th scope="col">date de la demande</th>
                        <th scope="col">action</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th scope="row">1</th>
                        <td>Jon</td>
                        <td>Doe</td>
                        <td>20/06/2020</td>
                        <td>
                            <input type="button" class="btn btn-success" value="Valider">
                            <input type="button" class="btn btn-danger" value="Supprimer">
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">1</th>
                        <td>Jon</td>
                        <td>Doe</td>
                        <td>20/06/2020</td>
                        <td>
                            <input type="button" class="btn btn-success" value="Valider">
                            <input type="button" class="btn btn-danger" value="Supprimer">
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">1</th>
                        <td>Jon</td>
                        <td>Doe</td>
                        <td>20/06/2020</td>
                        <td>
                            <input type="button" class="btn btn-success" value="Valider">
                            <input type="button" class="btn btn-danger" value="Supprimer">
                        </td>
                    </tr>
                </tbody>
            </table>
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