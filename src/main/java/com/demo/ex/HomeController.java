package com.demo.ex;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

import javax.annotation.Resource;

import org.cloudfoundry.runtime.env.CloudEnvironment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
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
	Service svc;
	
	@Resource(name="systemProperties")
	Properties cloudProps;
	
	@Autowired
	Environment environment;
	
	@Value("${ANOTHER_VAR}") // Only works if you have a property placeholder defined.
//	@Value("#{ANOTHER_VAR}") // Does not work
//	@Value("#{systemEnvironment['ANOTHER_VAR']}")	// Works.  gets the environment variable
	String value;
	
	@Value("#{systemProperties['aaa']}")
	String aaa;
	
//	@Value("${bbb}")
	String bbb;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		logger.info("vcap: " + System.getenv("VCAP_SERVICES"));
		logger.info("profile: " + System.getenv("SPRING_PROFILES_ACTIVE"));
		logger.info("another: " + System.getenv("ANOTHER_VAR"));
		logger.info("AAA: " + System.getProperty("aaa"));
		logger.info("BBB: " + System.getProperty("bbb"));
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("profile", svc.getMessage() );
		model.addAttribute("properties", cloudProps );
		model.addAttribute("vcapProperties", System.getenv("VCAP_SERVICES"));
		model.addAttribute("profileVar", environment.getProperty("SPRING_PROFILES_ACTIVE"));
		model.addAttribute("anotherVar", value);
		model.addAttribute("aaa", aaa);
		model.addAttribute("bbb", bbb);

		return "home";
	}
	
}
