package ovh.enyo.hlm.model.projection;

import ovh.enyo.hlm.model.AuthorGroup;

import java.util.Set;
import java.util.stream.Collectors;
/*
    DTO probably to delete, not needed?
 */
public class GroupAReadModel {
    private Set<GroupAuthorReadModel> authors;

    public GroupAReadModel(AuthorGroup source) {
        authors = source.getAuthors().stream()
                .map(GroupAuthorReadModel::new)
                .collect(Collectors.toSet());
    }

    public Set<GroupAuthorReadModel> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<GroupAuthorReadModel> authors) {
        this.authors = authors;

    }
}
