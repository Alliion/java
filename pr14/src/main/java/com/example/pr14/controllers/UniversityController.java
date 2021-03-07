package com.example.pr14.controllers;

import com.example.pr14.dao.StudentDAO;
import com.example.pr14.dao.UniversityDAO;
import com.example.pr14.models.Student;
import com.example.pr14.models.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UniversityController {
    private final UniversityDAO universityDAO;

    @Autowired
    public UniversityController(UniversityDAO universityDAO) {
        this.universityDAO = universityDAO;
    }

    @GetMapping("/universities")
    public String getAll(Model model) {
        model.addAttribute("universities", universityDAO.getAll());
        model.addAttribute("newUniversity", new University());
        return "universities/index";
    }

    @DeleteMapping("/universities/{id}")
    public String getAll(@PathVariable("id") int id) {
        universityDAO.delete(id);
        return "redirect:/universities";
    }

    @PostMapping("/universities")
    public String create(@ModelAttribute("newStudent") University university) {
        universityDAO.save(university);
        return "redirect:/universities";
    }
}
