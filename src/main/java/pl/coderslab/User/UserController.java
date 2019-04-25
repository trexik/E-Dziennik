package pl.coderslab.User;

import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Group.Group;
import pl.coderslab.Repositories.GroupRepository;
import pl.coderslab.Repositories.UserRepository;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    GroupRepository groupRepository;

    @ModelAttribute("groups")
    public List<Group> groups() {
        return groupRepository.findAll();
    }

    @GetMapping("/list")
    public String userList(Model model) {
        List<User> users = userRepository.findAll(Sort.by("surname"));
        model.addAttribute("users", users);
        return "userList";
    }


    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("user", new User());
        return "user";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute @Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "redirect:add";
        }
        userRepository.save(user);
        List<User> users = userRepository.findAll(Sort.by("surname"));
        model.addAttribute("users", users);
        return "redirect:add";
    }


    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        Optional<User> user = userRepository.findById(id);
        model.addAttribute("user", user);
        return "userEdit";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute @Valid User user, Model model) {
        userRepository.save(user);
        List<User>userList = userRepository.findAll(Sort.by("surname"));
        model.addAttribute("users", userList);
        return "userList";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        userRepository.deleteById(id);
        List<User>userList = userRepository.findAll(Sort.by("surname"));
        String text = "Usunięto ucznia";
        model.addAttribute("msg", text);
        model.addAttribute("users", userList);
        return "userList";
    }

}
