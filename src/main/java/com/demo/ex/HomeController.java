package com.demo.ex;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
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
	
	@Resource(name="cloudProperties")
	Properties cloudProps;
	
	@Autowired
	Environment environment;
	
	@Autowired
	ApplicationContext spring;
	
	@Value("${ANOTHER_VAR}") // Only works if you have a property placeholder defined.
//	@Value("#{ANOTHER_VAR}") // Does not work
//	@Value("#{systemEnvironment['ANOTHER_VAR']}")	// Works.  gets the environment variable
	String value;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		logger.info("profile: " + System.getenv("SPRING_PROFILES_ACTIVE"));

		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("profile", svc.getMessage() );
		model.addAttribute("profileVar", environment.getProperty("SPRING_PROFILES_ACTIVE"));
		model.addAttribute("anotherVar", value);

		model.addAttribute("cloudProperties", cloudProps );
		model.addAttribute("vcapServices", System.getenv("VCAP_SERVICES"));


//		CloudEnvironment ce = new CloudEnvironment();
//		model.addAttribute("cloudProperties", ce.getCloudProperties());
//		model.addAttribute("services", ce.getServices());

		model.addAttribute("beanNames", spring.getBeanDefinitionNames());
		
		return "home";
	}
	
}
