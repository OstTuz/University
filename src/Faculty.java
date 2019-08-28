import ResourceOfExceptions.ResourceException;
import SubjectsInfo.Subjects;

import java.util.ArrayList;

public class Faculty {
    ArrayList<Group> facultyOfGroups;

    public Faculty(ArrayList<Group> facultyOfGroups)throws ResourceException {
        if (facultyOfGroups.size() == 0) throw new ResourceException("Faculty is empty");
        this.facultyOfGroups = facultyOfGroups;
    }

    public ArrayList<Group> getFacultyOfGroups() {
        return facultyOfGroups;
    }

    public double calculateAverageMarkAtFacultyForSubject(Subjects subject)throws ResourceException
    {
        double averageMark = 0;
        for (Group group : facultyOfGroups)
        {
            averageMark += group.calculateAverageMarkInGroupForSubject(subject);
        }
        return averageMark/ facultyOfGroups.size();
    }

    @Override
    public String toString() {
        return facultyOfGroups.toString();
    }

}
