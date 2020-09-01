package ovh.enyo.hlm.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "ERROR: name cannot be empty!")
    private String name;
    @NotBlank(message = "ERROR: surname cannot be empty!")
    private String surname;
    private boolean created;
    @Embedded
    private Audit audit = new Audit();
    @ManyToOne
    @JoinColumn(name = "author_group_id")
    private AuthorGroup group;

    Author() { }

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setCreated(boolean created) {
        this.created = created;
    }

    public boolean isCreated() {
        return created;
    }

    public void updateFrom(Author source) {
        name = source.name;
        surname = source.surname;
        group = source.group;
    }

    public AuthorGroup getGroup() {
        return group;
    }

}
