package com.criteriaManager;

import java.time.temporal.ValueRange;
import java.util.ArrayList;
import com.debugprint.rsaDebug;
import com.regexSearch.RSARegexsearch;

public class ExperienceCriteriaMatcher implements RSACriteriaList{
	//List to store Experience related key values.
	private ArrayList<String> ValueList;
	private int ExperienceValue = 0;
	private int searchStatus = 0;
	
	public ExperienceCriteriaMatcher() {
		ValueList = new ArrayList<String>();
	}
	
	public ArrayList<String> getValueList() {
		return ValueList;
	}

	public void setValueList(String skillValue) {
		ValueList.add(skillValue);
	}
	
	public void resetSearchStatus() {
		searchStatus = 0;
	}
	
	public int getSearchStatus() {
		return searchStatus;
	}
	
	public String getTagValue() {
		return "Experience";
	}
	/*
	 * Fetch years of experience based the input regex string.
	 */
	private String searchExp(String fileData, String regexStr)
	{
		String lineStr = RSARegexsearch.regexFetchAllMatches(regexStr,fileData);
		if(lineStr.length()>0)
		{
			String numStr = RSARegexsearch.regexWordMatch("\\d+(\\.\\d+)?", lineStr, true);
	        if(numStr.length()>0)
	        {
	        	ExperienceValue = (int) Float.parseFloat(numStr);
				rsaDebug.print("Experience:"+ExperienceValue);
				if(isExperienceEligible())
					++searchStatus;
				return numStr;
	        }
		}
		return("**");
	}
	/*
	 * Method to fetch experience value from
	 * the file data with different text writing patterns.
	 */
	public String searchCriteria(String fileData)
	{
		String outStr = searchExp(fileData,"(?<=experience)(.*)(?=years)");
		if(outStr.contains("**"))
		{
			rsaDebug.print("Retrying with another pattern.........");
			outStr = searchExp(fileData,"(.*)(?<=years)");
		}
		return outStr;
	}
	/*
	 * Check whether the fetched experience value is within 
	 * the defined criteria range.
	 */
	private boolean isExperienceEligible()
	{
		rsaDebug.print("Experience:"+ExperienceValue);
		int minRange = Integer.parseInt(ValueList.get(0));
		int maxRange = Integer.parseInt(ValueList.get(1));
		if (ValueRange.of(minRange, maxRange).isValidIntValue(ExperienceValue)) 
			return true;
		else 
			return false;
	}
}
