package article.com.Models;

import javax.persistence.*;

@Entity
public class PendingArticle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    Article article;

    @Column(name = "newTitle")
    String newTitle;

    @Column(name = "newText")
    String newText;

    @Column(name = "status")
    Status status;

    public PendingArticle() {
    }

    public PendingArticle(Article article, String newTitle, String newText, Status status) {
        this.article = article;
        this.newTitle = newTitle;
        this.newText = newText;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public String getNewTitle() {
        return newTitle;
    }

    public void setNewTitle(String newTitle) {
        this.newTitle = newTitle;
    }

    public String getNewText() {
        return newText;
    }

    public void setNewText(String newText) {
        this.newText = newText;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
