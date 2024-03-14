package backend;

import java.util.ArrayList;

public class CsceState extends MajorState {
    private ArrayList<Class> labScienceElective;

    public CsceState(Roadmap roadmap) {
        super(roadmap);
    };

    public ArrayList<Class> getLabScienceElective() {
        return labScienceElective;
    }
    
}