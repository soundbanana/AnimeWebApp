package ru.kpfu.itis.chemaev.net.servlet;

import ru.kpfu.itis.chemaev.net.dao.UserDao;
import ru.kpfu.itis.chemaev.net.dao.impl.UserDaoImpl;
import ru.kpfu.itis.chemaev.net.model.User;
import ru.kpfu.itis.chemaev.net.service.UserService;
import ru.kpfu.itis.chemaev.net.service.impl.UserServiceImpl;
import ru.kpfu.itis.chemaev.net.util.PasswordUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "registrationServlet", urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {
    private final UserService userService = new UserServiceImpl();
    private final UserDao userDao = new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("registration.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String password = req.getParameter("password");

        System.out.println(login + " " + firstname + " " + lastname + " " + password);

        User existingUserWithLogin = userDao.get(login);

        if (existingUserWithLogin == null) {
            int validPassword = PasswordUtil.checkPassword(password);  // check if typed password is valid
            switch (validPassword) {
                case 0: {
                    System.out.println("Invalid password");
                    req.setAttribute("error", "Invalid password");
                    req.getRequestDispatcher("registration.ftl").forward(req, resp);
                }
                case 1: {
                    System.out.println("Weak password");
                    req.setAttribute("error", "Weak password");
                    req.getRequestDispatcher("registration.ftl").forward(req, resp);
                }
                case 2: {
                    userService.save(new User(login, firstname, lastname, password));
                    resp.sendRedirect("/login");
                    System.out.println("Successful registration");
                }
            }
        } else {
            System.out.println("This login already exists");
            req.setAttribute("error", "This login already exists");
            req.getRequestDispatcher("registration.ftl").forward(req, resp);
        }
    }
}

