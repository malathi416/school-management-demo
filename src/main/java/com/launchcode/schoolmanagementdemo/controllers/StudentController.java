package com.launchcode.schoolmanagementdemo.controllers;


import com.launchcode.schoolmanagementdemo.data.ClassesRepository;
import com.launchcode.schoolmanagementdemo.data.StudentRepository;
import com.launchcode.schoolmanagementdemo.models.Gender;
import com.launchcode.schoolmanagementdemo.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ClassesRepository classesRepository;
    @GetMapping
    public String displayAllStudents(Model model) {
        model.addAttribute("title","Student List");
        model.addAttribute("students",studentRepository.findAll());
        return "student/student-page";
    }
    @GetMapping("newStudentForm")
    public String displayAddStudentForm(Model model){
        model.addAttribute("title","Add Student");
        model.addAttribute(new Student());
        model.addAttribute("genders", Gender.values());
        model.addAttribute("classRegistered",classesRepository.findAll());
        return "student/newStudentForm";
    }
    @PostMapping("newStudentForm")
    public String processStudentForm(@ModelAttribute @Valid Student student,
                                     Errors errors, Model model) {
        if(errors.hasErrors()){
            model.addAttribute("title", "Add Student");
            model.addAttribute("genders", Gender.values());
            model.addAttribute("classRegistered",classesRepository.findAll());
            return "student/newStudentForm";
        }
        studentRepository.save(student);
        return "redirect:";
    }
    @GetMapping("showFormForUpdate/{id}")
    public String displayTeacherEditForm(Model model, @PathVariable(value="id") Integer id) {
        Optional<Student> result = studentRepository.findById(id);
        Student editStudent = result.get();
        model.addAttribute("title","Update  Student  where  ID = "+id +" name is "+ editStudent.getPersonalDetails().getFirstName()) ;
        model.addAttribute("student",editStudent);
        model.addAttribute("genders", Gender.values());
        model.addAttribute("classRegistered",classesRepository.findAll());
        return "student/edit-student-page";
    }
    @PostMapping("showFormForUpdate")
    public String processStudentEditedForm(@RequestParam(required = false) Integer id, @ModelAttribute Student editStudent, RedirectAttributes redirectAttributes) {

        studentRepository.save(editStudent);
//        redirectAttributes.addFlashAttribute("message", "updated the Teacher record Success fully !!");
//        model.addAttribute("message","updated the Teacher record Success fully !!");

        return "redirect:";
    }
    @GetMapping("/deleteStudent/{id}")
    public String deleteStudentById(@PathVariable(value="id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        studentRepository.deleteById(id);
        redirectAttributes.addFlashAttribute("success", "Deleted the Student record Success fully !!");
        return "redirect:/students";
    }
}
