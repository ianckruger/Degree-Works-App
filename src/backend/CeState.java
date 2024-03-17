package backend;

import java.util.ArrayList;
import java.util.UUID;

public class CeState extends MajorState {
    private ArrayList<Class> electricalEngineering;

    public CeState(Roadmap roadmap) {
        super(roadmap);
    };

    public ArrayList<Class> getElectricalEngineering() {
        return electricalEngineering;
    }

    public String toString() {
        StringBuilder ceString = new StringBuilder(super.toString());

        ceString.append("Electrical Engineering Electives: ").append(electricalEngineering).append("\n");

        return ceString.toString();
    }
    
}