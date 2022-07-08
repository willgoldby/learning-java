import java.util.Scanner;

public class Solution {
    
    public static void main(String[] args){
        String[] comingIn = theData();
        theResults(comingIn);


    }

    // Get the input into a useable form
    public static String[] theData(){
        Scanner input = new Scanner(System.in);
        String[] points = new String[input.nextInt()];

        //Consume \n
        input.nextLine();
        
        // Loop over input and add it to the string array.
        for (int i = 0; i<points.length; i++){
            points[i] = input.nextLine();
        }

        // So now I have {"0 0 1 0 0 1", "1 1 1 4 5 1", "..."}
        return points;
    }


    // Take the usable input and loop through it, creating the objects
    // and printing results
    public static void theResults(String[] theData){

        //How do I loop over the input and create a triangle object?
        // Get element "0 0 1 0 0 1"
        // Loop over but increment by 2 and have
        // Point(i, i+1)

        // I need a way to create three points.
        // Turn that input into a int array, 
        // assign points, calculate, print, next sequence
        int cas = 0;
        for (int i = 0; i< theData.length; i++){
            int[] valuesAsInts = new int[6];
            
            // Put element into its own String array
            // "0 0 1 0 0 1" -> {"0", "0", "1", "0", "0", "1"}
            String[] valuesAsString = theData[i].split(" ");

            // Put int into array
            for (int j = 0; j < valuesAsString.length; j++){
                valuesAsInts[j] = Integer.parseInt(valuesAsString[j]);
            }
            
            cas = cas + 1;
            /////
            ////    JUST NEED TO ADD CASE # (USE i from outer loop).
            /////   AND ROUND RESULTS
            //////



            Point point1 = new Point(valuesAsInts[0], valuesAsInts[1]);
            Point point2 = new Point(valuesAsInts[2], valuesAsInts[3]);
            Point point3 = new Point(valuesAsInts[4], valuesAsInts[5]);


            Triangle tri = new Triangle(point1, point2, point3);
            System.out.print("Case #" + cas + ": " + String.format("%.2f",tri.area()));
            System.out.print(" " + String.format("%.2f",tri.perimeter()));

            // Need a rectangle class

            Rectangle rec = new Rectangle(point1, point2, point3);
            System.out.print(" " + String.format("%.2f", rec.area()));
            System.out.print(" " + String.format("%.2f", rec.perimeter()));
            System.out.println();

            }
        }

    }




 // Create points
//  Point point1 = new Point(0, 0);
//  Point point2 = new Point(1, 0);
//  Point point3 = new Point(0, 1);

//  //Create line segment
//  Segment seg1 = new Segment(point1, point2);
 
//  //System.out.println(seg1.segLength());
 
//  // Need a triangle class
//  Triangle tri = new Triangle(point1, point2, point3);
//  System.out.println(tri.area());
//  System.out.println(tri.perimeter());

//  // Need a rectangle class

//  Rectangle rec = new Rectangle(point1, point2, point3);
//  System.out.println(rec.area());
//  System.out.println(rec.perimeter());