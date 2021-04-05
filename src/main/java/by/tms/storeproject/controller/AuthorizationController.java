package by.tms.storeproject.controller;

import by.tms.storeproject.entity.User;
import by.tms.storeproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/")
public class AuthorizationController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/reg")
    public ModelAndView getRegPage(ModelAndView modelAndView){
        modelAndView.addObject("newUser", new User());
        modelAndView.setViewName("reg");
        return modelAndView;
    }

    @PostMapping(path = "/reg")
    public ModelAndView postRegPage(@ModelAttribute("newUser") User user, ModelAndView modelAndView){
        userService.saveUser(user);
        modelAndView.setViewName("/login");
        return modelAndView;
    }
}
