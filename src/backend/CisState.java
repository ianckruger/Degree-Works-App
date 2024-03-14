package backend;

import java.util.ArrayList;
import java.util.UUID;

public class CisState extends MajorState {
    private ArrayList<Class> businessInformationManagement;

    public CisState(Roadmap roadmap) {
        super(roadmap);
        
    };

    public ArrayList<Class> getBusinessInformationManagement() {
        return businessInformationManagement;
    }
    
}