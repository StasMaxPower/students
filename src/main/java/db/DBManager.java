package db;

import Entity.Group;
import Entity.Student;
import service.StringService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static Constants.Constants.DB_ADRESS;
import static Constants.Constants.REMOTE_DB_ADRESS;

public class DBManager {

    private static Statement statement;
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String DATE = "date";
    private static final String GROUP = "group";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DB_ADRESS);
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Student> getAllActiveStudent() {
        List<Student> students = new ArrayList<>();
        try {
            ResultSet result = statement.executeQuery("SELECT s.id, surname, name, date, g.group " +
                    "FROM students.student as s join groupp as g on s.id_group=g.id where status='1';");
            while (result.next()) {
                Student student = new Student();
                student.setId(result.getInt(ID));
                student.setName(result.getString(NAME));
                student.setSurname(result.getString(SURNAME));
                student.setDate(result.getDate(DATE));

                Group group = new Group();
                group.setName(result.getString(GROUP));
                student.setGroup(group);

                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    public static int getGroupId(String groupName) {
        try {
            ResultSet resultSet = statement.executeQuery(String.format("SELECT id FROM students.groupp as g where g.group='%s';", groupName));

            while (resultSet.next()) {
                return resultSet.getInt(ID);
            }

            statement.execute(String.format("insert into `groupp` (`group`) values ('%s')", groupName));
            resultSet = statement.executeQuery(String.format("SELECT id FROM students.groupp as g where g.group='%s';", groupName));

            while (resultSet.next()) {
                return resultSet.getInt(ID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Ошибка создания группы");
    }

    public static void createStudent(String surname, String name, int groupId, String date) {
        try {
            statement.execute(String.format("insert into `student` (`surname`, `name`, `id_group`, `date`) values " +
                    "('%s', '%s', '%d', '%s');", surname, name, groupId, date));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteStudents(String[] ids) {
        try {
            statement.execute(String.format("UPDATE `students`.`student` SET `status` = '0' WHERE `id` in (%s);", StringService.convertIdsIntoString(ids)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Student getStudentById(String id) {
        Student student = new Student();
        try {
            ResultSet result = statement.executeQuery(String.format("SELECT s.id, surname, name, date, g.group FROM " +
                    "students.student as s join groupp as g on s.id_group=g.id where s.id='%s'", id));

            while (result.next()) {
                student.setId(result.getInt(ID));
                student.setName(result.getString(NAME));
                student.setSurname(result.getString(SURNAME));
                student.setDate(result.getDate(DATE));

                Group group = new Group();
                group.setName(result.getString(GROUP));
                student.setGroup(group);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }


    public static void modifyStudent(String id, String surname, String name, int groupId, String date) {
        try {
            statement.execute(String.format("UPDATE `students`.`student` SET " +
                    "`surname` = '%s', `name` = '%s', `id_group` = '%d', `date` = '%s' WHERE (`id` = '%s');",
                    surname, name, groupId, date, id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
