package backend;

import java.util.ArrayList;

public class CsceState extends MajorState {
    private ArrayList<Class> labScienceElective;

    public CsceState(Roadmap roadmap) {
        super(roadmap);
        this.labScienceElective = new ArrayList<>();
        setMajor("csce");
    };

    public ArrayList<Class> getLabScienceElective() {
        return labScienceElective;
    }

    public String toString() {
        StringBuilder csceString = new StringBuilder(super.toString());

        csceString.append("Lab Science Electives: \n");
        for (Class course : labScienceElective) {
            csceString.append(course.toString()).append("\n");
        }

        return csceString.toString();
    
    }
    
}