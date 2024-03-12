package backend;

import java.util.ArrayList;
import java.util.UUID;

public class Class {
    private String courseSubjectCode;
    private String courseNumber;
    private String courseTitle;
    // courseID and classID same? check UML diagram
    private UUID courseID; 
    private int credits;
    private String applicationArea;
    private ArrayList<Class> prerequisites;
    // private boolean isCarolinaCore;
    // private boolean isFoundational;
    // private boolean isLibElective;
    // private boolean isElective;
    // private boolean isMajorCourse;
    // private boolean isBIM;
    // private boolean isLabScience;
    private String courseDescription;

    private int yearTaken;
    private String semesterTaken;

    // private boolean completed;
    // private boolean inProgress;
    // private boolean transferred;
    private double grade;

    public Class(String courseSubjectCode, String courseNumber, String courseTitle, UUID courseID, int credits, String applicationArea,
    ArrayList<Class> prequisites, boolean isCarolinaCore, boolean isFoundational, boolean isLibElective, boolean isElective, boolean isMajorCourse, boolean isBIM, boolean isLabScience, String courseDescription) {
        
        setCourseSubjectCode(courseSubjectCode);
        setCourseNumber(courseNumber);
        setCourseTitle(courseTitle);
        setCourseID(courseID);
        setApplicationArea(applicationArea);
        setCredits(credits);
        setCouresDescription(courseDescription);

    }

    public Class(String courseSubjectCode, String courseNumber, String courseTitle, UUID courseID, int credits, String applicationArea,
    ArrayList<Class> prequisites, boolean isCarolinaCore, boolean isFoundational, boolean isLibElective, boolean isElective, boolean isMajorCourse, boolean isBIM, boolean isLabScience, String courseDescription,
    int yearTaken, String semesterTaken) {

        setCourseSubjectCode(courseSubjectCode);
        setCourseNumber(courseNumber);
        setCourseTitle(courseTitle);
        setCourseID(courseID);
        setApplicationArea(applicationArea);
        setCredits(credits);
        setCouresDescription(courseDescription);
        setYearTaken(yearTaken);
        setSemesterTaken(semesterTaken);
    
    }
    public Class(String courseSubjectCode, String courseNumber, String courseTitle, UUID courseID, int credits, String applicationArea,
    ArrayList<Class> prequisites, boolean isCarolinaCore, boolean isFoundational, boolean isLibElective, boolean isElective, boolean isMajorCourse, boolean isBIM, boolean isLabScience, String courseDescription,
    int yearTaken, String semesterTaken, boolean completed, boolean inProgress, boolean transferred, double grade) {
        setCourseSubjectCode(courseSubjectCode);
        setCourseNumber(courseNumber);
        setCourseTitle(courseTitle);
        setCourseID(courseID);
        setApplicationArea(applicationArea);
        setCredits(credits);
        setCouresDescription(courseDescription);
        setYearTaken(yearTaken);
        setSemesterTaken(semesterTaken);
        setGrade(grade);
     }

    public String getCourseSubjectCode() {
        return courseSubjectCode;
    }

    public void setCourseSubjectCode(String courseSubjectCode) {
        this.courseSubjectCode = courseSubjectCode;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public UUID getCourseID() {
        return courseID;
    }

    public void setCourseID(UUID courseID) {
        this.courseID = courseID;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getCourseDesciption() {
        return courseDescription;
    }

    public void setCouresDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public int getYearTaken() {
        return yearTaken;
    }

    public void setYearTaken(int yearTaken) {
        this.yearTaken = yearTaken;
    }

    public String getSemesterTaken() {
        return semesterTaken;
    }

    public void setSemesterTaken(String semesterTaken) {
        this.semesterTaken = semesterTaken;
    }

    public String getApplicationArea() {
        return applicationArea;
    }
    public void setApplicationArea(String applicationArea) {
        this.applicationArea = applicationArea;
    }

    public double getGrade() {
        return grade;
    }
    public void setGrade(double grade) {
        this.grade = grade;
    }



}