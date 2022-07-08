import java.util.Scanner;

class Solution {

    public static void main (String[] args){
        // Get input from user
        Scanner userInput = new Scanner(System.in);
        
        // Get cases
        int cases = userInput.nextInt();
        
        // Consume \n from the first value
        userInput.nextLine();

        //Array to hold all the answers
        StringBuilder[] allAnswers = new StringBuilder[cases];
        
    

        // Get each line, convert string to array,
        // loop over array, reverse each string,
        // append string to string builder
        for (int i = 0; i < cases; i++){
           
            
            // Get data
            String line = userInput.nextLine();
            
            // Convert string to String array.
            String[] wordsInArr = line.split(" ");

            // Get variable to hold the answer
            StringBuilder answer = new StringBuilder();
            for (String item: wordsInArr){
                // Append rotated string to answer
                answer.append(rotateString(item));
                // Add space between words
                answer.append(' ');
            }

            allAnswers[i] = answer;
        }

        for (int i = 0; i < allAnswers.length; i++){

            System.out.printf("Case #%d: " +  allAnswers[i] + "\n", i+1);
        }
        
    }

    public static String rotateString(String stringToRotate){
        // 1. swap first and last
        // 2. swap second and second to last
        // 3. etc, until loop ends
        int len = stringToRotate.length();
        char[] result = new char[len];
        // put middel value in if length is odd.
        int lenMod2 = len%2;

        if (len%2 != 0){
            result[len/2] = stringToRotate.charAt(len/2);
        }
        for (int i = 0; i < (len)/2; i++ ){
            //put last element in first postion
            result[i] = stringToRotate.charAt(len - (1+i));
            //put first element in last position
            result[len - (i+1)] = stringToRotate.charAt(i);
        }
        // Change list to string
        String reversedString = new String(result);
        return reversedString;

    }


}