package article.com.Controllers;


import article.com.Models.Article;
import article.com.Models.PendingArticle;
import article.com.Services.PArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/moderator/particles")
public class PArticleController {

    @Autowired
    PArticleService pArticleService;

    @GetMapping
    List <PendingArticle> getAllNotConfirmedPendingArticles(){
        return pArticleService.getAllNotConfirmed();
    }

    @GetMapping("/{id}")
    PendingArticle getPendingArticleById(@PathVariable Long id){
        return pArticleService.getById(id);
    }

    @PutMapping("/{id}")
    Article confirmChanges(@PathVariable Long id){
        return pArticleService.confirm(id);
    }

    @DeleteMapping("/{id}")
    String deletePendingArticle(@PathVariable Long id){
        if (pArticleService.delete(id)){
            return "Deleted";
        }
        return "Something went wrong";
    }

}
