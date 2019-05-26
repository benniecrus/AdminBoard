package group.services;

import group.model.Level;

import java.util.List;

public interface LevelService {
	List<Level> findAll();
	Level findById(Integer id);
}
