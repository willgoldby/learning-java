import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
public class Solution{


	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

		// What do I need to do first
		// Get number of test cases
		//Test cases
		int testCases = input.nextInt();
		// Remove \n 
		input.nextLine();
    		// Track the case number.	
		int cases = 0;
		for (int i = 0; i < testCases; i ++){
			cases += 1;	
			String givenArr = input.nextLine();
			// Create array with two indicies.
			// First index is array length. Second is the values.	
			String[] stringToArray = givenArr.split("  ");	
			// Create a string for just the values.
			// I don't care about array length.
			String justTheValues = stringToArray[1];
			// Create array for the values I care about. 	
			String[] valuesSplit = justTheValues.split(" ");
			// Create an int array for the values.
			int[] valuesAsInts = new int[valuesSplit.length];
			// Cast string to int.
			for (int j = 0; j < valuesAsInts.length; j++){
				valuesAsInts[j] = Integer.parseInt(valuesSplit[j]);	
		        }
	 				
			System.out.println("Case #"+cases+":"+" "+ minMax(valuesAsInts));
		}
	}
		// Get min and max value in an array
		public static int minMax(int[] arr){
			// loop over array find min and max
			int max = Arrays.stream(arr).max().getAsInt();
			int min = Arrays.stream(arr).min().getAsInt(); 
			int maxCount = 0;
			int minCount = 0;
			int result;
			for (int x: arr){
                if (max == min){
                    result = arr.length;
                    return(result);
                }
				if (x < min){
					min = x;
			        minCount = 0;	    
				}
                    if (x == min){
				   	minCount += 1;
				}
				if (x > max ){
					max = x;
			        maxCount = 0;	    
				}
                    if (x == max){
				   	maxCount += 1;
				}
			}
			result = (minCount + maxCount);
			return(result);
	}
}	
