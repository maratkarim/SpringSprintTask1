package SprintTask1.spring.controller;

import SprintTask1.spring.models.DBManager;
import SprintTask1.spring.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HomeController {
    @GetMapping(value = "/")
    public String index(Model model){
        ArrayList<Student> students = DBManager.getAllStudents();
        model.addAttribute("stud_att", students);
        return "vendor/index";
    }
    @GetMapping(value = "/addItemPage")
    public String addItemPage(){
        return "vendor/addItem";
    }
    @PostMapping(value = "/addItemS")
    public String addItem(@RequestParam(name="name") String studentName,
                          @RequestParam(name="surname") String studentSurname,
                          @RequestParam(name="exam") int studentExam){
        Student student = new Student();
        student.setName(studentName);
        student.setSurname(studentSurname);
        student.setExam(studentExam);

        DBManager.addStudent(student);

        return "redirect:/";
    }
}
