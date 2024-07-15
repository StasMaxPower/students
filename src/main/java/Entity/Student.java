package Entity;

import java.sql.Date;

public class Student {

    private int id;
    private String name;
    private String surname;
    private Group group;
    private Date date;


    public Student() {
    }

    public Student(int id, String name, String surname, Group group, Date date) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.group = group;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
