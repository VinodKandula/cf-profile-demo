package com.demo.ex;

import org.springframework.context.annotation.Profile;

@org.springframework.stereotype.Service	
@Profile("dev")
public class ServiceDevImpl implements Service {

	@Override
	public String getMessage() {
		return "DEVELOPMENT";
	}

}
