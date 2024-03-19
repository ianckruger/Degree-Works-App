package backend;

import java.util.ArrayList;

public class CsceState extends MajorState {
    private ArrayList<Class> labScienceElective;

    public CsceState(Roadmap roadmap) {
        super(roadmap);
        this.labScienceElective = new ArrayList<>();
    };

    public ArrayList<Class> getLabScienceElective() {
        return labScienceElective;
    }

    public String toString() {
        StringBuilder csceString = new StringBuilder(super.toString());

        csceString.append("Lab Science Electives: GEOL 101 (A+), GEOL 103 (A+)\nMajor classes to take: CSCE 551, CSCE 355, CSCE 416, CSCE 490, CSCE 492 \nGFL electives: FREN 109, FREN 121, FREN 122, SPAN 109, SPAN 121, SPAN 122, ITAL 121, ITAL 122 \n");
        for (Class course : labScienceElective) {
            csceString.append(course.toString()).append("\n");
        }

        return csceString.toString();
    
    }
    
}