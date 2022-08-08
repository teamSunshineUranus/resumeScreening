package com.criteriaManager;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestConfigParser {
	
	@Test
	public void testconfigParser() {
		RSAConfigParser rsaconfig = new RSAConfigParser();
		//3 are now defined in the config file
		assertEquals(3, rsaconfig.getcriteriaCnt());
	}
	
	

}
