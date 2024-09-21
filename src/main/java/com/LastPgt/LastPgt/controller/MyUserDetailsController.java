package com.LastPgt.LastPgt.controller;

import com.LastPgt.LastPgt.model.MyUserDetails;
import com.LastPgt.LastPgt.model.User;
import com.LastPgt.LastPgt.service.myUserDetailsService.MyUserDetailsService;
import com.LastPgt.LastPgt.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/userdetails")
public class MyUserDetailsController {
    private final MyUserDetailsService myUserDetailsService;
    private final UserService userService;

    @Autowired
    public MyUserDetailsController(MyUserDetailsService myUserDetailsService, UserService userService) {
        this.myUserDetailsService = myUserDetailsService;
        this.userService = userService;
    }

    @GetMapping
    public String listUserDetails(Model model) {
        model.addAttribute("userdetails", myUserDetailsService.findAllUserDetails());
        return "userdetails/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("userDetails", new MyUserDetails());

        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);

        return "userdetails/create";
    }

    @PostMapping("/create")
    public String createUserDetails(@ModelAttribute("userDetails") MyUserDetails userDetails) {
        myUserDetailsService.saveUserDetails(userDetails);
        return "redirect:/userdetails";
    }


    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Optional<MyUserDetails> userDetails = myUserDetailsService.findUserDetailsById(id);
        userDetails.ifPresent(value -> model.addAttribute("userDetails", value));

        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);

        return "userdetails/edit";
    }

    @PostMapping("/update/{id}")
    public String updateUserDetails(@PathVariable("id") Long id, @ModelAttribute("userDetails") MyUserDetails userDetails) {
        userDetails.setUserDetailsId(id);
        myUserDetailsService.saveUserDetails(userDetails);
        return "redirect:/userdetails";
    }

    @GetMapping("/delete/{id}")
    public String deleteUserDetails(@PathVariable("id") Long id) {
        myUserDetailsService.deleteUserDetails(id);
        return "redirect:/userdetails";
    }
}
