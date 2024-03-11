package backend;

import java.util.ArrayList;
import java.util.UUID;

public class CeState extends MajorState {
    private ArrayList<String> electricalEngineering;

    public CeState(MajorState majorState, ArrayList<String> electricalEngineering) {
        super(majorState);
        this.electricalEngineering = null;
    };

    public ArrayList<String> getElectricalEngineering() {
        return electricalEngineering;
    }
    
}