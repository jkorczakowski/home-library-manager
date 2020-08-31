package ovh.enyo.hlm.repository;

import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import ovh.enyo.hlm.controller.AuthorController;
import ovh.enyo.hlm.model.Author;

import java.util.logging.Logger;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
