package com.launchcode.schoolmanagementdemo.controllers;

import com.launchcode.schoolmanagementdemo.data.ClassesRepository;
import com.launchcode.schoolmanagementdemo.data.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
