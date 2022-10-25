<!DOCTYPE html>
<html lang="en">
<#include "base.ftl">

<head>
    <meta charset="UTF-8">
    <title>Profile page</title>
</head>

<body>
<div class="content">
    <div class="content"><@content><h2></h2></@content></div>
</div>

<#macro content>
    <div class="infoOfUser">
        Login: ${user.login}<br>
        Firstname: ${user.firstname}<br>
        Lastname: ${user.lastname}<br>
    </div>
    <a href="/logout">Logout</a>
</#macro>
</body>
</html>