package Entity;

public class Grade {

    private int id;
    private int value;
    private Student student;
    private Term term;
    private Discipline discipline;

    public Grade(int id, int value, Student student, Term term, Discipline discipline) {
        this.id = id;
        this.value = value;
        this.student = student;
        this.term = term;
        this.discipline = discipline;
    }

    public Grade() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }
}
