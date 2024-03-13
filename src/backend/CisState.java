package backend;

import java.util.ArrayList;
import java.util.UUID;

public class CisState extends MajorState {
    private ArrayList<Class> businessInformationManagement;

    public CisState(MajorState majorState, ArrayList<String> businessInformationManagement) {
        super(majorState);
        this.businessInformationManagement = null;
    };

    public ArrayList<Class> getBusinessInformationManagement() {
        return businessInformationManagement;
    }
    
}