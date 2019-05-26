package group.controller;

import group.model.Batch;
import group.model.Fresher;
import group.model.Language;
import group.services.BatchService;
import group.services.FresherService;
import group.services.LanguageService;
import group.utils.FileUtils;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Transactional
public class BatchController {

	@Autowired
	BatchService batchService;
	
	@Autowired
	FresherService fresherService;

	@Autowired
	LanguageService languageService;
	
	@Autowired
	FileUtils fileUtils;
	
	@RequestMapping(value = "saveBatch")
	public String saveBatch(@RequestParam(defaultValue = "0") int batchId,String batchName,
			String startDate, String endDate,
			@RequestParam(defaultValue = "false") boolean active,
			int languageId,@RequestParam(value="fresherFile", defaultValue="null")MultipartFile fresherFile, ModelMap modelMap) throws NumberFormatException, IllegalStateException, IOException {
		Batch batch;
		Language language = languageService.findById(languageId);
		if(batchId == 0){
		batch = new Batch(batchName, active, startDate, endDate, language);
		}else
			batch = new Batch(batchId, batchName, active, startDate, endDate, language);
		
		batch = batchService.save(batch);
		System.out.println();
		
		if(!fresherFile.isEmpty()){
			List<Fresher> freshers = fileUtils.getAllStudent(fileUtils.convert(fresherFile), batch);
			fresherService.saveList(freshers);
		}
		
		return "redirect:initBatchList";
	}

}
