package pl.coderslab.Group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Repositories.GroupRepository;
import pl.coderslab.Repositories.UserRepository;
import pl.coderslab.User.User;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/group")
public class GroupController {

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    UserRepository userRepository;


    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("group", new Group());
        return "group";
    }

    @PostMapping("/add")
    public String addGroup(@ModelAttribute @Valid Group group, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "redirect:add";
        }
        groupRepository.save(group);
        return "group";
    }

    @GetMapping("/groupList")
    public String getList(Model model) {
        List<Group> groups = groupRepository.findAll();
        model.addAttribute("groups", groups);
        return "classList";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
//        Group group = groupRepository.findById(id).get();
//        if (group.getUsers().size() != 0 || group.getSubjects().size() != 0) {
//            model.addAttribute("group", group);
//            return "error";
//        }
        groupRepository.deleteById(id);
        List<Group>groupList = groupRepository.findAll();
        String text = "Usunieto klase";
        model.addAttribute("msg", text);
        model.addAttribute("groups", groupList);
        return "classList";
    }


    @ModelAttribute("users")
    List<User> getUserList() {
        return userRepository.findAll();
    }
}
