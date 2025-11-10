import java.util.ArrayList;

public class StudentManager {

    private ArrayList<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public boolean removeStudent(int id) {
        Student student = findStudent(id);
        if (student != null) {
            students.remove(student);
            return true;
        }
        return false;
    }

    public Student findStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public void listAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the system");
            return;
        }

        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i));
        }
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}
