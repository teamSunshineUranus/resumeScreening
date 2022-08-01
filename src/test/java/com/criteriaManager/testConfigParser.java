package com.criteriaManager;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class testConfigParser {
	
	@Test
	public void testconfigParser() {
		RSAConfigParser rsaconfig = new RSAConfigParser();
		//11 Criteria tags are now defined in the config file
		assertEquals(11, rsaconfig.getcriteriaCnt());
	}
	
	

}
