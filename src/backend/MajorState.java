package backend;

import java.util.ArrayList;
import java.util.UUID;

public abstract class MajorState {

    protected Roadmap roadmap;
    private ArrayList<String> majorClasses;
    private ArrayList<String> carolinaCore;
    private ArrayList<String> electives;
    private ArrayList<String> liberalArtsElectives;
    private ArrayList<String> foundationalCourses;
    private ArrayList<String> lowerDivisionComputing;
    protected MajorState majorState;

    public MajorState(UUID roadmapID, String major, ArrayList<String> majorClasses, ArrayList<String> carolinaCore, ArrayList<String> liberalArtsElectives, ArrayList<String> foundationalCourses, ArrayList<String> lowerDivisionComputing, ArrayList<String> electives) {
        this.majorClasses = majorClasses;
        this.carolinaCore = carolinaCore;
        this.liberalArtsElectives = liberalArtsElectives;
        this.foundationalCourses = foundationalCourses;
        this.lowerDivisionComputing = lowerDivisionComputing;
    }

    public MajorState(MajorState majorState) {
        this.majorState = majorState;
    }

    public ArrayList<String> getMajorClasses() {
        return majorClasses;
    }

    public void setMajorClasses(ArrayList<String> majorClasses) {
        this.majorClasses = majorClasses;
    }

    public ArrayList<String> getCarolinaCore() {
        return carolinaCore;
    }

    public void setCarolinaCore(ArrayList<String> carolinaCore) {
        this.carolinaCore = carolinaCore;
    }

    public ArrayList<String> getLiberalArtsElectives() {
        return liberalArtsElectives;
    }
    
    public void setLiberalArtsElectives(ArrayList<String> liberalArtsElectives) {
        this.liberalArtsElectives = liberalArtsElectives;
    }

    public ArrayList<String> getFoundationalCourses() {
        return foundationalCourses;
    }

    public void setFoundationalCourses(ArrayList<String> foundationalCourses) {
        this.foundationalCourses = foundationalCourses;
    }

    public ArrayList<String> getLowerDivisionComputing() {
        return lowerDivisionComputing;
    }

    public void setLowerDivisionComputing(ArrayList<String> lowerDivisionComputing) {
        this.lowerDivisionComputing = lowerDivisionComputing;
    }

    public ArrayList<String> getElectives() {
        return electives;
    }

    public void setElectives(ArrayList<String> electives) {
        this.electives = electives;
    }

}