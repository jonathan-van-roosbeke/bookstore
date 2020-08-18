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
    <title>Tous les comptes</title>
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
                        <th scope="col">login</th>
                        <th scope="col">nom</th>
                        <th scope="col">prenom</th>
                        <th scope="col">date de la dernniere connexion</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${page.content}" var="utilisateur">
                        <tr class="tr-hover" data-toggle="tooltip" data-placement="bottom" title="Date de la demande du compte : ${utilisateur.dateDemande}">
                            <th scope="row">${utilisateur.id}</th>
                            <td id="${utilisateur.login}">${utilisateur.login}</td>
                            <td>${utilisateur.prenom}</td>
                            <td>${utilisateur.nom}</td>
                            <td>${utilisateur.ts}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div><%@ include file="../include/common/pagination.jsp"%></div>
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
        <script src="resources/js/tooltip.js"></script>
        <script src="resources/js/select-user.js"></script>
</body>

</html>