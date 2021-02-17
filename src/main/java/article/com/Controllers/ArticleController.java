package article.com.Controllers;


import article.com.Models.Article;
import article.com.Reposetories.ArticleRepository;
import article.com.Services.ArticleService;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping
    List<Article> getAllArticles() {
        return articleService.getAll();
    }

    @GetMapping("/{id}")
    Article getArticleById(@PathVariable Long id) {
        return articleService.getById(id);
    }

    @PostMapping
    Article createArticle(@RequestBody Article article) {
        articleService.save(article);
        return article;
    }

    @PutMapping("/{id}")
    Article updateArticle(@PathVariable Long id,@RequestBody Article article){
        article.setId(id);
        return articleService.update(article);
    }

    @DeleteMapping("/{id}")
    String deleteArticle(@PathVariable Long id){
        if (articleService.delete(id)) {
            return "Deleted";
        }
        else return "Something went wrong";
    }


}
