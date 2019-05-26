package group.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import group.model.Course;

@Repository("courseRepository")
public interface CourseRepository extends JpaRepository<Course, Integer> {
}
