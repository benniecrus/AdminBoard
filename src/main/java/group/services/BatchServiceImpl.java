package group.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group.model.Batch;
import group.model.Course;
import group.repositories.BatchRepository;

@Service("batchService")
public class BatchServiceImpl implements BatchService {

	@Autowired
	BatchRepository batchRepository;

	@Override
	public List<Batch> findAll() {
		return batchRepository.findAll();
	}

	@Override
	public Batch findById(Integer id) {
		return batchRepository.findOne(id);
	}

	@Override
	public Batch save(Batch batch) {
		return batchRepository.save(batch);
	}

	@Override
	public Batch saveCourse(Batch batch, Course course) {
		if(batch.getCourseList() == null){
			List<Course> courses = new ArrayList<>();
			courses.add(course);
			batch.setCourseList(courses);
		}else{
		batch.getCourseList().add(course);
		}
		return batchRepository.save(batch);
	}

	@Override
	public Batch saveCourse(Batch batch, List<Course> courses) {
		batch.setCourseList(courses);
		return batchRepository.save(batch); 
	}

}
