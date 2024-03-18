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

    
    public String toString() {
        StringBuilder cisString = new StringBuilder(super.toString());

        cisString.append("Business Information Management Electives:\n");
        for (Class course : businessInformationManagement) {
            cisString.append(course.toString()).append("\n");
        }

        return cisString.toString();
    }
    
}