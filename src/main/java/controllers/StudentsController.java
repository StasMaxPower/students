package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "StudentsController", urlPatterns = "/students")
public class StudentsController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Соединение с бд
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students?user=root&password=iamroot");
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM students.student;");

            while (result.next()){
                System.out.println(result.getInt("id") + " "
                        +result.getString("name") + " " +result.getString("surname"));
            }
            connection.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        req.getRequestDispatcher("WEB-INF/jsp/students.jsp").forward(req, resp);
    }

}
