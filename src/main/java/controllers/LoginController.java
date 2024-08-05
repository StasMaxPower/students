package controllers;

import Entity.Role;
import db.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginController", urlPatterns = "/login")
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Role> allRoles = DBManager.getAllRoles();
        req.setAttribute("roles", allRoles);
        req.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String roleId = req.getParameter("roleId");

        if (DBManager.isAuthorised(login, password, roleId)) {
            req.getSession().setAttribute("isAuthorised", "true");
            req.getSession().setAttribute("role", roleId);
            req.getSession().setAttribute("login", login);
            resp.sendRedirect("/");
        } else {
            req.setAttribute("error", 1);
            List<Role> roles = DBManager.getAllRoles();
            req.setAttribute("roles", roles);
            req.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(req, resp);
        }

    }
}
