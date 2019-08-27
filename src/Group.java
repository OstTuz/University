import java.util.ArrayList;
import ResourceOfExceptions.ResourceException;

public class Group {
    ArrayList<Student> group;

    public Group(ArrayList<Student> group) throws ResourceException{
        if (group.size() == 0)throw new ResourceException("Group is empty");
        this.group = group;
    }

    public double calculateAverageMarkInGroup()
    {
        double averageMarkInGroup = 0;
        for (Student student: group) {
            averageMarkInGroup += student.calculateAverageMark();
        }
        return averageMarkInGroup/group.size();
    }
}
