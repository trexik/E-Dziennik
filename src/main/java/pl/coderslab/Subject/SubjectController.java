package pl.coderslab.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Group.Group;
import pl.coderslab.Repositories.GroupRepository;
import pl.coderslab.Repositories.SubjectRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    GroupRepository groupRepository;

    @ModelAttribute("groups")
    public List<Group> getGroups() {
        return groupRepository.findAll();
    }

    @GetMapping("/list")
    public String getList(Model model) {
        List<Subject> subjects = subjectRepository.findAll(Sort.by("group"));
        model.addAttribute("subjects", subjects);
        return "subjectList";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("subject", new Subject());
        return "subject";
    }

    @PostMapping("/add")
    public String addSubject(@ModelAttribute @Valid Subject subject, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "redirect:add";
        }
        subjectRepository.save(subject);
//        List<Subject> subjects = subjectRepository.findAll(Sort.by("group"));
//        model.addAttribute("subjects", subjects);
        return "subject";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        subjectRepository.deleteById(id);
        List<Subject> subjects = subjectRepository.findAll(Sort.by("group"));
        model.addAttribute("subjects", subjects);
        String text = "Usunięto przedmiot";
        model.addAttribute("msg", text);
        return "subjectList";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        Optional<Subject> subject = subjectRepository.findById(id);
        model.addAttribute("subject", subject);
        return "subject";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute @Valid Subject subject, Model model) {
        subjectRepository.save(subject);
        List<Subject> subjects = subjectRepository.findAll(Sort.by("group"));
        model.addAttribute("subjects", subjects);
        return "subjectList";
    }

}
