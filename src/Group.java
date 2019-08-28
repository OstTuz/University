import java.util.ArrayList;

import ResourceOfExceptions.ResourceException;
import SubjectsInfo.Subjects;

public class Group {
    ArrayList<Student> groupOfStudents;

    public Group(ArrayList<Student> groupOfStudents) throws ResourceException{
        if (groupOfStudents.size() == 0)throw new ResourceException("Group is empty");
        this.groupOfStudents = groupOfStudents;
    }

    public ArrayList<Student> getGroupOfStudents() {
        return groupOfStudents;
    }

    public double calculateAverageMarkInGroupForSubject(Subjects subject)throws ResourceException
    {
        double averageMark = 0;
        int counter = 0;
        for (Student student : groupOfStudents) {
            if (student.getMarks().get(subject) != null)
            {
                averageMark += student.getMarks().get(subject);
                counter++;
            }else throw new ResourceException("Student "+student.getName()+" does not have this subject");
        }
        return averageMark/counter;
    }

    @Override
    public String toString() {
        return groupOfStudents.toString();
    }
}
