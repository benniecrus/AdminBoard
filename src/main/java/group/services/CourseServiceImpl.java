package group.services;

import group.model.Course;
import group.repositories.CourseRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("courseService")
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseRepository courseRepository;

	@Override
	public List<Course> findAll() {
		return courseRepository.findAll();
	}

	@Override
	public Course findById(Integer id) {
		return courseRepository.findOne(id);
	}

	@Override
	public Course save(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public List<Course> saveList(List<Course> list) {
		List<Course> courses = list;
		for (Course course : courses) {
			save(course);
		}
		return courses;
	}

}
