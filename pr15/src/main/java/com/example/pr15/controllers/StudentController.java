package com.example.pr15.controllers;

import com.example.pr15.dao.StudentDAO;
import com.example.pr15.models.Student;
import com.example.pr15.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@Controller
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String getAll(Model model) {
        model.addAttribute("students", studentService.getAll());
        model.addAttribute("newStudent", new Student());
        return "students/index";
    }

    @DeleteMapping("/students/{id}")
    public String getAll(@PathVariable("id") int id) {
        studentService.delete(id);
        return "redirect:/students";
    }

    @PostMapping("/students")
    public String create(@ModelAttribute("newStudent") Student student) {
        studentService.save(student);
        return "redirect:/students";
    }
}
