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
    private boolean isCarolinaCore;
    private boolean isFoundational;
    private boolean isLibElective;
    private boolean isElective;
    private boolean isMajorCourse;
    private boolean isBIM;
    private boolean isLabScience;
    private String courseDescription;

    private int yearTaken;
    private int semesterTaken;

    private boolean completed;
    private boolean inProgress;
    private boolean transferred;
    private String grade;
    private ArrayList<StudentType> studentType;

    public Class() {
        // methods
    }

}