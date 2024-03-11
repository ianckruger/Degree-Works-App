package backend;

import java.util.ArrayList;
import java.util.UUID;

public class CsceState extends MajorState {
    private ArrayList<String> labScienceElective;

    public CsceState(MajorState majorState, ArrayList<String> labScienceElective) {
        super(majorState);
        this.labScienceElective = null;
    };

    public ArrayList<String> getLabScienceElective() {
        return labScienceElective;
    }
    
}