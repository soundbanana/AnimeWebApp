package ru.kpfu.itis.chemaev.net.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "logout", urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookie = req.getCookies();
        if (cookie != null) {
            for (Cookie c : cookie) {
                c.setMaxAge(0);
                resp.addCookie(c);
            }
        }

        HttpSession httpSession = req.getSession(false);

        if (httpSession != null) httpSession.invalidate();

        resp.sendRedirect("/login");
    }
}
