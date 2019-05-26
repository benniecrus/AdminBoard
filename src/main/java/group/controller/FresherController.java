package group.controller;

import group.model.Batch;
import group.model.Course;
import group.model.Fresher;
import group.services.BatchService;
import group.services.FresherService;
import group.utils.FileUtils;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

@Controller
@SessionAttributes({ "freshers", "fresher" })
public class FresherController {

	@Autowired
	FresherService fresherService;

	@Autowired
	BatchService batchService;

	@Autowired
	FileUtils fileUtils;

	/**
	 * 
	 * @param modelMap
	 *            send attribute.
	 * @return page.
	 */
	@RequestMapping(value = { "cancel" }, method = RequestMethod.GET)
	String showFresherList(ModelMap modelMap) {
		List<Fresher> list = fresherService.findAll();
		modelMap.addAttribute("freshers", list);
		modelMap.addAttribute("fresher", new Fresher());
		return "fresher-list";
	}
	
	@RequestMapping(value="import-fresher")
	String importFresher(ModelMap modelMap,@RequestParam(value="fresherFile", defaultValue="null")MultipartFile fresherFile, @RequestParam(value="batchId", defaultValue="0")int batchId ) throws NumberFormatException, IllegalStateException, IOException{
		List<Fresher> freshers;
		Batch batch = null;
		if(batchId != 0){
		batch = batchService.findById(batchId);
		}else{
			modelMap.addAttribute("batch", batch);
		}
		if(!fresherFile.isEmpty()){
		freshers = fileUtils.getAllStudent(fileUtils.convert(fresherFile), batch);
		fresherService.saveList(freshers);
		}
		return "redirect:initFresherList?batchId="+batchId;
	}

	/**
	 * 
	 * @param fresherId
	 *            property from fresher-detail form.
	 * @param name
	 *            property from fresher-detail form.
	 * @param location
	 *            property from fresher-detail form.
	 * @param birthday
	 *            property from fresher-detail form.
	 * @param batchId
	 *            property from fresher-detail form.
	 * @param active
	 *            property from fresher-detail form.
	 * @param modelMap
	 *            send attribute.
	 * @return page.
	 */
	@RequestMapping(value = "save-fresher", method = RequestMethod.POST)
	public String saveFresher(
			@RequestParam(defaultValue = "0") Integer fresherId,
			@RequestParam String name, @RequestParam String location,
			@RequestParam String birthday, @RequestParam Integer batchId,
			@RequestParam(defaultValue = "false") Boolean active,
			ModelMap modelMap) {
		Batch batch = batchService.findById(batchId);
		Fresher fresher = null;
		if (fresherId == 0) {
			fresher = new Fresher(name, location, birthday, active, batch);
		}
		fresher = new Fresher(fresherId, name, location, birthday, active,
				batch);
		Fresher fresher2 = save(fresher, modelMap);
		if (fresher2 != null) {
			return "fresher-list";
		}
		return "fresher-detai";
	}

	/**
	 * 
	 * @param fresher
	 *            attribute.
	 * @param modelMap
	 *            send attribute.
	 * @return a fresher.
	 */
	private Fresher save(Fresher fresher, ModelMap modelMap) {
		Fresher fresher2 = fresherService.save(fresher);
		if (fresher2 != null) {
			List<Fresher> list = fresherService.findAll();
			modelMap.addAttribute("freshers", list);
			modelMap.addAttribute("fresher", new Fresher());
			return fresher2;
		}
		return null;
	}
}
