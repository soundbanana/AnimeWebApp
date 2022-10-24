<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Profile page</title>
</head>
<body>

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

<h3>
  <a href="/main.ftl">Main</a>
</h3>

</body>
</html>
