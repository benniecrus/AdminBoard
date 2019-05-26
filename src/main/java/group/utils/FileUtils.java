package group.utils;

import group.model.Batch;
import group.model.Course;
import group.model.Fresher;
import group.model.Language;
import group.model.Level;
import group.services.LanguageService;
import group.services.LevelService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVReader;

public class FileUtils {
	@Autowired
	LanguageService languageService;
	
	@Autowired
	LevelService levelService;
	
	
	/**
	   * 
	   * @param file
	   *          input file.
	   * @return all student in the file.
	   * @throws NumberFormatException
	   *           throw exception when number format is wrong.
	   * @throws IOException
	   *           throw exception when file error.
	   */
	  public List<Fresher> getAllStudent(File file, Batch batch)
	      throws NumberFormatException, IOException {
	    CSVReader csvReader = null;
	    try {
	      List<Fresher> freshers = new ArrayList<Fresher>();
	      csvReader = new CSVReader(new FileReader(file));
	      String[] line;
	      while ((line = csvReader.readNext()) != null) {
	    	  freshers.add(new Fresher(line[0], line[1], line[2], true, batch));
	      }
	      return freshers;
	    } finally {
	      if (csvReader != null) {
	        csvReader.close();
	      }
	    }
	  }
	  
	  public List<Course> getAllCourse(File file)
		      throws NumberFormatException, IOException {
		    CSVReader csvReader = null;
		    try {
		      List<Course> courses = new ArrayList<Course>();
		      csvReader = new CSVReader(new FileReader(file));
		      String[] line;
		      while ((line = csvReader.readNext()) != null) {
		    	  Language language = languageService.findById(Integer.parseInt(line[3]));
		    	  Level level = levelService.findById(Integer.parseInt(line[4]));
		    	  courses.add(new Course(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]), level, language));
		      }
		      return courses;
		    } finally {
		      if (csvReader != null) {
		        csvReader.close();
		      }
		    }
		  }
	  
	  public File convert(MultipartFile file) throws IllegalStateException, IOException{
		  File newFile = new File("E:/java/workspace/AdminBoard_G2/src/main/resources/"+file.getOriginalFilename());
		  System.out.println(file.getOriginalFilename());
		  file.transferTo(newFile);
//		  newFile.createNewFile(); 
//		    FileOutputStream fos = new FileOutputStream(newFile); 
//		    fos.write(file.getBytes());
//		    fos.close(); 
		  return newFile;
	  }
}
