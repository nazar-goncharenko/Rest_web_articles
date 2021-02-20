package article.com.Models.UserTypes;


import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "description")
    String description;
}
