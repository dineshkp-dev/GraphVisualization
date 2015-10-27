package com.graphvisual.myApp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private ResourceLoader resourceLoader;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate );

		return "home.jsp";
	}

	@RequestMapping(value = "/filerequest", method = RequestMethod.GET)
	public void fileRequest(HttpServletRequest request,	HttpServletResponse response) throws IOException {
		logger.info("Providing miserables.json file");

		// get absolute path of the application
		String appPath = request.getContextPath();
		//        String appPath = context.getRealPath("");
		logger.info("appPath = " + appPath);

		String filePath = "classpath:/miserables.json";
		//        String filePath = "/WEB-INF/resources/miserables.json";
		// construct the complete absolute path of the file
//		String fullPath =appPath + filePath;      

		//		File file = new File("C:\\Users\\dineshkp\\Desktop\\GitRepo_local\\GraphVisualization\\GraphVisualizationHelper\\src\\main\\resources\\miserables.json");
		//		File file = new File ("/resources/miserables.json");
		//		String fileName = "classpath:";

		//		FileSystemResource resource = new FileSystemResource(fullPath);	
		//		FileSystemResource resource = new FileSystemResource("C:\\Users\\dineshkp\\Desktop\\GitRepo_local\\GraphVisualization\\GraphVisualizationHelper\\src\\main\\resources\\miserables.json");


		//		File file = new File(fileName);
		//		System.out.println(file.toString());

//		Resource resource = resourceLoader.getResource("classpath:/miserables.json");
		Resource resource = resourceLoader.getResource(filePath);
		File file = resource.getFile();
		try {

			InputStream in = new FileInputStream(file);
//						InputStream in = resource.getInputStream();
			// copy it to response's OutputStream
			org.apache.commons.io.IOUtils.copy(in, response.getOutputStream());

			response.flushBuffer();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("IOError writing file to output stream");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			logger.info("Completed action...");
		}
	}

}
