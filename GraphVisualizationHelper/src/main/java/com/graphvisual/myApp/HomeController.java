package com.graphvisual.myApp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.graphvisual.myApp.jsonGen.Link;
import com.graphvisual.myApp.jsonGen.Node;
import com.graphvisual.myApp.jsonGen.TestGraph;

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

		return "home";
	}
	/*
	@RequestMapping(value = "/filerequest", method = RequestMethod.GET)
	public void fileRequest(HttpServletRequest request,	HttpServletResponse response) throws IOException {
		logger.info("Providing Json  file");

//		String appPath = request.getContextPath();
//		logger.info("appPath = " + appPath);

//		String filePath = "classpath:/test_graph.json";

		TestGraph g1 = getGraph();
//		logger.info(g1);

//		Resource resource = resourceLoader.getResource(filePath);
//		File file = resource.getFile();

		try {

//			InputStream in = new FileInputStream(file);
			// copy it to response's OutputStream
//			org.apache.commons.io.IOUtils.copy(in, response.getOutputStream());
			IOUtils.copy(IOUtils.toInputStream(g1, Charset.defaultCharset()), response.getOutputStream());
//			IOUtils.copy(, output)
			response.flushBuffer();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("IOError writing file to output stream");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			logger.info("Completed action...");
		}
	}
	 */
	
	@RequestMapping(
			method=RequestMethod.GET, 
			value="/filerequest", 
			produces="application/json" )
	@ResponseBody
	public TestGraph getNewGraph() {
		ObjectMapper mapper = new ObjectMapper();
		TestGraph graph = getGraph();
//		String filePath = "classpath:/test_graph_2.json";
		String filePath = "/home/dineshkp/Desktop/test_graph_2.json";
		try {
			mapper.writeValue(new File(filePath), graph);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return graph;
	}

	
	
	public TestGraph getGraph() {
		ObjectMapper mapper = new ObjectMapper();
		String jsonGraph = "";

		logger.info("Getting Graph...");

		Node n1 = new Node("T1", 1);
		Node n2 = new Node("T2", 2);
		Node n3 = new Node("T3", 3);
		Link l1 = new Link(1, 2, 3);
		Link l2 = new Link(1, 3, 1);
		List<Node> nodeList1 = new ArrayList<Node>();
		List<Link> linkList1 = new ArrayList<Link>();

		nodeList1.add(n1);
		nodeList1.add(n2);
		nodeList1.add(n3);

		linkList1.add(l1);
		linkList1.add(l2);
		TestGraph graph = new TestGraph(nodeList1,linkList1);

		logger.info("Completed Graph generation.");
		return graph;
	}

}
