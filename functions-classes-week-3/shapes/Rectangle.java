import java.util.Arrays;

public class Rectangle {
    // What?
    // Create a rectangle from two points. 
    Point lowerLeft;
    Point upperRight;
    Point upperLeft;
    Point lowerRight;

    public Rectangle(Point point1, Point point2, Point point3){
        
        // get all the points
        // Find lowerLeft point
        // 1. I need the smallest x and the smallest y
        int[] xValues = new int[3];
        int[] yValues = new int[3];
        xValues[0] = point1.xCor;
        xValues[1] = point2.xCor;
        xValues[2] = point3.xCor;

        yValues[0] = point1.yCor;
        yValues[1] = point2.yCor;
        yValues[2] = point3.yCor;

        Arrays.sort(xValues);
        Arrays.sort(yValues);

        int smallestX = xValues[0];
        int smallestY = yValues[0];
        int largestX = xValues[2];
        int largestY = yValues[2];
        
        this.lowerLeft = new Point(smallestX, smallestY);
        this.upperLeft = new Point(smallestX, largestY);
        this.upperRight = new Point(largestX, largestY);
        this.lowerRight = new Point(largestX, smallestY);

        
    }

    public double area(){
        Segment segA = new Segment(lowerLeft, upperLeft);
        Segment segB = new Segment(upperLeft, upperRight);
        double segALength = segA.segLength();
        double segBLength = segB.segLength();
        double result = segALength * segBLength;
        return result;

    }

    public double perimeter(){
        Segment segA = new Segment(lowerLeft, upperLeft);
        Segment segB = new Segment(upperLeft, upperRight);
        Segment segC = new Segment(upperRight, lowerRight);
        Segment segD = new Segment(lowerLeft, lowerRight);
        double segALength = segA.segLength();
        double segBLength = segB.segLength();
        double segCLength = segC.segLength();
        double segDLength = segD.segLength();
        double result = segALength + segBLength + segCLength + segDLength;
        return result;
    }





}


// int[] arr = {a, b, c};
// Arrays.sort(arr);
// int min = arr[0];
// int max = arr[2];