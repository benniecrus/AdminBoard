package group.repositories;

import group.model.Language;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("langugeRepository")
public interface LanguageRepository extends JpaRepository<Language, Integer> {

}
