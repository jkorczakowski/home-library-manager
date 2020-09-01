package ovh.enyo.hlm.model.projection;

import ovh.enyo.hlm.model.AuthorGroup;

import java.util.Set;
import java.util.stream.Collectors;

public class GroupAWriteModel {
    private Set<GroupAuthorWriteModel> authors;

    public Set<GroupAuthorWriteModel> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<GroupAuthorWriteModel> authors) {
        this.authors = authors;
    }

    public AuthorGroup toGroup() {
        var result = new AuthorGroup();
        result.setAuthors(authors.stream()
                .map(GroupAuthorWriteModel::toAuthor)
                .collect(Collectors.toSet()));
        return result;
    }
}
