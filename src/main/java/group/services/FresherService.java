package group.services;

import group.model.Fresher;

import java.util.List;

public interface FresherService {
	List<Fresher> findAll();
	
	Fresher findById(Integer fresherId);

	Fresher save(Fresher fresher);
	
	List<Fresher> saveList(List<Fresher> freshers);
}
