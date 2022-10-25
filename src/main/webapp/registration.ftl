<!DOCTYPE html>
<html lang="en">
<#include "base.ftl">

<head>
    <meta charset="UTF-8">
    <title>Registration page</title>

</head>
<body>

<form action="registration" method="post">
    Login:
    <input type="text" name="login"/>
    <br>
    Firstname:
    <input type="text" name="firstname"/>
    <br>
    Lastname:
    <input type="text" name="lastname"/>
    <br>
    Password:
    <input type="password" name="password"/>
    <br>
    <input type="submit" value="Register">
    <br>
    <a href="/login.ftl">I already have an account</a>

</form>
</body>
</html>