<!DOCTYPE html>
<html lang="en">
<#include "base.ftl">

<head>
    <meta charset="UTF-8">
    <title>Registration page</title>

</head>
<body>

<p style="color:red"><#if error??> ${error}</#if></p>
<form action="registration" method="post">
    Login:
    <input type="text" name="login"/>
    <br><br>
    Firstname:
    <input type="text" name="firstname"/>
    <br><br>
    Lastname:
    <input type="text" name="lastname"/>
    <br><br>
    Password:
    <input type="password" name="password"/>
    <br><br>
    <p>Password requirements:<br>
        - Uppercase and lowercase letter (A-z)<br>
        - Numeric character (0-9)<br>
        - No whitespace<br>
        - At least 8 characters<br>
    </p>
    <br>
    <input type="submit" value="Register">
    <br><br>
    <a href="/login.ftl">I already have an account</a>

</form>
</body>
</html>