package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import web.service.UserService;


@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/")
    public ModelAndView printUser(ModelAndView modelAndView) {
        modelAndView.addObject("userList", userService.findAll());
        modelAndView.setViewName("allUser");
        return modelAndView;
    }

    @GetMapping(value = "/newUserForm")
    public String addUserForm(@ModelAttribute("user") User user) {
        return "newUser";
    }

    @GetMapping(value = "/updateUserForm")
    public String updateForm(@RequestParam(value = "id", required = false) Long id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        return "update";
    }

    @PostMapping(value = "/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/";
    }

    @PostMapping(value = "/update")
    public String updateUser(@ModelAttribute("user") User user){
        userService.update(user);
        return "redirect:/";
    }

    @GetMapping(value = "/delete")
    public String delete(@RequestParam(value = "id") Long id) {
        userService.delete(id);
        return "redirect:/";
    }
}
