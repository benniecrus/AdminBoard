package group.controller;

import group.model.Batch;
import group.model.Course;
import group.model.Language;
import group.model.Level;
import group.services.BatchService;
import group.services.CourseService;
import group.services.LanguageService;
import group.services.LevelService;
import group.utils.FileUtils;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class CourseController {

	@Autowired
	CourseService courseService;

	@Autowired
	BatchService batchService;
	
	@Autowired
	LanguageService languageService;

	@Autowired
	LevelService levelService;
	
	@Autowired
	FileUtils fileUtils;

	@RequestMapping(value = "save-course", method = RequestMethod.POST)
	public String saveCourse(
			@RequestParam(defaultValue = "0") Integer courseId,
			@RequestParam String name,
			@RequestParam Integer learningDuration,
			@RequestParam Integer numberOfLecture,
			@RequestParam Integer levelId, @RequestParam Integer languageId,
			@RequestParam(value="batchId", defaultValue="0") Integer batchId,
			ModelMap modelMap) {
		Course course = null;
		Batch batch = null;
		Language language = languageService.findById(languageId);
		Level level = levelService.findById(levelId);
		
		if (courseId != 0) {
			course = new Course(courseId, name, learningDuration,
					numberOfLecture, level, language);
		}else
			course = new Course(name, learningDuration, numberOfLecture,
					level, language);
		course = courseService.save(course);
		if(batchId != 0){
			batch = batchService.findById(batchId);
			batchService.saveCourse(batch, course);
		}
		
		if (course != null) {
			return "course-list";
		}
		
		return "redirect:initCourseList";
	}
	
	@RequestMapping(value = "import-course")
	public String importCourse(@RequestParam MultipartFile courseFile,@RequestParam(value="batchId", defaultValue="0") Integer batchId, ModelMap modelMap) throws NumberFormatException, IllegalStateException, IOException{
		List<Course> courses = fileUtils.getAllCourse(fileUtils.convert(courseFile));
		System.out.println(courses.size());
		courses = courseService.saveList(courses);
		System.out.println(courses.size());
		Batch batch = null;
		if(batchId != 0){
			batch = batchService.findById(batchId);
			batchService.saveCourse(batch, courses);
			return "redirect:initCourseList?batchId="+batchId;
		}
		return "redirect:initCourseList";
	}

}
