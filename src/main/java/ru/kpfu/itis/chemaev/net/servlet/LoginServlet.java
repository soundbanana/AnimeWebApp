package ru.kpfu.itis.chemaev.net.servlet;

import ru.kpfu.itis.chemaev.net.dao.UserDao;
import ru.kpfu.itis.chemaev.net.dao.impl.UserDaoImpl;
import ru.kpfu.itis.chemaev.net.model.User;
import ru.kpfu.itis.chemaev.net.util.PasswordUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private final UserDao userDao = new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("login.ftl");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        String encryptPassword = PasswordUtil.encrypt(password);

        User tempUser = userDao.get(login);
        if (tempUser != null) {
            if (login.equals(tempUser.getLogin()) && tempUser.getPassword().equals(encryptPassword)) {
                HttpSession httpSession = req.getSession();
                httpSession.setAttribute("login", login);
                httpSession.setMaxInactiveInterval(60 * 60);

                Cookie httpCookie = new Cookie("username", login);
                httpCookie.setMaxAge(24 * 60 * 60);
                resp.addCookie(httpCookie);

                resp.sendRedirect("/");
            } else {
                System.out.println("Invalid login or password");
                req.setAttribute("error", "Invalid login or password");
                resp.sendRedirect("/");
            }
        } else {
            System.out.println("User with this login does not exist");
            req.setAttribute("error", "User with this login does not exist");
            req.getRequestDispatcher("login.ftl").forward(req, resp);
        }
    }
}
