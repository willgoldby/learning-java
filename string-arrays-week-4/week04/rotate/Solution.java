import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.*;
//import java.jouraldev.util;

public class Solution{

  public static void main (String[] args){
  Scanner input = new Scanner(System.in);
  int cases = input.nextInt();

	//Remove \n
	input.nextLine();
 
	for (int k = 0; k<cases; k++){
		  int caseOfTest = k + 1;	
			String ogInput = input.nextLine();
			
			//Check input captured correctly
		  //System.out.println(ogInput);

			// Remove \n
			// input.nextLine();

			//Get array into two halves
			String[] arr = ogInput.split("  ");
			
			//Now I have ["1 3", "1 2 3"]
			String mod1 = arr[0];
			
			// mod1 = "1 3"
			String[] mod1_a = mod1.split(" ");
       
      
       

			// mod1_a = ["1", "3"]
			int rotations = Integer.parseInt(mod1_a[0]);
		
			// mod2 = "1 2 3"
			String mod2 = arr[1];
			
			// mod2_a = ["1","2","3"]
			String[] mod2_a = mod2.split(" ");
			
			while (rotations > mod2_a.length){
					//rotations = Math.floorDiv(rotations, mod2_a.length);
                    //System.out.println(rotations);
                    rotations = rotations % mod2_a.length;
				}

			String[] firstAnswer = rotate(rotations, mod2_a);
			String yep = String.join(" ", firstAnswer);	
			System.out.println("Case #" + caseOfTest + ": " + yep);	

		}



	

	}
  


  // Take in an array and reverse some number of times.
  // How can I call this thing to test it?
	public static String[] rotate(int rotations, String[] arr){
  	//How would I rotate this? 
		// Take last element and put it in the front.
		// Is there an insert method on String arr?
		// 1. Create two String arrays by splitting
		//    on number of rotations
		//    arr = ["1", "2", "3", "4", "5"]
		//    rotate two times
		//    arr1 = arr[from -1 to -2] -> arr1 = ["4", "5"]
		//    arr2 = arr[from 0 to -2] -> arr2 = ["1", "2", "3"]
		// 2. Add both arrays
		//    result = arr1 + arr2 -> result = ["4", "5", "1", "2", "3"]
	  
    // array length is 3 and I want to do 90 rotations on it. 



		// What subsection of array do I want?
		// length is 3. Two rotations would be second to last to the last
		// [1,2,3] length 3. 3-2= 1 (arr.length - rotations) and then arr.lenght
		//  for last element
		String[] arr1 = Arrays.copyOfRange(arr, arr.length - rotations, arr.length);
    String[] arr2 = Arrays.copyOfRange(arr, 0, arr.length-rotations);
	
    // Add two arrs together
		String[] finalAnswer = Stream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).toArray(String[]::new);
		return (finalAnswer); 


		}
}
