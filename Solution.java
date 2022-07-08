import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args){
        System.out.println("Hi! What's your name?");
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String name = in.next();
        System.out.println("Hello, " + name + "!");
    
    }
}