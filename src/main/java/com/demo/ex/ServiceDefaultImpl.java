package com.demo.ex;

import org.springframework.context.annotation.Profile;

@org.springframework.stereotype.Service	
@Profile("default")
public class ServiceDefaultImpl implements Service {

	@Override
	public String getMessage() {
		return "DEFAULT";
	}

}
