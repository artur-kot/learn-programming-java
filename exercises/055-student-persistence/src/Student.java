import java.util.ArrayList;

public class Student {

    private int id;
    private String name;
    private ArrayList<Double> grades;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getGrades() {
        return grades;
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', grades=" + grades + "}";
    }
}
