package com.launchcode.schoolmanagementdemo.controllers;

import com.launchcode.schoolmanagementdemo.data.ClassesRepository;
import com.launchcode.schoolmanagementdemo.models.Classes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

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
    @GetMapping("showFormForUpdate/{id}")
    public String displayEditForm(Model model, @PathVariable(value="id") Integer id) {
        Optional<Classes> result = classesRepository.findById(id);
        Classes editClass = result.get();
        model.addAttribute("title","Update  Class   "+ editClass.getClassName()) ;
        model.addAttribute("classes",editClass);
        return "class/edit-class-page";
    }

//
//    @PostMapping("showFormForUpdate")
//    public String processEditForm(@RequestParam(required = false) Integer id,@ModelAttribute Classes editClass,final RedirectAttributes redirectAttributes) {
////        redirectAttributes.addFlashAttribute("message", "updated the class record Success fully !!");
//        classesRepository.save(editClass);
//        return "redirect:";
//    }
    @GetMapping("/deleteClass/{id}")
    public String deleteClassById(@PathVariable(value="id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        classesRepository.deleteById(id);
        redirectAttributes.addFlashAttribute("success", "Deleted the class record Success fully !!");
        return "redirect:/classes";
    }

}
