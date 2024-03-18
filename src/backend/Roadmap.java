package backend;
import java.util.ArrayList;
import java.util.UUID;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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


    public Roadmap(String major) {
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