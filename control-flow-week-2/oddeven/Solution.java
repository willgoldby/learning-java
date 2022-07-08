import java.util.Scanner;


// Given an integer number, output Odd if it is odd, or Even if it is even.
public class Solution {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int number = Integer.parseInt(input.next());
        if (number%2 == 0){
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }
    }
}