public class Triangle {
    Point point1;
    Point point2;
    Point point3;
    
    public Triangle(Point point1, Point point2, Point point3){
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    public double area(){
        //double trapOneArea = .5 * (point2.yCor + point1.yCor) * (point1.xCor - point2.xCor);
        //double trapTwoArea = .5 * (point1.yCor + point3.yCor) * (point3.xCor - point1.xCor);
        //double trapThreeArea = .5 * (point2.yCor + point3.yCor) * (point3.xCor - point2.xCor);
        //return trapOneArea + trapTwoArea + trapThreeArea;
        double result = (.5) * ((point1.xCor * (point2.yCor - point3.yCor)) + (point2.xCor * (point3.yCor - point1.yCor)) + (point3.xCor* (point1.yCor - point2.yCor)));
        return Math.abs(result);
    }

    public double perimeter(){
        Segment seg1 = new Segment(this.point1, this.point2);
        Segment seg2 = new Segment(this.point2, this.point3);
        Segment seg3 = new Segment(this.point1, this.point3);
        double seg1Length = seg1.segLength();
        double seg2Length = seg2.segLength();
        double seg3Length = seg3.segLength();
        double result = seg1Length + seg2Length + seg3Length;
        return result;

    }

    
    // Get lowerLeft and upperRight point in order to pass to Rectangle



    //public Rectangle createRectangle(){
        // What do I need to create the rectangle?
        // Find the lowest point and most left point
        // Find the highest point and the most right point.
        // How?
        // What do I know? I have three points
        
        // 1. Find smallest x value.
        // 2. Find smallest y value.
        // 3. Save these as lowerLeft point.

        // 1. Find largest x value
        // 2. Find largetst y value
        // 3. Save these as upperRight point

        // Now what?
        // Use these two point to create a rectangle
    //}
    
}
