import java.util.Scanner;

/*
A sequence of Numbers
A002024 is a sequence of numbers, where every natural number K appears K times:
1 2 2 3 3 3 ...

Given the number N, output the first N numbers in this sequence.

Input
The input contains exatly one number N.

Output
Output a single line containing N numbers: the first N elements of the A002024 sequence.
*/

public class Solution {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        int length = Integer.parseInt(input.next());
        int iterations = 0;
        String result = new String();
        if (length != 0){
            for(int i = 1; iterations < length; i++){
                for (int j = 1; j <= i; j++){
                    result = result + Integer.toString(i) + " ";
                    iterations = iterations + 1;
                    if (iterations == length){
                        System.out.println(result);
                        break;
                    }
                }
            }
        }
            
        }
        
        
    }
