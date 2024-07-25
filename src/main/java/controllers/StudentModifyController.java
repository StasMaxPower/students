package controllers;

import Entity.Student;
import db.DBManager;
import service.DateServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StudentModifyController", urlPatterns = "/student_modify")
public class StudentModifyController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("idsForModify");
        Student student = DBManager.getStudentById(id);
        req.setAttribute("student", student);
        req.getRequestDispatcher("WEB-INF/jsp/student_modify.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String surname = req.getParameter("surname");
        String name = req.getParameter("name");
        String groupName = req.getParameter("group");
        String date = req.getParameter("date");
        String id = req.getParameter("id");

        if (surname.equals("") || name.equals("") || date.equals("") || groupName.equals("")) {
            req.setAttribute("error", 1);
            req.getRequestDispatcher("WEB-INF/jsp/student_modify.jsp").forward(req, resp);
            return;
        }
        String dateForDb = DateServices.convertDateForDB(date);
        int groupId = DBManager.getGroupId(groupName);
        DBManager.modifyStudent(id, surname, name, groupId, dateForDb);
        resp.sendRedirect("/students");
    }
}
