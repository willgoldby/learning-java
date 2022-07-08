public class Student {

    String firstName;
    String lastName;
    int grade1;
    int grade2;
    int grade3;

    // Constructor for Student
    public Student(String firstName, String lastName, int grade1, int grade2, int grade3){
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade1 = grade1;
        this.grade2 = grade2;
        this.grade3 = grade3;
    }


    // Return average of all three grades
    public float avgGrade(){
        float divisor = 3.0f;
        float average = (grade1 + grade2 + grade3) / divisor; 
        return average;
    }

    // Return full name
    public String fullName(){
        String lastNameFirstName = this.lastName + ", " + this.firstName;
        return lastNameFirstName;
    }
    
    // Print report card
    public String reportCard(){
        String fullName = fullName();
        String grades = Integer.toString(grade1) + ", " + Integer.toString(grade2) + ", " + Integer.toString(grade3);
        String formatAvgToString = String.format("%.1f", avgGrade());
        String avg = "(" + "avg: " + formatAvgToString + ")";
        String result = fullName + ": " + "Grades: [" +  grades + "] " + avg;
        return result;
    }
}
