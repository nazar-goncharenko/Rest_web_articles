package article.com.Reposetories;

import article.com.Models.Article;
import article.com.Models.PendingArticle;
import article.com.Models.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface PendingArticleRepository extends JpaRepository<PendingArticle, Long> {

    List<PendingArticle> getAllByArticleIs(Article article);

    List<PendingArticle> getAllByStatusIs(Status status);
}
