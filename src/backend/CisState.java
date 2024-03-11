package backend;

import java.util.ArrayList;
import java.util.UUID;

public class CisState extends MajorState {
    
    private ArrayList<String> majorClasses;
    private ArrayList<String> carolinaCore;
    private Object programRequirements;
    private ArrayList<String> electives;

    public CisState(UUID roadmapID, String major, ArrayList<String> majorClasses, ArrayList<String> carolinaCore, Object programRequirements, ArrayList<String> electives) {
        super(roadmapID, major);
        this.majorClasses = majorClasses;
        this.carolinaCore = carolinaCore;
        this.programRequirements = programRequirements;
        this.electives = electives;
    }
}