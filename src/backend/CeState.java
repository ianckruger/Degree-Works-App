package backend;

import java.util.ArrayList;
import java.util.UUID;

public class CeState extends MajorState {
    private ArrayList<Class> electricalEngineering;

    public CeState(MajorState majorState, ArrayList<Class> electricalEngineering) {
        super(majorState);
        this.electricalEngineering = null;
    };

    public ArrayList<Class> getElectricalEngineering() {
        return electricalEngineering;
    }
    
}