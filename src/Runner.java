import SubjectsInfo.Subjects;
import ResourceOfExceptions.ResourceException;

import java.util.ArrayList;
import java.util.EnumMap;
import static SubjectsInfo.Subjects.*;

public class Runner{
    static Student studentIvan;
    static Student studentMarry;
    static Student studentPeter;
    static Student studentGeorge;
    static Student studentBob;
    static Student studentJenny;
    static Student studentJulia;
    static Student studentGreg;

    static Group firstGroupFromTechniqueFaculty;
    static Group secondGroupFromTechniqueFaculty;
    static Group firstGroupFromHumanityFaculty;
    static Group secondGroupFromHumanityFaculty;

    static Faculty techniqueFaculty;
    static Faculty humanityFaculty;

    static University university;

    static {
        try {
            //students initialisation
            studentIvan = new Student("Ivan", new EnumMap<Subjects, Integer>(Subjects.class) {
                {
                    this.put(GEOGRAPHY, 8);
                    this.put(HISTORY, 10);
                }
            });
            studentMarry = new Student("Marry", new EnumMap<Subjects, Integer>(Subjects.class) {
                {
                    this.put(SCIENCE, 5);
                    this.put(MATH, 7);
                }
            });
            studentPeter = new Student("Peter", new EnumMap<Subjects, Integer>(Subjects.class) {
                {
                    this.put(GEOGRAPHY, 4);
                    this.put(HISTORY, 10);
                }
            });
            studentGeorge = new Student("George", new EnumMap<Subjects, Integer>(Subjects.class) {
                {
                    this.put(SCIENCE, 6);
                    this.put(MATH, 8);
                }
            });
            studentBob = new Student("Bob", new EnumMap<Subjects, Integer>(Subjects.class) {
                {
                    this.put(ENGLISH, 10);
                    this.put(HISTORY, 7);
                }
            });
            studentJenny = new Student("Jenny", new EnumMap<Subjects, Integer>(Subjects.class) {
                {
                    this.put(HISTORY, 7);
                    this.put(ENGLISH, 5);
                }
            });
            studentJulia = new Student("Julia", new EnumMap<Subjects, Integer>(Subjects.class) {
                {
                    this.put(MATH, 5);
                    this.put(SCIENCE, 7);
                }
            });
            studentGreg = new Student("Greg", new EnumMap<Subjects, Integer>(Subjects.class) {
                {
                    this.put(MATH, 9);
                    this.put(SCIENCE, 6);
                }
            });


             //groups initialisation
            firstGroupFromTechniqueFaculty = new Group(new ArrayList<Student>()
            {
                {
                    this.add(studentGeorge);
                    this.add(studentMarry);
                }
            });

            secondGroupFromTechniqueFaculty = new Group(new ArrayList<Student>()
            {
                {
                    this.add(studentJulia);
                    this.add(studentGreg);
                }
            });

            firstGroupFromHumanityFaculty = new Group(new ArrayList<Student>()
            {
                {
                    this.add(studentIvan);
                    this.add(studentPeter);

                }
            });

            secondGroupFromHumanityFaculty = new Group(new ArrayList<Student>()
            {
                {
                    this.add(studentBob);
                    this.add(studentJenny);
                }
            });

            //faculties initialisation
            techniqueFaculty = new Faculty(new ArrayList<Group>()
            {
                {
                    this.add(firstGroupFromTechniqueFaculty);
                    this.add(secondGroupFromTechniqueFaculty);
                }
            });

            humanityFaculty = new Faculty(new ArrayList<Group>()
            {
                {
                    this.add(firstGroupFromHumanityFaculty);
                    this.add(secondGroupFromHumanityFaculty);
                }
            });

            //university initialisation
            university = new University(new ArrayList<Faculty>()
            {
                {
                    this.add(techniqueFaculty);
                    this.add(humanityFaculty);
                }
            });
        } catch (ResourceException e) {
            e.printStackTrace();
        }
    }
        public static void main(String[] args)throws ResourceException {
            studentIvan.setMarks(ENGLISH,9);
            System.out.println(studentIvan.toString());
            System.out.println(studentIvan.getName()+"'s average sign is "+studentIvan.calculateAverageMark());
            System.out.println("------------");
            System.out.println("Group from technique faculty "+ firstGroupFromTechniqueFaculty.toString());
            System.out.println("Average group mark in math is "+firstGroupFromTechniqueFaculty.calculateAverageMarkInGroupForSubject(MATH));
            System.out.println("------------");
            System.out.println("Humanity faculty is:\n"+ humanityFaculty.toString());
            System.out.println("Average faculty mark in Histoty is "+ humanityFaculty.calculateAverageMarkAtFacultyForSubject(HISTORY));
            System.out.println("------------");
            System.out.println("Average university mark is "+university.calculateAverageMarkAtUniversity());
    }
}
