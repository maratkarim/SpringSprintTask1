package SprintTask1.spring.models;

import java.util.ArrayList;

public class DBManager {
    public static ArrayList<Student> students = new ArrayList<>();
    private static long id=7L;
    static{
        students.add(new Student(1L, "Marat", "Karim", 100,"A"));
        students.add(new Student(2L, "Bekzat", "Gab", 80,"B"));
        students.add(new Student(3L, "Zinep", "Akhmet", 95,"A"));
        students.add(new Student(4L, "Abu", "Sapar", 45,"F"));
        students.add(new Student(5L, "Arna", "Bek", 65,"C"));
        students.add(new Student(6L, "Aliya", "Murat", 59,"D"));
    }
    public static ArrayList<Student> getAllStudents(){
        return students;
    }

    public static Student getStudent(Long id) {
        return students.stream().filter(student -> student.getId() == id).findFirst().orElseThrow();
    }

    public static void addStudent(Student student){
        if (student.getExam()>=90 && student.getExam()<=100){
            student.setMark("A");
        }else if(student.getExam()>=75 && student.getExam()<90){
            student.setMark("B");
        }else if(student.getExam()>=60 && student.getExam()<75){
            student.setMark("C");
        }else if(student.getExam()>=50 && student.getExam()<60){
            student.setMark("D");
        }else if(student.getExam()<50 && student.getExam()>0){
            student.setMark("F");
        }else{
            student.setMark("ERROR");
        }
        student.setId(id);
        id++;
        students.add(student);
    }
}
