package article.com.Services;


import article.com.Models.Article;
import article.com.Models.PendingArticle;
import article.com.Models.Status;
import article.com.Reposetories.PendingArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PArticleService {

    @Autowired
    ArticleService articleService;

    @Autowired
    PendingArticleRepository PArticleRepository;

    public List <PendingArticle> getAll(){
        return PArticleRepository.findAll();
    }

    public List <PendingArticle> getAllNotConfirmed(){
        return PArticleRepository.getAllByStatusIs(Status.PENDING);
    }


    public PendingArticle getById(Long id){
        if (PArticleRepository.findById(id).isPresent()){
            return PArticleRepository.findById(id).get();
        }
        return null;
    }

    public boolean delete(Long id){
        if(PArticleRepository.findById(id).isPresent()){
            PArticleRepository.delete(PArticleRepository.findById(id).get());
            return true;
        }
        return false;
    }

    public Article confirm(Long id){
        if ( PArticleRepository.findById(id).isPresent()) {
            PendingArticle pendingArticle = PArticleRepository.findById(id).get();
            Article article = articleService.getById(pendingArticle.getArticle().getId());

            article.setTitle(pendingArticle.getNewTitle());
            article.setText(pendingArticle.getNewText());

            pendingArticle.setStatus(Status.DONE);
            PArticleRepository.save(pendingArticle);
            return articleService.save(article);
        }
        return null;
    }
}
