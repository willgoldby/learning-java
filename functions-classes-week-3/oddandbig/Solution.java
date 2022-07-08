import java.util.Scanner;

public class Solution{
    public static boolean isOddGreaterThanTen(int number){
        if (number > 10 && number%2!=0){
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String[] numbers = new String[input.nextInt()];
        String result = "";
        int test = 0;
        int iteration = 0;
        // Consume \n from the input number.
        input.nextLine();
        
        // Add each line to the string array.
        for (int i=0; i < numbers.length; i++){
            numbers[i] = input.nextLine();
        }
        
        // Put set of numbers in Scanner object
        for (int j=0; j < numbers.length; j++){
            Scanner testNumbers = new Scanner(numbers[j]);
            
            // Loop through each number.
            for (int k=0; k<3; k++){
                test = testNumbers.nextInt();

                // If number doesn't pass, set result to false.
                if (!isOddGreaterThanTen(test)){
                    result = "No";
                    break;
                }

                result = "Yes";
            }
            iteration = j+1;
            System.out.println("Case #" + iteration + ": " + result);

        }

    }
}
