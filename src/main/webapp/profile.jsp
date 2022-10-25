<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Profile page</title>
  <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

  <!-- jQuery library -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

  <!-- Latest compiled JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>

<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">AnimeWebApp</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="/main.ftl">Main</a></li>
      <li><a href="#">Characters</a></li>
      <li class="active"><a href="/profile.jsp">Profile</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="/registration.ftl"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="/login.ftl"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>


<%
  String user = null;
  String sessionUser = (String) session.getAttribute("login");

  if (sessionUser == null) {
    response.sendRedirect("login.ftl");
  } else {
    user = sessionUser;
  }

  String cookieUser = null;
  String sessionId = null;

  Cookie[] cookies = request.getCookies();
  if (cookies != null) {
    for (Cookie cookie : cookies) {
      if ("login".equals(cookie.getName())) {
        cookieUser = cookie.getValue();
      }
      if ("JSESSIONID".equals(cookie.getName())) {
        sessionId = cookie.getValue();
      }
    }
  } else {
    sessionId = session.getId();
  }
%>

<h2>
  Hello, <%=user%>! Login successful!
  <br>
  Session ID = <%=sessionId%>
  <br>
  Cookie username = <%=cookieUser%>
</h2>

</body>
</html>
