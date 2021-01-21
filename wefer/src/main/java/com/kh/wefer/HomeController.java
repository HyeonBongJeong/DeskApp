package com.kh.wefer;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kh.wefer.member.model.domain.AnnualSc;
import com.kh.wefer.member.model.domain.Member;
import com.kh.wefer.member.model.service.AnnualScService;
import com.kh.wefer.member.model.service.MemberService;
import com.kh.wefer.schedules.model.service.SchedulesService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private AnnualScService aScService;
	
	@Autowired
	private SchedulesService schdservice;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv, HttpSession session, HttpServletRequest request) {
		String loginUserName = (String) session.getAttribute("loginId");
		mv.addObject("list",aScService.selectAnnualList(loginUserName));
		mv.addObject("list2",schdservice.schedulesList());
		mv.addObject("loginId", loginUserName);
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping(value = "/chat.do", method = RequestMethod.GET)
	public ModelAndView chat(ModelAndView mv, HttpSession session, HttpServletRequest request) {
		String loginUserName = (String) session.getAttribute("loginId");
		logger.info("Welcome " + loginUserName); 
		
		mv.addObject("loginId", loginUserName);
		mv.setViewName("chat");
		return mv;
		
	}

	
}
