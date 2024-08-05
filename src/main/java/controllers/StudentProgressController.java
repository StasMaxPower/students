package controllers;

import Entity.Discipline;
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

        // 1. �������� �� �� ������� �� ��� ��
        // 2. �������� �� �� ��� �������� ��������
        // 3. �������� ��������� �������(��� ����� ������, ���� �� �� ���������)
        // 4. �������� ��� ���������� � ������ �� ��� ��� ����������� ��������
        // 5. ����������� ������� ��������� ��������

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
        if (grades.isEmpty()) {
            List<Discipline> disciplines = DBManager.getDisciplinesByTermId(String.valueOf(selectedTerm.getId()));
            for (Discipline discipline : disciplines) {
                Grade grade = new Grade();
                grade.setDiscipline(discipline);
                grade.setValue(-1);
                grades.add(grade);
            }
        }

        // 5
        req.setAttribute("avgGrade", getAverageRate(grades));
        req.setAttribute("student", student);
        req.setAttribute("terms", terms);
        req.setAttribute("selectedTerm", selectedTerm);
        req.setAttribute("grades", grades);
        req.getRequestDispatcher("WEB-INF/jsp/student_progress.jsp").forward(req, resp);
    }

    private double getAverageRate(List<Grade> grades) {
        int sum = 0;
        for (Grade grade : grades) {
            sum += grade.getValue();
        }
        double result = sum / (double) grades.size();
        if (result == -1) {
            return 0;
        }
        return result;
    }
}
