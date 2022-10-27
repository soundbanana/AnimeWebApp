package ru.kpfu.itis.chemaev.net.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "characterPageServlet", urlPatterns = "/characters")
public class CharacterPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("character-page.ftl");
//        spirited-away-characters-button
        System.out.println(req.getParameter("spirited-away-characters-button"));
    }
}
