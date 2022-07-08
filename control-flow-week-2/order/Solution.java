import java.util.Scanner;

//Given three different integer numbers, output them in the ascending order.
public class Solution{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int A = Integer.parseInt(input.next());
        int B = Integer.parseInt(input.next());
        int C = Integer.parseInt(input.next());
        
        int first = 0;
        int second = 0;
        int third = 0;
        
        if (A < B){
            if (A < C){
                first = A;
                if (B < C){
                    second = B;
                    third = C;
                } else{
                    second = C;
                    third = B;
                }
            } else {
                first = C;
                second = A;
                third = B;
            }
        }else if (C < B){
            first = C;
            second = B;
            third = A;
        }else if (A < C){
            first = B;
            second = A;
            third = C;   
        }else {
            first = B;
            second = C;
            third = A;
        }
        
        System.out.print(first+ " " + second + " " + third);

        }
    }