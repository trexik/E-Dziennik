package pl.coderslab.Grade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Repositories.GradeRepository;
import pl.coderslab.Repositories.SubjectRepository;
import pl.coderslab.Repositories.UserRepository;
import pl.coderslab.Subject.Subject;
import pl.coderslab.User.User;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    GradeRepository gradeRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @ModelAttribute("users")
    List<User> getUserList() {
        return userRepository.findAll();
    }

    @ModelAttribute("subjects")
    public List<Subject> subjectList() {
        return subjectRepository.findAll();
    }

    @GetMapping("/add")
    public String calcGrade() {
        return "grade";
    }

    @PostMapping("/add")
    @ResponseBody
    public String addGrade(@RequestParam double points, @RequestParam double maxpoints, Model model) {
        double resultPercent = (points / maxpoints) * 100;
        Integer resultGrade = 0;
        if (resultPercent <= 25) {
            resultGrade = 1;
        } else if (resultPercent >= 90) {
            resultGrade = 6;
        } else if (resultPercent >= 80) {
            resultGrade = 5;
        } else if (resultPercent >= 60) {
            resultGrade = 4;
        } else if (resultPercent >= 40) {
            resultGrade = 3;
        } else if (resultPercent >= 26) {
            resultGrade = 2;
        }
        model.addAttribute("grade", resultGrade);
        return resultGrade.toString();
    }

    @GetMapping("/addGrade")
    public String addGradeToDb(Model model) {
        List<User>users = userRepository.findAll();
        List<Subject>subjects = subjectRepository.findAll();
        model.addAttribute("subjects", subjects);
        model.addAttribute("users", users);
        model.addAttribute("grade", new Grade());
        return "addGrade";
    }

    @PostMapping("/addGrade")
    public String addGradetoDb(@ModelAttribute @Valid Grade grade, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:addGrade";
        }
        gradeRepository.save(grade);
        return "addGrade";
    }

    @GetMapping("/gradeList")
    public String gradeList(Model model) {
        List<Grade>grades = gradeRepository.findAll();
        model.addAttribute("grades", grades);
        return "gradeList";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        gradeRepository.deleteById(id);
        List<Grade>grades = gradeRepository.findAll();
        String text = "Usunięto ocene";
        model.addAttribute("msg", text);
        model.addAttribute("users", grades);
        return "gradeList";
    }


}
