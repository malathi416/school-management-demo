package com.launchcode.schoolmanagementdemo.controllers;

import com.launchcode.schoolmanagementdemo.data.ClassesRepository;
import com.launchcode.schoolmanagementdemo.data.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("teachers")
public class TeacherController {
    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping
    public String displayAllTeachers(Model model) {
        model.addAttribute("title","Teachers List");
        model.addAttribute("teachers",teacherRepository.findAll());
        return "teacher/teacher-page";
    }
}
