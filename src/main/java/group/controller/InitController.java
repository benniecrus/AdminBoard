package group.controller;

import group.model.Batch;
import group.model.Course;
import group.model.Fresher;
import group.model.Language;
import group.model.Level;
import group.model.Role;
import group.model.Users;
import group.services.BatchService;
import group.services.CourseService;
import group.services.FresherService;
import group.services.LanguageService;
import group.services.LevelService;
import group.services.RoleService;
import group.services.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InitController {

	@Autowired
	FresherService fresherService;

	@Autowired
	UserService userService;

	@Autowired
	RoleService roleService;

	@Autowired
	BatchService batchService;

	@Autowired
	CourseService courseService;

	@Autowired
	LanguageService languageService;

	@Autowired
	LevelService levelService;

	@RequestMapping(value = "initFresherList")
	public String initFresherList(ModelMap modelMap, @RequestParam(value="batchId", defaultValue="0") int batchId) {
		List<Fresher> freshers;
		if(batchId!=0){
			Batch batch = batchService.findById(batchId);
			modelMap.addAttribute("batch", batch);
			freshers = batch.getFresherList();
		}else{
		freshers = fresherService.findAll();
		}
		modelMap.addAttribute("freshers", freshers);
		return "fresher-list";
	}
	
	/**
	 * 
	 * @param modelMap
	 *            send attribute.
	 * @return course-list page.
	 */
	@RequestMapping(value = "initCourseList")
	public String initCourseList(ModelMap modelMap, @RequestParam(value="batchId", defaultValue="0") int batchId) {
		List<Course> courses;
		if(batchId!=0){
			System.out.println("inside");
			Batch batch = batchService.findById(batchId);
			modelMap.addAttribute("batch", batch);
			courses = batch.getCourseList();
			modelMap.addAttribute("courses", courses);
		}else{
		courses = courseService.findAll();
		modelMap.addAttribute("courses", courses);
		}
		return "course-list";
	}
	
	/**
	 * 
	 * @param modelMap
	 *            send attribute.
	 * @param fresherId
	 *            property from fresher-list page.
	 * @return page.
	 */
	@RequestMapping(value = { "add-fresher", "edit-fresher" }, method = RequestMethod.GET)
	public String showAddFresher(ModelMap modelMap,
			@RequestParam(defaultValue = "0") Integer fresherId) {
		Fresher fresher = fresherService.findById(fresherId);
		if (fresherId != 0) {
			modelMap.addAttribute("fresher", fresher);
		} else {
			modelMap.addAttribute("fresher", new Fresher());
		}
		List<Batch> list = batchService.findAll();
		modelMap.addAttribute("batchs", list);
		return "fresher-detail";
	}

	/**
	 * 
	 * @param modelMap
	 *            send attribute.
	 * @return page.
	 */
	@RequestMapping(value = "initAddUser")
	public String initAddUser(ModelMap modelMap) {

		List<Role> roles = roleService.findAll();
		modelMap.addAttribute("roles", roles);

		return "user-detail";
	}

	/**
	 * 
	 * @param modelMap
	 *            send attribute.
	 * @param userId
	 *            property from user list page.
	 * @return user-detail page.
	 */
	@RequestMapping(value = "initEditProfile")
	public String initEditProfile(ModelMap modelMap,
			@RequestParam(value = "userId") int userId) {
		Users user = userService.findById(userId);
		List<Role> roles = roleService.findAll();
		modelMap.addAttribute("roles", roles);
		modelMap.addAttribute("user", user);
		return "user-detail";
	}

	/**
	 * 
	 * @return home page.
	 */
	@RequestMapping(value = "home")
	public String initHomepage(ModelMap modelMap) {
		List<Language> languages = languageService.findAll();
		List<Batch> batchs = batchService.findAll();
		List<Fresher> freshers = fresherService.findAll();
		List<Course> courses = courseService.findAll();
		
		modelMap.addAttribute("batchSize", batchs.size());
		modelMap.addAttribute("courseSize", courses.size());
		modelMap.addAttribute("fresherSize", freshers.size());
		modelMap.addAttribute("languageSize", languages.size());
		return "home";
	}

	/**
	 * 
	 * @param modelMap
	 *            send attribute.
	 * @return user-list page.
	 */
	@RequestMapping(value = "initUserList")
	public String initUserList(ModelMap modelMap) {
		List<Users> users = userService.findAll();

		modelMap.addAttribute("users", users);

		return "user-list";
	}

	/**
	 * 
	 * @param modelMap
	 *            send attribute.
	 * @return page.
	 */
	@RequestMapping(value = "initBatchList")
	public String initBatchList(ModelMap modelMap) {
		List<Batch> batches = batchService.findAll();
		modelMap.addAttribute("batches", batches);
		return "batch-list";
	}

	/**
	 * 
	 * @param modelMap
	 *            send attribute.
	 * @param batchId
	 *            property from batch list page.
	 * @return batch-detail page.
	 */
	@RequestMapping(value = "initBatchDetail")
	public String initBatchDetail(ModelMap modelMap,
			@RequestParam(value = "batchId", defaultValue = "0") int batchId) {

		List<Language> languages = languageService.findAll();
		modelMap.addAttribute("languages", languages);
		if (batchId != 0) {
			Batch batch = batchService.findById(batchId);
			modelMap.addAttribute("batch", batch);
		}
		return "batch-detail";
	}

	/**
	 * 
	 * @param modelMap
	 *            send attribute.
	 * @param courseId
	 *            property from batch list page.
	 * @return course-detail page.
	 */
	@RequestMapping(value = { "initAddCourse", "edit-course" })
	public String initAddCourse(ModelMap modelMap,
			@RequestParam(defaultValue = "0") Integer courseId) {
		List<Language> languages = languageService.findAll();
		List<Level> levels = levelService.findAll();
		if (courseId != 0) {
			Course course = courseService.findById(courseId);
			modelMap.addAttribute("course", course);
		}
		modelMap.addAttribute("languages", languages);
		modelMap.addAttribute("levels", levels);
		return "course-detail";
	}

	/**
	 * 
	 * @param modelMap
	 *            send attribute.
	 * @param courseId
	 *            property from batch list page.
	 * @return batch-config page.
	 */
	@RequestMapping(value = "initBatchConfig")
	public String initBatchConfig(ModelMap modelMap,
			@RequestParam(value = "batchId", defaultValue = "0") int batchId) {

		Batch batch = batchService.findById(batchId);
		modelMap.addAttribute("batch", batch);
		modelMap.addAttribute("numberFresher", batch.getFresherList().size());
		modelMap.addAttribute("numberCourse", batch.getCourseList().size());
		return "batch-config";
		
	}

	/**
	 * 
	 * @param modelMap
	 *            send attribute.
	 * @param courseId
	 *            property from batch list page.
	 * @return batch-fresher page.
	 */
	@RequestMapping(value = "initBatchFresher")
	public String initBatchFresher(ModelMap modelMap,
			@RequestParam(value = "batchId", defaultValue = "0") int batchId) {

		Batch batch = batchService.findById(batchId);
		modelMap.addAttribute("batch", batch);
		List<Fresher> freshers = batch.getFresherList();
		modelMap.addAttribute("freshers", freshers);

		return "batch-fresher";
	}

	/**
	 * 
	 * @param modelMap
	 *            send attribute.
	 * @param courseId
	 *            property from batch list page.
	 * @return batch-fresher page.
	 */
	@RequestMapping(value = "initBatchCourse")
	public String initBatchCourse(ModelMap modelMap,
			@RequestParam(value = "batchId", defaultValue = "0") int batchId) {

		Batch batch = batchService.findById(batchId);
		modelMap.addAttribute("batch", batch);
		List<Course> courses = batch.getCourseList();
		modelMap.addAttribute("courses", courses);

		return "batch-fresher";
	}
}
