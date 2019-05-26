package group.services;

import java.util.List;

import org.springframework.stereotype.Service;

import group.model.Course;

@Service("courseService")
public interface CourseService{
//  List<Course> findByBatchId(int id);

	List<Course> findAll();
	
	Course findById(Integer id);
	
	Course save(Course course);
	
	List<Course> saveList(List<Course> list);
}
