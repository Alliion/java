package com.example.pr14.controllers;

import com.example.pr14.dao.StudentDAO;
import com.example.pr14.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
    private final StudentDAO studentDAO;

    @Autowired
    public StudentController(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @GetMapping("/students")
    public String getAll(Model model) {
        model.addAttribute("students", studentDAO.getAll());
        model.addAttribute("newStudent", new Student());
        return "students/index";
    }

    @DeleteMapping("/students/{id}")
    public String getAll(@PathVariable("id") int id) {
        studentDAO.delete(id);
        return "redirect:/students";
    }

    @PostMapping("/students")
    public String create(@ModelAttribute("newStudent") Student student) {
        studentDAO.save(student);
        return "redirect:/students";
    }
}
