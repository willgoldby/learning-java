import java.util.Scanner;


class Solution {
    public static void main(String[] args){
        String[] points = setOfPoints();
        for (int i = 0; i < points.length; i++){
        }
        closestToOrigin(points);
    }

    // Get the points into a string array.
    public static String[] setOfPoints(){
        Scanner input = new Scanner(System.in);
        
        //Get how many sets of points are coming.
        int numOfPoints = input.nextInt();

        // Create string array to hold each set of points
        String[] allPoints = new String[numOfPoints];

        // Consumes \n from previous input
        input.nextLine();

        // Loop through input and add each set to allPoints array.

        for (int i =0; i < numOfPoints; i++){
            allPoints[i] = input.nextLine();
            //System.out.println(allPoints[i]);
        }

        return allPoints;

        }

    // Turn points each set of points into an int array.
    // to get point1 = {1, 2} and point2 = {33, 21}
    // Functions takes a string array as input and returns 
    // the point closest to origin
    public static void closestToOrigin(String[] thePoints){
        //Loop through each element of the array.
        // at each element, I'll have a string of numbers.
        // Should I scan those in?

        for (int i = 0; i < thePoints.length; i++){
            String[] split = thePoints[i].split(" ");
            // Now I have split = {"1", "2", "3", "4"}
            // If i is less than 2, put first points in
            // point1, else put them in point2.             
            int[] allPoints = new int[4];
            int[] point1 = new int[2];
            int[] point2 = new int[2];
            for (int j = 0; j< allPoints.length; j++){
                allPoints[j] = Integer.parseInt(split[j]);
            }

            System.arraycopy(allPoints, 0, point1, 0,2);
            System.arraycopy(allPoints, 2, point2, 0,2);
        
            // Should I create the pointobject here?
            Point firstPoint = new Point(point1);
            Point secondPoint = new Point(point2);
            int caseNumber = i+1;
            if (firstPoint.distanceToOrigin() < secondPoint.distanceToOrigin()){
                System.out.println("Case #" + caseNumber + ": " + point1[0] + " " + point1[1]);
            } else{
                System.out.println("Case #" + caseNumber + ": " + point2[0] + " " + point2[1]);
            }

        }
    }

}

// Read in some input
// first number is how many sets of points are coming.
// Everything after that is four points.

// What do I want to do
// Do I want to get a string array?
// Yes points = {"1 1 2 2", "1 0 0 100", ...}
// Once I have my array of points, I can loop through
// each element.
// What do I do when I have "1 1 2 2"?
// I need to get the first two points and then create a point object using them.
// I can put them into a Scanner object.
// Could I then take point1 is next two ints?
// loop through them. If i < 2 and them to point1, else add them to point2

// Now I have two int arrays, point1 = {1, 1} and point2 = {2, 2}


// NEW FUNTION
// Use them to points to create two point objects
// print the points that are closest to origin