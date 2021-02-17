package article.com.Services;

import article.com.Models.Article;
import article.com.Models.PendingArticle;
import article.com.Models.Status;
import article.com.Reposetories.ArticleRepository;
import article.com.Reposetories.PendingArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    PendingArticleRepository PArticleRepository;

    public List<Article> getAll() {
        return articleRepository.findAll();
    }

    public Article getById(Long id) {
        if (articleRepository.findById(id).isPresent()) {
            return articleRepository.findById(id).get();
        }
        return null;
    }

    public Article save(Article article) {
        return articleRepository.save(article);
    }

    public Article update(Article article) {
        if ( articleRepository.findById(article.getId()).isPresent()) {
            PArticleRepository.save(new PendingArticle(articleRepository.findById(article.getId()).get(), article.getTitle(), article.getText(), Status.PENDING));
            return articleRepository.findById(article.getId()).get();
        }
        else return null;
    }


    public boolean delete(Long id) {
        if (articleRepository.findById(id).isPresent()) {
            List<PendingArticle> PArticles = PArticleRepository.getAllByArticleIs(articleRepository.findById(id).get());
            for (PendingArticle var : PArticles
            ) {
                PArticleRepository.delete(var);
            }
            articleRepository.delete(articleRepository.findById(id).get());
            return true;
        }
        else return false;
    }
}
