
import java.util.ArrayList;

public class Exercise11_05 {
    public static void main(String[] args) {
        Course course = new Course("Programming Design");
    }
}

class Course {
    private String courseName;
    private ArrayList<String> students = new ArrayList<>();
    private int numberOfStudents;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void addStudent(String student) {
        students.add(student);
    }

    public ArrayList<String> getStudents() {
        return students;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public String getCourseName() {
        return courseName;
    }

    public void dropStudents(String student) {
        students.remove(student);
    }
}
