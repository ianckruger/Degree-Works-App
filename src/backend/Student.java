package backend;

import java.util.ArrayList;
import java.util.UUID;

public class Student extends User {

    private double gpa;
    private String year;
    private String currentMajor;
    private int earnedCreditHours;
    private int totalCurrentCredits;
    private int degreeCredits;
    private ArrayList<User> parents;
    private ArrayList<User> advisor;

    public Student(String username, String firstName, String lastName, String password, String userType, double gpa, String year, String currentMajor, int earnedCreditHours, int totalCurrentCredits, int degreeCredits, ArrayList<User> parents, ArrayList<User> advisors) {
        super(username, firstName, lastName, password, userType);
        this.gpa = gpa;
        this.year = year;
        this.currentMajor = currentMajor;
        this.earnedCreditHours = earnedCreditHours;
        this.totalCurrentCredits = totalCurrentCredits;
        this.degreeCredits = degreeCredits;
        this.parents = parents;
        this.advisor = advisors;
    }

    public Student(String username, UUID userID, String firstName, String lastName, String password, String userType, double gpa, String year, String currentMajor, int earnedCreditHours, int totalCurrentCredits, int degreeCredits, ArrayList<User> parents, ArrayList<User> advisors) {
        super(userID, username, firstName, lastName, password, userType);
        this.gpa = gpa;
        this.year = year;
        this.currentMajor = currentMajor;
        this.earnedCreditHours = earnedCreditHours;
        this.totalCurrentCredits = totalCurrentCredits;
        this.degreeCredits = degreeCredits;
        this.parents = parents;
        this.advisor = advisors;
    }
    
}