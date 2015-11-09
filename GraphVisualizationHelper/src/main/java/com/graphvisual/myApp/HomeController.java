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
import com.graphvisual.myApp.jsonGen.Edge;
import com.graphvisual.myApp.jsonGen.Node;
import com.graphvisual.myApp.jsonGen.SimpleGraph;

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
			value="/filerequest" )
	public void getNewGraph (HttpServletRequest request,	HttpServletResponse response) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		SimpleGraph graph = getGraph();
		mapper.writeValue(response.getOutputStream(), graph);
		response.flushBuffer();
	}



	public SimpleGraph getGraph() {
		ObjectMapper mapper = new ObjectMapper();
		String jsonGraph = "";

		logger.info("Getting Graph...");
// Node name, Node group
		Node dr01 = new Node("DR01", 1);
		Node dr02 = new Node("DR02", 1);
		Node dr03 = new Node("DR03", 1);
		Node dr04 = new Node("DR04", 1);
		Node dr05 = new Node("DR05", 1);
		Node dr06 = new Node("DR06", 1);
		Node dr07 = new Node("DR07", 1);
		Node dr08 = new Node("DR08", 1);
		Node dr09 = new Node("DR09", 1);
		Node dr10 = new Node("DR10", 1);
		Node dr11 = new Node("DR11", 1);
		Node dr12 = new Node("DR12", 1);
		Node dr13 = new Node("DR13", 1);
		Node dr14 = new Node("DR14", 1);
		Node dr15 = new Node("DR15", 1);
		Node dr16 = new Node("DR16", 1);
		Node dr17 = new Node("DR17", 1);
		Node strPF01 = new Node("STRPF01", 2);
		Node escPF01 = new Node("ESCPF01", 3);
		Node strL101 = new Node("STRL101", 6);
		Node escL101 = new Node("ESCL101", 7);
		Node STNCTR01 = new Node("STNCTR01", 4);
		Node EXT01 = new Node("EXT01", 5);
		Node EXT02 = new Node("EXT02", 5);
		Node EXT03 = new Node("EXT03", 5);
		// Link FromVertex, ToVertex, Weightage
		Edge l1 = new Edge(0, 17, 7.0);
		Edge l2 = new Edge(1, 17, 6.0);
		Edge l3 = new Edge(2, 17, 5.0);
		Edge l4 = new Edge(3, 17, 4.0);
		Edge l5 = new Edge(4, 17, 3.0);
		Edge l6 = new Edge(5, 17, 2.0);
		Edge l7 = new Edge(6, 17, 1.0);
		Edge l8 = new Edge(7, 17, 2.0);
		Edge l9 = new Edge(8, 17, 3.0);
		Edge l10 = new Edge(9, 17, 4.0);
		Edge l11 = new Edge(10, 17, 5.);
		Edge l12 = new Edge(11, 17, 6.0);
		Edge l13 = new Edge(12, 17, 7.0);
		Edge l14 = new Edge(13, 17, 8.0);
		Edge l15 = new Edge(14, 17, 9.0);
		Edge l16 = new Edge(15, 17, 10.0);
		Edge l17 = new Edge(16, 17, 11.0);
		Edge l18 = new Edge(0, 18, 11.0);
		Edge l19 = new Edge(1, 18, 10.0);
		Edge l20 = new Edge(2, 18, 9.0);
		Edge l21 = new Edge(3, 18, 8.0);
		Edge l22 = new Edge(4, 18, 7.0);
		Edge l23 = new Edge(5, 18, 6.0);
		Edge l24 = new Edge(6, 18, 5.0);
		Edge l25 = new Edge(7, 18, 4.0);
		Edge l26 = new Edge(8, 18, 3.0);
		Edge l27 = new Edge(9, 18, 2.0);
		Edge l28 = new Edge(10, 18, 1.0);
		Edge l29 = new Edge(11, 18, 2.0);
		Edge l30 = new Edge(12, 18, 3.0);
		Edge l31 = new Edge(13, 18, 4.0);
		Edge l32 = new Edge(14, 18, 5.0);
		Edge l33 = new Edge(15, 18, 6.0);
		Edge l34 = new Edge(16, 18, 7.0);
		Edge l35 = new Edge(17, 19, 6.0);
		Edge l36 = new Edge(18, 20, 12.0);
		Edge l37 = new Edge(19, 21, 4.0);
		Edge l38 = new Edge(20, 21, 12.0);
		Edge l39 = new Edge(21, 22, 4.0);
		Edge l40 = new Edge(21, 23, 4.0);
		Edge l41 = new Edge(21, 24, 4.0);

		
		List<Node> nodeList1 = new ArrayList<Node>();
		List<Edge> linkList1 = new ArrayList<Edge>();


		nodeList1.add(dr01);
		nodeList1.add(dr02);
		nodeList1.add(dr03);
		nodeList1.add(dr04);
		nodeList1.add(dr05);
		nodeList1.add(dr06);
		nodeList1.add(dr07);
		nodeList1.add(dr08);
		nodeList1.add(dr09);
		nodeList1.add(dr10);
		nodeList1.add(dr11);
		nodeList1.add(dr12);
		nodeList1.add(dr13);
		nodeList1.add(dr14);
		nodeList1.add(dr15);
		nodeList1.add(dr16);
		nodeList1.add(dr17);
		nodeList1.add(strPF01);
		nodeList1.add(escPF01);
		nodeList1.add(strL101);
		nodeList1.add(escL101);
		nodeList1.add(STNCTR01);
		nodeList1.add(EXT01);
		nodeList1.add(EXT02);
		nodeList1.add(EXT03);
		

		linkList1.add(l1);
		linkList1.add(l2);
		linkList1.add(l3);
		linkList1.add(l4);
		linkList1.add(l5);
		linkList1.add(l6);
		linkList1.add(l7);
		linkList1.add(l8);
		linkList1.add(l9);
		linkList1.add(l10);
		linkList1.add(l11);
		linkList1.add(l12);
		linkList1.add(l13);
		linkList1.add(l14);
		linkList1.add(l15);
		linkList1.add(l16);
		linkList1.add(l17);
		linkList1.add(l18);
		linkList1.add(l19);
		linkList1.add(l20);
		linkList1.add(l21);
		linkList1.add(l22);
		linkList1.add(l23);
		linkList1.add(l24);
		linkList1.add(l25);
		linkList1.add(l26);
		linkList1.add(l27);
		linkList1.add(l28);
		linkList1.add(l29);
		linkList1.add(l30);
		linkList1.add(l31);
		linkList1.add(l32);
		linkList1.add(l33);
		linkList1.add(l34);
		linkList1.add(l35);
		linkList1.add(l36);
		linkList1.add(l37);
		linkList1.add(l38);
		linkList1.add(l39);
		linkList1.add(l40);
		linkList1.add(l41);
		
		
		SimpleGraph graph = new SimpleGraph(nodeList1,linkList1);

		logger.info("Completed Graph generation.");
		return graph;
	}

}
