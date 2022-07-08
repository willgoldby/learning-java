import java.util.Scanner;

public class Solution {
    
    public static void main(String[] args){
        studentReportCard();
    }

    // Create Students from input and print report card
    public static void studentReportCard(){
        Scanner input = new Scanner(System.in);
        String[] nameAndGrades = new String[input.nextInt()];
        // Consume \n
        
        input.nextLine();
        String firstName;
        String lastName;
        int grade1;
        int grade2;
        int grade3;

        for (int i = 0; i < nameAndGrades.length; i++){
            nameAndGrades[i] = input.nextLine();
        }
        int cas = 0;
        // Now I have all my data in a string array
        // Loop through data, create student, print report card
        for (int j = 0; j < nameAndGrades.length; j++){
            String data = nameAndGrades[j];
            String[] dataSplit = data.split(" ");
            firstName = dataSplit[0];
            lastName = dataSplit[1];
            grade1 = Integer.parseInt(dataSplit[2]);
            grade2 = Integer.parseInt(dataSplit[3]);
            grade3 = Integer.parseInt(dataSplit[4]);
            Student stud = new Student(firstName, lastName, grade1, grade2, grade3);
            // Update the case number
            cas = cas + 1;

            //print "Case #" without newline
            System.out.print("Case #" + cas + ": ");
            System.out.println(stud.reportCard());

        }
    }
}



// 