package article.com.Models.UserTypes;


import article.com.Models.BookTypes.Book;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    Long id;

    @Column(name = "username")
    String username;

    @Column(name = "email")
    String email;

    @Column(name = "password")
    String password;

    @Column(name = "create_time")
    Timestamp createTime;

    @ManyToMany( fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    Set<Book> books = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    Set<Role> roles = new HashSet<>();
}
