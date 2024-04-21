package backend;

import java.util.ArrayList;
import java.util.UUID;

public class Advisor extends User {
    private ArrayList<String> students;
    private ArrayList<Student> student;
    private User advising;

 
    public Advisor(String userName, String firstName, String lastName, String password, String userType) {
        super(userName, firstName, lastName, password, userType);
        this.students = new ArrayList<String>();
        this.student = new ArrayList<Student>();
        this.advising = null;
 

    }
    public Advisor(String userName, String firstName, String lastName, String password, String userType, ArrayList<String> students, User advising) {
        super(userName,firstName, lastName, password, userType);
        this.student = new ArrayList<Student>();
        this.advising = advising;
        this.students = students;
    }

    public Advisor(String username, UUID userID, String firstName, String lastName, String password, String userType, ArrayList<String> students) {
        super(userID, username, firstName, lastName, password, userType);
        this.students = students;
        this.student = new ArrayList<Student>();
    }

    public User getAdvising() {
        return advising;
    }

    public ArrayList<String> getStudents() {
        return students;
    }

    public ArrayList<Student> getStudent() {
        return student;
    }

    public void addStudent(String studentId) {
        students.add(studentId);
    }

    public Student getStudentById(String studentId) {
        // Iterate over the list of student IDs
        for (int i = 0; i < students.size(); i++) {
            // Check if the current student ID matches the ID being searched for
            if (students.get(i).equals(studentId)) {
                // If a match is found, return the corresponding Student object
                return student.get(i);
            }
        }
        // If no match is found, return null
        return null;
    }
}
