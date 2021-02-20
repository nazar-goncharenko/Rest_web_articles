package article.com.Models.PublishingTypes;


import article.com.Models.BookTypes.Book;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "publishing_houses")
public class PublishingHouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id")
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "address")
    String address;

    @Column(name = "phone_number")
    String phoneNumber;

    @Column(name = "rating")
    Long rating;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    Set<Book> books = new HashSet<>();
}
