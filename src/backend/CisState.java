package backend;

import java.util.ArrayList;
import java.util.UUID;

public class CisState extends MajorState {
    private ArrayList<Class> businessInformationManagement;

    public CisState(Roadmap roadmap) {
        super(roadmap);
        this.businessInformationManagement = new ArrayList<>();
        setMajor("cis");
        
    };

    public ArrayList<Class> getBusinessInformationManagement() {
        return businessInformationManagement;
    }

    
    public String toString() {
        StringBuilder cisString = new StringBuilder(super.toString());

        cisString.append("\nBusiness Information Management Electives:\n");
        for (Class course : businessInformationManagement) {
            cisString.append(course.toString());
            if (course.IsCompleted()) {
                cisString.append("  --  Passed; Grade: "+calcGrade());
            } else if (course.checkIfFailed()) {
                cisString.append("  --  Failed; Grade: "+calcGrade());
            }
        }

        return cisString.toString();
    }
    
}