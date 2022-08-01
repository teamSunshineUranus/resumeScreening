package com.rsa;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple RSA App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testRSAManager()
    {
    	RSAManager appMgr = new RSAManager();
        assertTrue(appMgr.analyzeFolderPath());
    }
}
