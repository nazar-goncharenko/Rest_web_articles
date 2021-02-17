package article.com.Controllers;


import article.com.Models.User;
import article.com.Reposetories.UserRepository;
import article.com.Services.ArticleService;
import article.com.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class MainController {

    @Autowired
    UserService userService;

    @Autowired
    ArticleService articleService;

    @GetMapping("/")
    Map <String, Object> index(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("hello", "Hello world");
        map.put("creator", "Nazar Honcharenko");
        map.put("articles", articleService.getAll());
        return map;
    }

    @GetMapping("/foo")
    String foo(){
        return "Foo";
    }

//    @GetMapping("/error")
//    String bb(){
//        return "bb";
//    }

    @GetMapping("/users")
    List<User> getAllUsers(){
        return userService.getAll();
    }

    @PostMapping("/users")
    User registerUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PostMapping("/moders")
    User registerModer(@RequestBody User user){
        return userService.createModer(user);
    }
}
