package ovh.enyo.hlm.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    @Column(name = "name")
    @NotBlank(message = "ERROR: name cannot be empty!")
    private String name;
//    @Column(name = "surname")
    @NotBlank(message = "ERROR: surname cannot be empty!")
    private String surname;
    private boolean created;
    @Embedded
    private Audit audit = new Audit();

    public Author() { }

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
    }
}
