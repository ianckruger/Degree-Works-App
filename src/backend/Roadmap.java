package backend;
import java.util.ArrayList;
import java.util.UUID;

public class Roadmap {
    private Student student;
    private ArrayList<Class> classes;
    private Majorstate majorState;
    private StatusState statusState;
    private CsceState csceState;
    private CisState cisState;
    private CeState ceState;
    private DefaultState defaultState;
    private CompletedState completedState;
    private IncompletedState incompletedState;
    private HistoryState historyState;
    private double progressBar;
    private UUID roadmapID;


    public Roadmap(Student student) {

    }

    public void setRoadmapID(UUID roadmapID) {
        this.roadmapID = roadmapID;
    }

    public UUID getRoadmapID() {
        return roadmapID;

    }

}