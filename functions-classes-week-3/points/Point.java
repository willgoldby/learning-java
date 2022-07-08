// Create a class called Point.
import java.lang.Math;

public class Point{

    int[] corrdinates = new int[2];

    // Define constructor for Point class.    
    public Point(int[] corrdinates){
        this.corrdinates = corrdinates;
       
    }

    //Define method that returns the point closest to the origin
    public int distanceToOrigin(){
        int firstSolution = (int) Math.pow((this.corrdinates[0] - 0), 2);
        int secondSolution = (int) Math.pow((this.corrdinates[1] - 0), 2);
        int result = (int) Math.sqrt((firstSolution + secondSolution)); 
        return result;
    }
}







