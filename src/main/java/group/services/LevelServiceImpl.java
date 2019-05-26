package group.services;

import group.model.Level;
import group.repositories.LevelRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("levelService")
public class LevelServiceImpl implements LevelService{

	@Autowired
	LevelRepository levelRepository;
	
	@Override
	public List<Level> findAll() {
		return levelRepository.findAll();
	}

	@Override
	public Level findById(Integer id) {
		return levelRepository.findOne(id);
	}

	

}
