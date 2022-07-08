import java.util.Scanner;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Solution {

	public static void main (String[] args){
	// What's going on here?
	// 1. I get a number of how many STRs appear.
	//		Then those STRs.
	// 2. I then get a number for how many test cases there are.
	// 3. I then get A name and how many times east STR repeats.
	// 4. I then get a number for how many DNA lines appear.
	// 5. I then get that many lines of DNA.

	// Let's just make sure we can take in the input first.

	Scanner input = new Scanner(System.in);

	// Do I want to put this in a for loop
	// Not yet.

	// I just want the repeating strings. I don't
	// care how many there are.

  // Get first row of data.
	// str_1 <- "3 AGAT AATG TATC"
	String str_1 = input.nextLine();
  
	// Turn str_1 into a string array.
	String[] dnaSequencesToCount = str_1.split("\\s+");
  //dnaSequencesToCount = Arrays.copyOfRange(dnaSequencesToCount, 1, dnaSequencesToCount.length);  
  


	// Get the repeating strings
	// How can I get a string for each person?
	// I get how many people are coming. Maybe capture that first?
  
	// numPeople <- 3
	int numPeople = input.nextInt();
	input.nextLine();
	//System.out.println(numPeople);

  // Now what? Append all the peeps onto a string array.
 	String[] peeps_1 = new String[numPeople];

  // peeps_1 <- a string list of all the people
	for (int i = 0; i < numPeople; i++){
		peeps_1[i] = input.nextLine();
		}

	// Create list of people objects. 
  Person[] peopleAndCount = new Person[numPeople];
	
	// loop through people and create an object with
	// the right attributes and add it to people and count.

	for (int e=0; e<numPeople; e++){
		// nameAndQuant <- ["name", "5", "3", '3'] 
		String[] nameAndQuant = peeps_1[e].split("\\s+");

		peopleAndCount[e] = new Person(nameAndQuant[0]);
		// add dna seqence and count to person
		for (int s=0; s < dnaSequencesToCount.length-1; s++){
			Long dnaCount = Long.parseLong(nameAndQuant[s+1]);
			peopleAndCount[e].addSeqAndNum(dnaSequencesToCount[s+1], dnaCount);
		}
	}

	

	// Now get the DNA strings I need to test
	int numOfDNAStrings = input.nextInt();
	input.nextLine();
	
	// Hold DNA strings
	String[] dna = new String[numOfDNAStrings]; 

	// Add the dna strings to the dna list
	for (int k = 0; k < numOfDNAStrings; k++){
		dna[k]=input.nextLine();
		}
	// Add return
	//input.nextLine();
	//	for (String r: dna){
	//		System.out.println(r);
	//			}

//	for (String x: peeps_1){
//	System.out.println(x);
//	}

// What's next? 
// 1. Create a DNA class that holds how many times a certain sequence repeats. 
//    The class has a method that takes in a DNA string and then creates an instance varialbe for
//		how many times that sequence is in the class. 

// so dna <- ["somelongdnastring","somelongdnastring","somelongdnastring","somelongdnastring"]  
	// 1. Loop through dna and create a DNA class for each string.
	// 2. Then count how many times each sequence occurs.
	int loops = 0;
	for (int y=0; y<dna.length; y++) {
	// for (String d: dna)
	//System.out.println("This is the DNA string: " + dna[y]);
		loops = loops + 1;
		DNA someDNA = new DNA(dna[y]);
		for (int v=1; v <dnaSequencesToCount.length; v++){
		//for (String seq: dnaSequencesToCount){
			// seq <- "AGTT"
			// call method that counts how many times that
			// string repeats in DNA string.
			// assign instance a variable is that number.
			someDNA.DnaSequenceAndCount(dnaSequencesToCount[v]);
			}
		
// SO now I have a object,	someDNA.seqAndCount.get(seq), that returns
// the count for that sequnce. 
// I have have a list of people objects that have a name and their count number
// for that sequence. 

// SOOOO, I need to loop through dna list,
// and  
// System.out.println("TEsting loop");
// for (int l = 0; l< peopleAndCount.length; l++){
// 		System.out.println("This is the name: " + peopleAndCount[l].name);
// 			for (int h=0; h < peopleAndCount[l].seqAndCount.size(); h++){
// 					String what = dnaSequencesToCount[h+1];
// 					System.out.println("This is the count for " + what +":" + peopleAndCount[l].seqAndCount.get(what));

// 			}	
// 	}

// System.out.println(peopleAndCount.length);
// String[] thesequences = Arrays.copyOfRange(dnaSequencesToCount, 1, dnaSequencesToCount.length);
// for (int b=0; b < peopleAndCount.length; b++){
// 	System.out.println("Name: " + peopleAndCount[b].name);
// 		for (int n = 0 ; n < peopleAndCount[b].seqAndCount.size(); n++){
// 			System.out.println("The values for each sequence: "+ thesequences[n] + "The value: " + peopleAndCount[b].seqAndCount.get(thesequences[n]));
//
// 	}
//}

//System.out.println(peopleAndCount.length);
// String[] thesequences = Arrays.copyOfRange(dnaSequencesToCount, 1, dnaSequencesToCount.length);
// //for (int b=0; b < peopleAndCount.length; b++){
// 	System.out.println("Name: " + peopleAndCount[y].name);
// 		for (int n = 0 ; n < peopleAndCount[y].seqAndCount.size(); n++){
// 			System.out.println("The values for each sequence: "+ thesequences[n] + "The value: " + peopleAndCount[y].seqAndCount.get(thesequences[n]));
// 		}	
// //System.out.println(someDNA.seqAndCount);
boolean found = false;

// Loop over year person and see if they match
String[] thesequences = Arrays.copyOfRange(dnaSequencesToCount, 1, dnaSequencesToCount.length);
for (int m=0; m<peopleAndCount.length; m++){
	 int countStuff = 0;
	 //System.out.println("The person: " + peopleAndCount[m].name);
		for (String s: thesequences){
		//	System.out.println("THis is the sequnce: " + s);
			//System.out.println("Sequence count for the person: " + peopleAndCount[m].seqAndCount.get(s));
			//System.out.println("Sequnce count in dna string: " +someDNA.seqAndCount.get(s));
		if (peopleAndCount[m].seqAndCount.get(s).equals(someDNA.seqAndCount.get(s))) {
						countStuff = countStuff + 1;
						//System.out.println("This is the countStuff: " + countStuff);
					} 
				if (countStuff == thesequences.length){
					System.out.println("Case #" + loops + ": " + peopleAndCount[m].name);
					countStuff = 0;
					found = true;
				}

} 
  
	}
	 if (!found){
		System.out.println("Case #" + loops + ": " + "No match");


		}

}





// int countStuff = 0;
// for (int b = 0; b< dna.size(); b++){
// 	for (int z=0; z< dnaSequencesToCount.length; z++){
// 		String sequence = dnaSequencesToCount[z+1];
// 		System.out.println("This is the sequence: " + sequence);
// 		System.out.println("this is "+  peopleAndCount[b].name+ "and the count" + peopleAndCount[b].seqAndCount.get(sequence));
// 		System.out.println("This is what this DNA string has for that count: "+ someDNA.seqAndCount.get(sequence));	
// 			if (peopleAndCount[b].seqAndCount.get(sequence).equals(someDNA.seqAndCount.get(sequence))) {
// 				countStuff = countStuff + 1;
// 				System.out.println("This is the countStuff: " + countStuff);
// 			} 
// 		if (countStuff == dnaSequencesToCount.length){
// 			System.out.println(peopleAndCount[b].name);
// 	}
// }
// }
// What would I say is wrong. It's going to the next person, and I want it to go to the next dna


// for ( element r: ){
// 	//loop over the dna strings and print their
// 	// quanitty.
// 	someDNA.seqAndCount.
//}

// for (int a=0; a < peeps_1.-1; a++){ //a goes from 0 to 3
// 	int someCount = 0;
// 	String[] nameAndValue = peeps_1.get(a).split(" ");
// 	//nameAndValue <- "name", "5", "4", "3"
// 	for (int w=0; w <someDNA.seqAndCount.size() ; w++){ //w from 0 to 2 nameAndValue.length-1
// 	//for (String q: dnaSequencesToCount){
// 		//q <- "AGTT"
// 		//System.out.println(Long.toString(someDNA.seqAndCount.get(q)));
// 		//System.out.println("This is the sequence: "+ dnaSequencesToCount[w+1]);
// 		String sequenceAppearance = Long.toString(someDNA.seqAndCount.get(dnaSequencesToCount[w+1]));
// 		//System.out.println("This is sequenceAppearance: " + sequenceAppearance);
// 		//System.out.println("This is the value the person's name: "+ nameAndValue[0]);
// 		String valueTheyHave = nameAndValue[w+1];
// 		//System.out.println("valueTheyHave : " + valueTheyHave);
// 		if (sequenceAppearance.equals(valueTheyHave)){
// 			//System.out.println("Count and their value is the same.");
// 			someCount = someCount + 1;
		}
	
	// }
  //   if (someCount == 3){
	// 	System.out.println(nameAndValue[0]);
	// }
}

//}

//		}

		

	


