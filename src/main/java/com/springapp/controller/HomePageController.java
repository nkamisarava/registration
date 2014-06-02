package com.springapp.controller;

import com.springapp.domain.User;
import com.springapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomePageController {

    @Autowired
    UserService userService;

    @RequestMapping("/register")
    public ModelAndView registerUser(@ModelAttribute User user) {

        List<String> genderList = new ArrayList<String>();
        genderList.add("male");
        genderList.add("female");

        List<String> cityList = new ArrayList<String>();
        cityList.add("Minsk");
        cityList.add("London");
        cityList.add("Vienna");

        Map<String, List> map = new HashMap<String, List>();
        map.put("genderList", genderList);
        map.put("cityList", cityList);
        return new ModelAndView("register", "map", map);
    }

    @RequestMapping("/insert")
    public String insertData(@ModelAttribute User user) {
        if (user !=null) userService.insertData(user);
        return "redirect:/getList";
    }

    @RequestMapping("/getList")
    public ModelAndView getUserList() {
        List<User> userList = userService.getUserList();
        return new ModelAndView("userList", "userList", userList);
    }

    @RequestMapping("/edit")
    public ModelAndView editUser(@RequestParam String id, @ModelAttribute User user) {
        user = userService.getUser(id);

        List<String> genderList = new ArrayList<String>();
        genderList.add("male");
        genderList.add("female");

        List<String> cityList = new ArrayList<String>();
        cityList.add("Minsk");
        cityList.add("London");
        cityList.add("Vienna");

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("genderList", genderList);
        map.put("cityList", cityList);
        map.put("user", user);

        return new ModelAndView("edit", "map", map);
    }

    @RequestMapping("/update")
    public String updateUser(@ModelAttribute User user) {
        userService.updateData(user);
        return "redirect:/getList";
    }

    @RequestMapping("/delete")
    public String deleteUser(@RequestParam String id) {
        System.out.println("id="+id);
        userService.deleteData(id);
        return "redirect:/getList";
    }
}
