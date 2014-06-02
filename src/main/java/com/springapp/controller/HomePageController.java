package com.springapp.controller;

import com.springapp.domain.User;
import com.springapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomePageController {

    @Autowired
    UserService userService;

    @RequestMapping("/register")
    public ModelAndView registerUser(@ModelAttribute User user) {
        List<String> genderList = new ArrayList<String>();
        genderList.add("male");
        genderList.add("female");
    }
}
