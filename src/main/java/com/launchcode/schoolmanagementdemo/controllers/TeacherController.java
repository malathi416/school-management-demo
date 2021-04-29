package com.launchcode.schoolmanagementdemo.controllers;

import com.launchcode.schoolmanagementdemo.data.ClassesRepository;
import com.launchcode.schoolmanagementdemo.data.TeacherRepository;
import com.launchcode.schoolmanagementdemo.models.Gender;
import com.launchcode.schoolmanagementdemo.models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("teachers")
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private ClassesRepository classesRepository;

    @GetMapping
    public String displayAllTeachers(Model model) {
        model.addAttribute("title","Teachers List");
        model.addAttribute("teachers",teacherRepository.findAll());
        return "teacher/teacher-page";
    }
    @GetMapping("newTeacherForm")
    public String displayAddTeacherForm(Model model){
        model.addAttribute("title","Add Teacher");
        model.addAttribute(new Teacher());
        model.addAttribute("genders", Gender.values());
        model.addAttribute("classesToTeach",classesRepository.findAll());
        return "teacher/newTeacherForm";
    }
    @PostMapping("newTeacherForm")
    public String processTeacherForm(@ModelAttribute @Valid Teacher teacher,
                                       Errors errors, Model model) {
        if(errors.hasErrors()){
            model.addAttribute("title", "Add Teacher");
            model.addAttribute("genders", Gender.values());
            model.addAttribute("classesToTeach",classesRepository.findAll());
            return "teacher/newTeacherForm";
        }
        teacherRepository.save(teacher);
        return "redirect:";
    }
}
