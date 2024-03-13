package backend;

import java.util.ArrayList;

public class CsceState extends MajorState {
    private ArrayList<Class> labScienceElective;

    public CsceState(MajorState majorState, ArrayList<Class> labScienceElective) {
        super(majorState);
        this.labScienceElective = null;
    };

    public ArrayList<Class> getLabScienceElective() {
        return labScienceElective;
    }
    
}