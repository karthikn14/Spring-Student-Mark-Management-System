package com.karthi.springboot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.karthi.springboot.Service.StudentService;
import com.karthi.springboot.model.Student;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentservice;
	@GetMapping("/")
	public String homePage(Model model) {
	model.addAttribute("listStudent", studentservice.getAllStudents());
	return "index";
	}
	@GetMapping("/showNewStudentForm")
	public String showNewStudentForm(Model model)
	{
		Student student = new Student();
		model.addAttribute("student", student);
		return "new_student";

	}
	@PostMapping("/saveStudent")
	public String saveStudent(@ModelAttribute("student")Student student)
	{
		studentservice.saveStudent(student);
		return "redirect:/";
	}
	
    @GetMapping("/showFormForUpdate/{regNo}")
    public String showFormForUpdate(@PathVariable(value = "regNo") long id, Model model) {
       Student student = studentservice.getStudentById(id);
        model.addAttribute("student", student);
        return "update_student";
    }
    @GetMapping("/deleteEmployee/{regNo}")
    public String deleteEmployee(@PathVariable(value = "regNo") long regNo) {

         
        this.studentservice.deleteStudentById(regNo);
        return "redirect:/";
    }


	

}
