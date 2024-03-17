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
    


    @Override
    public String toString() {
        JSONObject roadmapData = readRoadmapDataFromFile();
        if (roadmapData != null) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Object key : roadmapData.keySet()) {
                String keyStr = (String) key;
                Object keyvalue = roadmapData.get(keyStr);
                stringBuilder.append(keyStr).append(": ").append(keyvalue).append("\n");
            }
            return stringBuilder.toString();
        } else {
            return "Error: Unable to retrieve roadmap data";
        }
    }

    private JSONObject readRoadmapDataFromFile() {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("roadmap.json"));
            JSONObject jsonObject = (JSONObject) obj;
            return jsonObject;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

}