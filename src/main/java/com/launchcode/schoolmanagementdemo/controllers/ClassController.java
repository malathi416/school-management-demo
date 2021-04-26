package com.launchcode.schoolmanagementdemo.controllers;

import com.launchcode.schoolmanagementdemo.data.ClassesRepository;
import com.launchcode.schoolmanagementdemo.models.Classes;
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
@RequestMapping("classes")
public class ClassController {

    @Autowired
    private ClassesRepository classesRepository;

    @GetMapping
    public String displayAllClasses(Model model) {
        model.addAttribute("title","Classes List");
        model.addAttribute("classes",classesRepository.findAll());
        return "class/class-page";
    }

    @GetMapping("newClassForm")
    public String displayAddClassForm(Model model){
        model.addAttribute("title","Add Class");
        model.addAttribute(new Classes());
        return "class/newClassForm";
    }
    @PostMapping("newClassForm")
    public String processCreateTagForm(@ModelAttribute @Valid Classes classes,
                                       Errors errors, Model model) {
        if(errors.hasErrors()){
            model.addAttribute("title", "Add Class");
//            model.addAttribute(new Classes());
            return "class/newClassForm";
        }
        classesRepository.save(classes);
        return "redirect:";
    }

}
