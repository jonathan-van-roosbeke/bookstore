<%--
  Created by IntelliJ IDEA.
  User: antoi
  Date: 31/07/2020
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>

<form action="login.do" method="post">
    <input type="text" name="login">
    <input type="password" name="password">
    <button>Login</button>
</form>
<input type="text" style="color: red;" readonly ${ erreurs }>
</body>
</html>
