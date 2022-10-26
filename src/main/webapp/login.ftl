<!DOCTYPE html>
<html lang="en">
<#include "base.ftl">
<head>
    <meta charset="UTF-8">
    <title>Login page</title>
</head>
<body>


<p style="color:red"><#if error??> ${error}</#if></p>
<form action="login" method="post">
    Login:
    <input type="text" name="login"/>
    <br><br>
    Password:
    <input type="password" name="password"/>
    <br><br>
    <input type="submit" value="Login">
    <br><br>
    <label>
        <input type="checkbox" name="remember_me" checked/>
        Remember me
    </label>
    <a href="/registration.ftl">Register now</a>
</form>
</body>
</html>