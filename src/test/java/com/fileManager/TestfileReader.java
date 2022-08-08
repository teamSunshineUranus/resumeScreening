package com.fileManager;

import java.io.File;
import org.junit.Test; 

public class TestfileReader {
	@Test
	public void testPDFgetFileData(){
		
		try {
			 File file = new File("src/testdata/pdftest.pdf");
			 assert(((new PdfFileReader()).getFileData(file)).length()>0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testDOCgetFileData(){
		
		try {
			 File file = new File("src/testdata/doctest.doc");
			 assert(((new DocFileReader()).getFileData(file)).length()>0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testDOCXgetFileData(){
		
		try {
			 File file = new File("src/testdata/docxtest.docx");
			 assert(((new DocxFileReader()).getFileData(file)).length()>0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
