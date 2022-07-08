import java.util.regex.*;
import java.util.*;

public class DNA {

		String dnaString;
		Hashtable<String, Long> seqAndCount = new Hashtable<String, Long>();
	// Create the DNA class.
	public DNA(String dnaString){
	
		this.dnaString = dnaString;
		// Does something go here for the constructor?
	//	System.out.println("You've created a DNA Class");
	//	System.out.println("It's dnaString is: " + dnaString);
	}
	
	// Create and instance variable for dna sequence and count. 
  public void DnaSequenceAndCount(String seq){

	// I have a long DNA string and a sequence.
	// I need to count how many times
	// that sequence appears.
	// 1. How can I use regex?
  
	String thePattern = "((" + seq + ")+(?<=" + seq + "))"; 
	Pattern SEQ = Pattern.compile(thePattern); 
	Matcher countSEQ = SEQ.matcher(this.dnaString);
	// while (countSEQ.find()){
	// 	System.out.println(countSEQ.toString());
	// }
  // System.out.println("CApture groups: " + countSEQ.groupCount());
	 //System.out.println("The pattern: " + countSEQ.pattern());
	// Get the the subsequence
	// change regex to captuer the seq
	// count the sequnce.
	long countOfNewSEQ = 0;
	int lenOfMatch = 0;
	//System.out.println("countSEQ.find(): " + countSEQ.find());
	if (!countSEQ.find()){
	//System.out.println("Didn't have the seq, " + seq + ", in the DNA string, " + this.dnaString); 
	seqAndCount.put(seq, countOfNewSEQ);

	} else{
		countSEQ.reset();
		//countSEQ.find(0);
		//System.out.println("Entered else");
	while (countSEQ.find()){
	//	System.out.println("ENTERED WHILE LOOP");
	String group = countSEQ.group();
	//System.out.println("This input sequnce from previous match: " + group);
	//System.out.println("THis is the length of the group: " + group.length());
	//System.out.println("This is what the group catputer: " + group);
		if (group.length() > lenOfMatch ){
			lenOfMatch = group.length();
			String pat = seq;
			Pattern newSEQ = Pattern.compile(pat);
			Matcher countNewSEQ = newSEQ.matcher(group);
			countOfNewSEQ = countNewSEQ.results().count();
//			System.out.println("This is the countOfNewSEQ: " + countOfNewSEQ); 
			seqAndCount.put(seq, countOfNewSEQ);
			

		} 
		}
	}
//System.out.println("This is the DNA string: " + this.dnaString);
//System.out.println("This is the sequence: " + seq);
//System.out.println("This is seqAndCount: " + seqAndCount.put(seq, countOfNewSEQ));


		
	
	}
}	
    	
	//System.out.println(countOfNewSEQ);
	
	//System.out.print(seqAndCount);
  


	

	









