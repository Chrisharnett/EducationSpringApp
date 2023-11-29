package com.example.educationspringapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author saxDev
 * studentnumber 20188141
 **/

@Component
public class DataPopulator implements CommandLineRunner {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private EnrollmentRepository enrollmentRepository;
    @Autowired
    private GradesRepository gradesRepository;
    @Autowired
    private ProgramsRepository programsRepository;

    @Override
    public void run(String... args) {
        String[][] students = new String[5][7];
        String[][] courses = new String[2][6];
        String[][] programs = new String[2][2];
        String[][] enrollments = new String[5][2];
        String[][] grades = new String[5][3];

        students[0] = new String[]{"Stan", "Getz", "3274 Desafinado Blvd", "Rio De Janiero", "33523", "stan.getz@cna.nl.ca", "889 775-4436"};
        students[1] = new String[]{"Dexter", "Gordon", "334 Fried Bananas Street", "Los Angeles", "33523", "dexter.gordon@cna.nl.ca", "843 445-6466"};
        students[2] = new String[]{"David", "Sanborn", "462 Third Street", "New York", "33523", "david.sanbornz@cna.nl.ca", "205 334-7103"};
        students[3] = new String[]{"Jordan", "Smart", "45 Gogo Penguin lane", "Norwich", "33523", "jordan.smart@cna.nl.ca", "759 336-1863"};
        students[4] = new String[]{"Karl", "Denson", "493 The Greyboy Allstars Way", "Santa Anna", "33523", "karl.denson@cna.nl.ca", "826 481-9662"};

        for (String[] info: students) {
            Student s = new Student();
            s.setFirstName(info[0]);
            s.setLastName(info[1]);
            s.setAddress(info[2]);
            s.setCity(info[3]);
            s.setPostal(info[4]);
            s.setEmail(info[5]);
            s.setPhone(info[6]);
            studentRepository.save(s);
        }

        courses[0] = new String[]{"Modern Harmonic Structures", "MUS4088", "33", "Fall", "2024", "1"};
        courses[1] = new String[]{"Jazz Improvisation Techniques", "MUS2455", "24", "Winter", "2024", "2"};

        for (String[] info: courses) {
            Course c = new Course();
            c.setCourseName(info[0]);
            c.setCourseNumber(info[1]);
            c.setCapacity(Integer.parseInt(info[2]));
            c.setSemester((info[3]));
            c.setYear(Integer.parseInt(info[4]));
            c.setPid(Integer.parseInt(info[5]));
            courseRepository.save(c);
        }

        programs[0] = new String[]{"Theory and Composition", "Prince Philip Drive"};
        programs[1] = new String[]{"Jazz Performance", "Ridge Road"};

        for (String[] info: programs) {
            Programs p = new Programs();
            p.setProgramName(info[0]);
            p.setCampus(info[1]);
            programsRepository.save(p);
        }

        enrollments[0] = new String[]{"1", "4"};
        enrollments[1] = new String[]{"2", "2"};
        enrollments[2] = new String[]{"1", "1"};
        enrollments[3] = new String[]{"2", "1"};
        enrollments[4] = new String[]{"1", "3"};

        for (String[] info: enrollments) {
            Enrollment e = new Enrollment();
            e.setCourseId(Integer.parseInt(info[0]));
            e.setStudentId(Integer.parseInt(info[1]));
            enrollmentRepository.save(e);
        }

        grades[0] = new String[]{"1", "4", "86"};
        grades[1] = new String[]{"1", "1", "74"};
        grades[2] = new String[]{"1", "3", "58"};
        grades[3] = new String[]{"2", "1", "92"};
        grades[4] = new String[]{"2", "2", "67"};

        for (String[] info: grades) {
            Grades g = new Grades();
            g.setCourseId(Integer.parseInt(info[0]));
            g.setStudentId(Integer.parseInt(info[1]));
            g.setGrade(Integer.parseInt(info[2]));
            gradesRepository.save(g);
        }
    }
}
