import java.util.Scanner;

public class Testing {

	public static boolean isUppercase(String s){
		return s.chars().allMatch(Character::isUpperCase);
	}
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		String text = input.nextLine();
		System.out.println(isUppercase(text));
	}
}
