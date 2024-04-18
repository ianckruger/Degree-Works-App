package backend;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Roadmap {
    private Student student;
    // private ArrayList<String> classes;
    private MajorState majorState;
    // private StatusState statusState;
    private CsceState csceState;
    private CisState cisState;
    private CeState ceState;
    // private DefaultState defaultState;
    // private CompletedState completedState;
    // private IncompletedState incompletedState;
    // private HistoryState historyState;
    // private double progressBar;
    protected UUID roadmapID;
    private String major;
    private static Roadmap roadmap;
    private ArrayList<String> advisorNotes;


    public Roadmap(String major) {
        this.advisorNotes = new ArrayList<>();
        this.major = major;
        cisState = new CisState(this);
        csceState = new CsceState(this);
        ceState = new CeState(this);

        
        if(major.equalsIgnoreCase("cis")){
            setMajorState(cisState);
        } else if (major.equalsIgnoreCase("ce")){
            setMajorState(ceState);
        } else if (major.equalsIgnoreCase("csce")){
            setMajorState(csceState);
        }

    }

    public void setAdvisorNotes(ArrayList<String> notes) {
        this.advisorNotes = notes;
    }

    public static Roadmap getInstance() {
        if(roadmap == null) {
            roadmap = DataLoader.readRoadmap();
         }
        return roadmap;
    }

    public void setMajorState(MajorState majorState) {
        this.majorState = majorState;
    }

    public void setMajorState(String major) {
        if(major.equalsIgnoreCase("cis")){
            setMajorState(cisState);
        } else if (major.equalsIgnoreCase("ce")){
            setMajorState(ceState);
        } else if (major.equalsIgnoreCase("csce")){
            setMajorState(csceState);
        }
    }

    public void setCisState(CisState state) {
        this.cisState = state;
        setMajorState(cisState);
    }

    public void setCeState(CeState state) {
        this.ceState = state;
        setMajorState(ceState);
    }

    public void setCsState(CsceState state) {
        this.csceState = state;
        setMajorState(csceState);
    }

    public String displayClasses() {
        System.out.println("Major State: " + majorState.getMajor() + ".\n");
        return majorState.toString();
    }
    
    public String displayStudentInfo() {
        return "";
    }

    public MajorState getMajorState() {
        return this.majorState;
    }

    public ArrayList<Class> getClasses() {
        ArrayList<Class> classes = new ArrayList<>();
        
        classes.addAll(majorState.getMajorClasses());
        classes.addAll(majorState.getCarolinaCore());
        classes.addAll(majorState.getElectives());
        classes.addAll(majorState.getLiberalArtsElectives());
        classes.addAll(majorState.getFoundationalCourses());
        classes.addAll(majorState.getLowerDivisionComputing());

        return classes;

    }

    public ArrayList<Class> getCompletedClasses() {
        ArrayList<Class> completedClasses = new ArrayList<>();
        
        // Add completed major classes
        for (Class course : majorState.getMajorClasses()) {
            if (course.IsCompleted()) {
                completedClasses.add(course);
            }
        }
        
        // Add completed Carolina Core classes
        for (Class course : majorState.getCarolinaCore()) {
            if (course.IsCompleted()) {
                completedClasses.add(course);
            }
        }
        
        // Add completed electives
        for (Class course : majorState.getElectives()) {
            if (course.IsCompleted()) {
                completedClasses.add(course);
            }
        }
        
        // Add completed liberal arts electives
        for (Class  course : majorState.getLiberalArtsElectives()) {
            if (course.IsCompleted()) {
                completedClasses.add( course);
            }
        }
        
        // Add completed foundational courses
        for (Class course : majorState.getFoundationalCourses()) {
            if (course.IsCompleted()) {
                completedClasses.add(course);
            }
        }
        
        // Add completed lower division computing classes
        for (Class course : majorState.getLowerDivisionComputing()) {
            if (course.IsCompleted()) {
                completedClasses.add(course);
            }
        }
        
        return completedClasses;
    }

    public ArrayList<Class> getIncompletedClasses() {
        ArrayList<Class> completedClasses = new ArrayList<>();
        
        // Add incompleted major classes
        for (Class course : majorState.getMajorClasses()) {
            if (!course.IsCompleted()) {
                completedClasses.add(course);
            }
        }
        
        // Add incompleted Carolina Core classes
        for (Class course : majorState.getCarolinaCore()) {
            if (!course.IsCompleted()) {
                completedClasses.add(course);
            }
        }
        
        // Add incompleted electives
        for (Class course : majorState.getElectives()) {
            if (!course.IsCompleted()) {
                completedClasses.add(course);
            }
        }
        
        // Add incompleted liberal arts electives
        for (Class  course : majorState.getLiberalArtsElectives()) {
            if (!course.IsCompleted()) {
                completedClasses.add( course);
            }
        }
        
        // Add incompleted foundational courses
        for (Class course : majorState.getFoundationalCourses()) {
            if (!course.IsCompleted()) {
                completedClasses.add(course);
            }
        }
        
        // Add incompleted lower division computing classes
        for (Class course : majorState.getLowerDivisionComputing()) {
            if (!course.IsCompleted()) {
                completedClasses.add(course);
            }
        }
        
        return completedClasses;
    }




    
    

}