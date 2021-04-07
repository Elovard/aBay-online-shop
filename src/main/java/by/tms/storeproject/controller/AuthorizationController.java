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
@RequestMapping(path = "/")
public class AuthorizationController {

    @Autowired
    private UserService userService;

    Logger log = Logger.getLogger(AuthorizationController.class.getName());

    @GetMapping(path = "/reg")
    public ModelAndView getRegPage(ModelAndView modelAndView){
        modelAndView.addObject("newUser", new UserRegModel());
        modelAndView.setViewName("reg");
        return modelAndView;
    }

    @PostMapping(path = "/reg")
    public ModelAndView postRegPage(@ModelAttribute("newUser")UserRegModel userRegModel, ModelAndView modelAndView){
        User user = new User ();
        user.setUsername(userRegModel.getUsername());
        user.setPassword(userRegModel.getPassword());
        user.setMobilePhone(userRegModel.getMobilePhone());
        user.setName(userRegModel.getName());
        userService.save(user);
        modelAndView.setViewName("/login");
        log.info("used has been created - postReg");
        return modelAndView;

    }
}
