package article.com.Models.BookTypes;


import org.hibernate.type.descriptor.sql.LongVarcharTypeDescriptor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.sql.Types.*;
import java.time.Year;
import java.util.HashSet;
import java.util.Set;
import java.sql.Types;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    Long id;

    @Column(name = "title")
    String title;

    @Column(name = "text", columnDefinition = "MEDIUMTEXT")
    String text;

    @Column(name = "create_year")
    Timestamp createYear;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    Set<Genre> genres = new HashSet<>();


}
