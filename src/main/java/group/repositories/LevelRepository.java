package group.repositories;

import group.model.Level;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("levelrepository")
public interface LevelRepository extends JpaRepository<Level,Integer> {

}
