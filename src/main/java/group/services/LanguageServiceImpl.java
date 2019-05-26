package group.services;

import group.model.Language;
import group.repositories.LanguageRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("languageService")
public class LanguageServiceImpl implements LanguageService{

	@Autowired
	LanguageRepository languageRepository;
	@Override
	public List<Language> findAll() {
		return languageRepository.findAll();
	}

	@Override
	public Language findById(Integer id) {
		return languageRepository.findOne(id);
	}
//
//	@Override
//	public Language findByName(String name) {
//		return null;
//	}


}
