package org.iii.web;

import java.util.ArrayList;
import java.util.List;

import org.iii.model.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private List<Member> members = new ArrayList<Member>();
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	public HomeController() {
		members.add(new Member("John", "Lennon"));
	    members.add(new Member("Paul", "McCartney"));
	    members.add(new Member("George", "Harrison"));
	    members.add(new Member("Ringo", "Starr"));
	}
	
	@RequestMapping()
	public void list(Model model) {
		model.addAttribute(members);
	}
	
	@RequestMapping()
	public void member(@RequestParam("id") Integer id, Model model) {
		model.addAttribute(members.get(id));
	}
	
	
}
