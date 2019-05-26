package group.repositories;

import group.model.Fresher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("fresherRepository")
public interface FresherRepository extends JpaRepository<Fresher, Integer> {
}
