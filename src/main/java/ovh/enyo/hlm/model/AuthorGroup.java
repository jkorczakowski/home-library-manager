package ovh.enyo.hlm.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "author_groups")
public class AuthorGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean created;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
    private Set<Author> authors;


    public AuthorGroup() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCreated(boolean created) {
        this.created = created;
    }

    public boolean isCreated() {
        return created;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
}
