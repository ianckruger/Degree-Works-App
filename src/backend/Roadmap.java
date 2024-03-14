package backend;
import java.util.ArrayList;
import java.util.UUID;

public class Roadmap {
    // private Student student;
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


    public Roadmap() {
<<<<<<< HEAD
        cisState = new CisState(this);
        csceState = new CsceState(this);
        ceState = new CeState(this);
=======

         
        cisState = new CisState(majorState, null);
        csceState = new CsceState(majorState, null);
        ceState = new CeState(majorState, null);
>>>>>>> c2f22a4ecc967c1e45f319b5469f0a1bdfd5867b

        if(majorState.equals(cisState)) {
            setMajorState(cisState);
        } else if (majorState.equals(csceState)) {
            setMajorState(csceState);
        } else if (majorState.equals(cisState)) {
            setMajorState(ceState);
        }
    }

    public static Roadmap getInstance() {
        if(roadmap == null) {
            roadmap = new Roadmap();
         }
        return roadmap;
    }


    public void setMajorState(MajorState majorState) {
        this.majorState = majorState;
    }

    public void setCisState(CisState state) {
        this.cisState = state;
    }

    public void setCeState(CeState state) {
        this.ceState = state;
    }

    public void setCsState(CsceState state) {
        this.csceState = state;
    }

    public String displayClasses() {
        return "";
    }
    
    public String displayStudentInfo() {
        return "";
    }
    

}