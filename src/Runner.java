import SubjectsInfo.Subjects;
import ResourceOfExceptions.ResourceException;
import java.util.EnumMap;
import static SubjectsInfo.Subjects.*;

public class Runner {
    public static void main(String[] args)throws ResourceException {
        Student student = new Student("Ivan", new EnumMap<Subjects, Integer>(Subjects.class){
            {
                this.put(GEOGRAPHY, 8);
                this.put(MATH, 10);
            }
        });
        student.setMarks(ENGLISH,9);
        System.out.println(student.toString());
        System.out.println(student.getName()+"'s average sign is "+student.calculateAverageMark());
    }
}
