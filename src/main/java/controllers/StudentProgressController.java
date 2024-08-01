package controllers;

import Entity.Grade;
import Entity.Student;
import Entity.Term;
import db.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentProgressController", urlPatterns = "/student_progress")
public class StudentProgressController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String studentId = req.getParameter("idForProgress");
        String termId = req.getParameter("termId");

        // 1. Получить из бд студета по его ид
        // 2. Получить из бд все активные симестры
        // 3. Получить выбранный симестр(или самый первый, если он не выбирался)
        // 4. Получить все дисциплины и оценки по ним для конкретного студента
        // 5. Полученными данными заполнить страницу

        // 1
        Student student = DBManager.getStudentById(studentId);

        //2
        List<Term> terms = DBManager.getAllActiveTerm();

        // 3
        Term selectedTerm = new Term();
        if (termId != null && !termId.isEmpty()) {
            for (Term term : terms) {
                if (termId.equals(String.valueOf(term.getId()))) {
                    selectedTerm = term;
                    break;
                }
            }
        } else {
            selectedTerm = terms.get(0);
        }


        //4
        List<Grade> grades = DBManager.getGradesByStudentAndTermId(studentId, String.valueOf(selectedTerm.getId()));

        // 5
        req.setAttribute("student", student);
        req.setAttribute("terms", terms);
        req.setAttribute("selectedTerm", selectedTerm);
        req.setAttribute("grades", grades);
        req.getRequestDispatcher("WEB-INF/jsp/student_progress.jsp").forward(req, resp);
    }
}
