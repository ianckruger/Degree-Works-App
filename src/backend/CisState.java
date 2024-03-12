package backend;

import java.util.ArrayList;
import java.util.UUID;

public class CisState extends MajorState {
    private ArrayList<String> businessInformationManagement;

    public CisState(MajorState majorState, ArrayList<String> businessInformationManagement) {
        super(majorState);
        this.businessInformationManagement = null;
    };

    public ArrayList<String> getBusinessInformationManagement() {
        return businessInformationManagement;
    }
    
}