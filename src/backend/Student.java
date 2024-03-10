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

    public Student(String userName, String firstName, String lastName, String password, String userType) {
        super(userName, firstName, lastName, password, userType);
        this.gpa = 0;
        this.year = "";
        this.currentMajor = "";
        this.earnedCreditHours = 0;
        this.totalCurrentCredits = 0;
        this.degreeCredits = 0;
        this.parents = null;
        this.advisor = null;
        
    }
    public Student(String userName, String firstName, String lastName, String password, String userType, double gpa, String year, String currentMajor, int earnedCreditHours, int totalCurrentCredits, int degreeCredits, ArrayList<User> parents, ArrayList<User> advisors) {
        super(userName, firstName, lastName, password, userType);
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

    public double getGPA() {
        return gpa;
    }

    public int getDegreeCredits() {
        return degreeCredits;
    }

    public String getYear() {
        return year;
    }

    public String getCurrentMajor() {
        return currentMajor;
    }

    public int getEarnedCreditHours() {
        return earnedCreditHours;
    }

    public int getTotalCurrentCredits() {
        return totalCurrentCredits;
    }

    public ArrayList<User> getParents() {
        return parents;
    }

    public ArrayList<User> getAdvisors() {
        return advisor;
    }
    
}