public class Segment {
    Point point1;
    Point point2;

    public Segment(Point point1, Point point2){
        this.point1 = point1;
        this.point2 = point2;
    }

    public double segLength(){
        double firstSolution =  Math.pow((this.point1.xCor - this.point2.xCor), 2);
        double secondSolution =  Math.pow((this.point1.yCor - this.point2.yCor), 2);
        double result =  Math.sqrt((firstSolution + secondSolution)); 
        return result;
    }
    
}
