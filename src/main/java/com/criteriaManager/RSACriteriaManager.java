package com.criteriaManager;

import java.util.ArrayList;

import com.debugprint.rsaDebug;
import com.fileManager.RSAFileManager;

public class RSACriteriaManager{

	private ArrayList<String> outputString;
	
	public RSACriteriaManager() {
		outputString = new ArrayList<>();
	}
	
	public ArrayList<String> getOutputString() {
		return outputString;
	}
	public void setOutputString(String outString) {
		outputString.add(outString);
	}
	/*
	 * Method to get Personal Information from resume data
	 */
	private void buildPersonalInfo(RSAFileManager fileManager)
	{
		setOutputString(fileManager.getFileName());
		setOutputString((new EmailAddressReader()).getEmailAdd(fileManager.getFileData()));
		setOutputString((new MobileNumberReader()).getMobileNo(fileManager.getFileData()));
		setOutputString((new CareerBreakInfoReader()).getCareerStatus(fileManager.getFileData()));
	}
	/*
	 * For each resume file, the file data is passed to criteria classes
	 * to perform the search operation.Based on the search status, the candidate
	 * is marked as eligible or not.
	 */
	public void CheckCriteriaEligibilty(ArrayList<RSACriteriaList> criteriaList, RSAFileManager fileManager)
	{
		int eligibleCnt = 0;
		
		buildPersonalInfo(fileManager);
		
		for(RSACriteriaList list: criteriaList) {
			list.resetSearchStatus();
			setOutputString(list.searchCriteria(fileManager.getFileData()));
			eligibleCnt += list.getSearchStatus();
		}
		
		setOutputString((eligibleCnt == RSAConfigParser.getcriteriaCnt())?"yes":"no");

		if(new TechnicalSkillReader().canReadTechnicalSkills())
			setOutputString(new TechnicalSkillReader().readTechnicalSkill(fileManager.getFileData()));
		
		setOutputString(new TechnicalSkillReader().fetchWholeSkillData(fileManager.getFileData()));
		setOutputString(new TechnicalSkillReader().fetchCertificationData(fileManager.getFileData()));
		rsaDebug.print("print lists:"+criteriaList);
		
		String[] outStr = outputString.toArray(new String[0]);
		RSAOutputWriter.updateOutput(outStr);

	}

}
