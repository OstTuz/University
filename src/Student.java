import SubjectsInfo.Subjects;
import ResourceOfExceptions.ResourceException;
import java.util.EnumMap;

public class Student {
    private String name;
    private EnumMap<Subjects, Integer> marks;

    Student(String name, EnumMap<Subjects, Integer>marks) throws ResourceException {
        this.name = name;
        if (marks.size() == 0) throw new ResourceException("There are no marks");
        for (Integer mark:marks.values()) {
            if (mark < 0 || mark > 10) throw new ResourceException("Sign is not correct (change to 0-10)");
        }
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public EnumMap<Subjects, Integer> getMarks() {
        return marks;
    }

    public void setMarks(Subjects subject, Integer mark) throws ResourceException{
        if (mark >= 0 && mark <= 10)
            this.marks.put(subject, mark);
        else throw new ResourceException("Mark is not correct (change to 0-10)");
    }

    @Override
    public String toString() {
        return name + " " + marks;
    }

    public double calculateAverageMark()
    {
        double averageSign = 0;
        for (Integer mark : marks.values()) {
            averageSign += mark;
        }
        return averageSign/ marks.size();
    }
}
