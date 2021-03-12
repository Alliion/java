package com.example.pr15.controllers;

import com.example.pr15.dao.UniversityDAO;
import com.example.pr15.models.University;
import com.example.pr15.services.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@Controller
public class UniversityController {
    private final UniversityService universityService;

    @Autowired
    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping("/universities")
    public String getAll(Model model) {
        model.addAttribute("universities", universityService.getAll());
        model.addAttribute("newUniversity", new University());
        return "universities/index";
    }

    @DeleteMapping("/universities/{id}")
    public String getAll(@PathVariable("id") int id) {
        universityService.delete(id);
        return "redirect:/universities";
    }

    @PostMapping("/universities")
    public String create(@ModelAttribute("newStudent") University university) {
        universityService.save(university);
        return "redirect:/universities";
    }
}
