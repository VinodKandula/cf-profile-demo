package com.demo.ex;

import org.springframework.context.annotation.Profile;

@org.springframework.stereotype.Service	
@Profile("qa")
public class ServiceQaImpl implements Service {

	@Override
	public String getMessage() {
		return "QA";
	}

}
