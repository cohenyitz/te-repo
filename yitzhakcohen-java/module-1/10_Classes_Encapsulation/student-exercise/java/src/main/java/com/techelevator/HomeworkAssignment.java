package com.techelevator;

public class HomeworkAssignment {
	
	public int earnedMarks;
	public int possibleMarks;
	public String submitterName;
	public String letterGrade;
	
public HomeworkAssignment(int possibleMarks) {
	this.possibleMarks = possibleMarks;
	

	
	
		
	}
	/**
	 * @return the earnedMarks
	 */
	public int getEarnedMarks() {
		return earnedMarks;
	}
	/**
	 * @param earnedMarks the earnedMarks to set
	 */
	public void setEarnedMarks(int earnedMarks) {
		this.earnedMarks = earnedMarks;
	}
	/**
	 * @return the submitterName
	 */
	public String getSubmitterName() {
		return submitterName;
	}
	/**
	 * @param submitterName the submitterName to set
	 */
	public void setSubmitterName(String submitterName) {
		this.submitterName = submitterName;
	}
	/**
	 * @return the possibleMarks
	 */
	public int getPossibleMarks() {
		return possibleMarks;
	}
	/**
	 * @return the letterGrade
	 */
	public String getLetterGrade() {
		
		int percentage = (int) (((double) earnedMarks / possibleMarks) * 100);
		if (percentage >= 90 ) {
			letterGrade ="A";
		}
			else if (percentage >= 80 && percentage <= 89) {
			letterGrade = "B";
			
		}
			else if (percentage >= 70 && percentage <= 79) {
			letterGrade = "C";
			
		}
			else if (percentage >= 60 && percentage <= 69) {
			letterGrade = "D";
			
		} 
			else {
			letterGrade = "F";
		}	
		
		
		return letterGrade;
		
}
}	
