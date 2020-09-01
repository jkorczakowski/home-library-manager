package ovh.enyo.hlm.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ovh.enyo.hlm.model.Author;
import ovh.enyo.hlm.model.AuthorGroup;
import ovh.enyo.hlm.model.projection.GroupAReadModel;
import ovh.enyo.hlm.model.projection.GroupAWriteModel;
import ovh.enyo.hlm.repository.AuthorGroupRepository;
import ovh.enyo.hlm.repository.AuthorRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
class AuthorGroupService {
    private AuthorGroupRepository repository;
    private AuthorRepository authorRepository;

    public AuthorGroupService(@Qualifier("authorGroupRepository") AuthorGroupRepository repository, AuthorRepository authorRepository) {
        this.repository = repository;
        this.authorRepository = authorRepository;
    }

    public GroupAReadModel createGroup(GroupAWriteModel source) {
        AuthorGroup result = repository.save(source.toGroup());
        return new GroupAReadModel(result);
    }

    public List<GroupAReadModel> readAll() {
        return repository.findAll().stream()
                .map(GroupAReadModel::new)
                .collect(Collectors.toList());
    }

    public void toggleGroup(int groupId) {
        if (authorRepository.existsByCreatedIsFalseAndGroup_Id(groupId)) {
            throw new IllegalStateException("Group has uncreated tasks.");
        }
        AuthorGroup result = repository.findById(groupId)
                .orElseThrow(() -> new IllegalArgumentException("Author group with given id not found"));
        result.setCreated(!result.isCreated());
    }
}
