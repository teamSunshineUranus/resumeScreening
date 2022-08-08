package com.criteriaManager;

import java.util.ArrayList;
import com.regexSearch.RSARegexsearch;

public class SkillCriteriaMatcher implements RSACriteriaList {
	//List to store Skill related key values.
	private ArrayList<String> ValueList;
	private int searchStatus = 0;
	
	public SkillCriteriaMatcher() {
		
		ValueList = new ArrayList<>();
	}

	public ArrayList<String> getValueList() {
		return ValueList;
	}

	public void setValueList(String skillValue) {
		ValueList.add(skillValue);
	}
	
	public String getTagValue() {
		return "Skill";
	}
	
	public int getSearchStatus() {
		return searchStatus;
	}
	
	public void resetSearchStatus() {
		searchStatus = 0;
	}
	/*
	 * Search method to find Skill key value match 
	 * in the file data.
	 */
	public String searchCriteria(String fileData)
	{	
		for(String keyValue : ValueList)
		{
			String strRegex = "\\b"+keyValue+"\\b";

			String outStr = RSARegexsearch.regexWordMatch(strRegex, fileData, true);
			if(outStr.length() > 0) {
				++searchStatus;
				return outStr;
			}
		}
		return"****";
	}

}
