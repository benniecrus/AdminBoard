package group.services;

import group.model.Language;

import java.util.List;

public interface LanguageService {
	List<Language> findAll();
	Language findById(Integer id);
//	Language findByName(String name);
}
