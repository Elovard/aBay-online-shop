package by.tms.storeproject.controller;

import by.tms.storeproject.entity.User;
import by.tms.storeproject.entity.UserRegModel;
import by.tms.storeproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Logger;

@Controller
@RequestMapping(path = "/user")
public class RegAndAuthController {

    @Autowired
    private UserService userService;

    Logger log = Logger.getLogger(RegAndAuthController.class.getName());

    @GetMapping(path = "/reg")
    public ModelAndView getRegPage(ModelAndView modelAndView){
        modelAndView.addObject("newUser", new UserRegModel());
        log.info("invoked get method of reg page");
        modelAndView.setViewName("reg");
        return modelAndView;
    }

    @PostMapping(path = "/reg")
    public ModelAndView postRegPage(@ModelAttribute("newUser")UserRegModel userRegModel, ModelAndView modelAndView){
        User user = new User();
        user.setUsername(userRegModel.getUsername());
        user.setPassword(userRegModel.getPassword());
        user.setMobilePhone(userRegModel.getMobilePhone());
        userService.save(user);
        modelAndView.setViewName("redirect:/user/auth");
        log.info("user " + user.getUsername() + " has been created - postReg");
        return modelAndView;

    }

    @GetMapping(path = "/auth")
    public ModelAndView getAuthPage(ModelAndView modelAndView){
        log.info("invoked get method of auth page");
        modelAndView.setViewName("auth");
        return modelAndView;
    }
}
