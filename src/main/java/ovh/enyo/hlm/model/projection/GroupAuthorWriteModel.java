package ovh.enyo.hlm.model.projection;


import ovh.enyo.hlm.model.Author;

public class GroupAuthorWriteModel {
    private String name;
    private String surname;

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

    public Author toAuthor() {
        return new Author(name, surname);
    }
}
