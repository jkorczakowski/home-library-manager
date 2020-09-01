package ovh.enyo.hlm.model.projection;

import ovh.enyo.hlm.model.Author;

public class GroupAuthorReadModel {
    private String name;
    private String surname;
    private boolean created;

    public GroupAuthorReadModel(Author source) {
        name = source.getName();
        surname = source.getSurname();
        created = source.isCreated();
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

    public boolean isCreated() {
        return created;
    }

    public void setCreated(boolean created) {
        this.created = created;
    }
}
