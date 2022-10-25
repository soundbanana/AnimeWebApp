<!DOCTYPE html>
<html lang="en">
<#include "base.ftl">
<head>
    <meta charset="UTF-8">
    <title>Login page</title>
</head>
<body>



<form action="login" method="post">
    Login:
    <input type="text" name="login"/>
    <br>
    Password:
    <input type="password" name="password"/>
    <br>
    <input type="submit" value="Login">
    <br>
    <label>
        <input type="checkbox" name="remember_me" checked/>
        Remember me
    </label>
    <a href="/registration.ftl">Register now</a>
</form>
</body>
</html>