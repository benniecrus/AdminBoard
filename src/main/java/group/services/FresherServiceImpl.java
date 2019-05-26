package group.services;

import group.model.Fresher;
import group.repositories.FresherRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("fresherService")
public class FresherServiceImpl implements FresherService{
	
	@Autowired
	FresherRepository fresherRepository;

	@Override
	public Fresher save(Fresher fresher) {
		return fresherRepository.save(fresher);
	}

	@Override
	public List<Fresher> findAll() {
		return fresherRepository.findAll();
	}

	@Override
	public Fresher findById(Integer fresherId) {
		return fresherRepository.findOne(fresherId);
	}

	@Override
	public List<Fresher> saveList(List<Fresher> freshers) {
		return fresherRepository.save(freshers);
	}


}
