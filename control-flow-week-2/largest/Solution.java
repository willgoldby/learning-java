import java.util.Scanner;

/*
The Largest Number
Given a sequence of numbers, output the largest number from this sequence.

Input
The input is a single line of integers. The first integer N is the length of the sequence. The following N integers are the sequence itself.

Output
Output a single integer number: the largest element of the sequence.
*/
public class Solution {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int length = Integer.parseInt(input.next());
        int largest = Integer.parseInt(input.next());
    

        for (int i = 0; i < length-1; i++){
            int number = Integer.parseInt(input.next());
            if (number > largest){
                largest = number;
            }
        }
        System.out.print(largest);
    }
}