package com.fileManager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Test; 

public class testfileManager {
	static File file;
	@BeforeClass  
    public static void setUpBeforeClass(){  
        System.out.println("before class");
        try {
			file = new File("src/testdata/testfile.txt");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }  
	
    @Test
    public void testfetchFileData() {
		//System.out.print(new RSAFileManager(file).getFileData().trim());
		assertEquals("This is a test file.",new RSAFileManager(file).getFileData().trim());
    }
    
    @Test
    public void testgetFileName() {
    	assertEquals("testfile",new RSAFileManager(file).getFileName());	
    }
    
    @Test
    public void testvalidateFile() {
    	assertTrue(RSAFileUtils.validateFile(file));
    }
}
