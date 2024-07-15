package Entity;

import java.util.ArrayList;
import java.util.List;

public class Term {
    private int id;
    private String name;
    private String duration;
    private List<Discipline> disciplines = new ArrayList<>();

    public void addDiscipline(Discipline discipline){
        disciplines.add(discipline);
    }

    public Term() {
    }

    public Term(int id, String name, String duration) {
        this.id = id;
        this.name = name;
        this.duration = duration;
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }


}
