package article.com.Controllers;


import article.com.Models.UserTypes.User;
import article.com.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@RestController
public class MainController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> index(){
        return userService.getAll();
    }

    @GetMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }

}
