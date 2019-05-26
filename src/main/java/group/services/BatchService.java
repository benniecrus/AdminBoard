package group.services;

import java.util.List;

import group.model.Batch;
import group.model.Course;

public interface BatchService{
	List<Batch> findAll();
	Batch findById(Integer id);
	Batch save(Batch batch);
	Batch saveCourse(Batch batch, Course course);
	Batch saveCourse(Batch batch, List<Course> courses);
}
