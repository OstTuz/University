import java.util.List;
import ResourceOfExceptions.ResourceException;

public class University {
    List<Faculty> universityOfFaculties;

    public University(List<Faculty> universityOfFaculties)throws ResourceException {
        if (universityOfFaculties.size() == 0) throw new ResourceException("There are no faculties in the university");
        this.universityOfFaculties = universityOfFaculties;
    }

    public double calculateAverageMarkAtUniversity()
    {
        double averageMarkAtUniversity = 0;
        int amountOfStudents = 0;
        for (int i = 0; i < universityOfFaculties.size() ; i++) {
            for (int j = 0; j < universityOfFaculties.get(i).getFacultyOfGroups().size(); j++) {
                for (int k = 0; k < universityOfFaculties.get(i).getFacultyOfGroups().get(j).getGroupOfStudents().size(); k++) {
                    averageMarkAtUniversity += universityOfFaculties.get(i).getFacultyOfGroups().get(j).getGroupOfStudents().get(k).calculateAverageMark();
                    amountOfStudents++;
                }
            }
        }
        return averageMarkAtUniversity/amountOfStudents;
    }
}
