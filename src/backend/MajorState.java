package backend;

import java.util.ArrayList;
import java.util.UUID;

public abstract class MajorState {

    protected Roadmap roadmap;
    private ArrayList<Class> majorClasses;
    private ArrayList<Class> carolinaCore;
    private ArrayList<Class> electives;
    private ArrayList<Class> liberalArtsElectives;
    private ArrayList<Class> foundationalCourses;
    private ArrayList<Class> lowerDivisionComputing;
    protected MajorState majorState;

    public MajorState(UUID roadmapID, String major, ArrayList<Class> majorClasses, ArrayList<Class> carolinaCore, ArrayList<Class> liberalArtsElectives, ArrayList<Class> foundationalCourses, ArrayList<Class> lowerDivisionComputing, ArrayList<Class> electives) {
        this.majorClasses = majorClasses;
        this.carolinaCore = carolinaCore;
        this.liberalArtsElectives = liberalArtsElectives;
        this.foundationalCourses = foundationalCourses;
        this.lowerDivisionComputing = lowerDivisionComputing;
    }

    public MajorState(MajorState majorState) {
        this.majorState = majorState;
    }

    public ArrayList<Class> getMajorClasses() {
        return majorClasses;
    }

    public void setMajorClasses(ArrayList<Class> majorClasses) {
        this.majorClasses = majorClasses;
    }

    public ArrayList<Class> getCarolinaCore() {
        return carolinaCore;
    }

    public void setCarolinaCore(ArrayList<Class> carolinaCore) {
        this.carolinaCore = carolinaCore;
    }

    public ArrayList<Class> getLiberalArtsElectives() {
        return liberalArtsElectives;
    }
    
    public void setLiberalArtsElectives(ArrayList<Class> liberalArtsElectives) {
        this.liberalArtsElectives = liberalArtsElectives;
    }

    public ArrayList<Class> getFoundationalCourses() {
        return foundationalCourses;
    }

    public void setFoundationalCourses(ArrayList<Class> foundationalCourses) {
        this.foundationalCourses = foundationalCourses;
    }

    public ArrayList<Class> getLowerDivisionComputing() {
        return lowerDivisionComputing;
    }

    public void setLowerDivisionComputing(ArrayList<Class> lowerDivisionComputing) {
        this.lowerDivisionComputing = lowerDivisionComputing;
    }

    public ArrayList<Class> getElectives() {
        return electives;
    }

    public void setElectives(ArrayList<Class> electives) {
        this.electives = electives;
    }

}