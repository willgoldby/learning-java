
public class SolutionInterleaving {


// How would this work?
// What's the base case?
// What would interleaving logic even look like?
// input is two strings
// 


public static String interleave(String firstString, String secondString){
  String result = "";
  

  // What new strings do I pass to interleave in the recusive case?
  // What's the base case? When there are no more strings to pass in?

  // base case
  if ((firstString.length() == 1) || (secondString.length()== 1)){
   return firstString + secondString;
  }
  else{
  firstString = firstString.substring(0, firstString.length() - 1);
  secondString = secondString.substring(0, secondString.length() - 1);
  String result1 = result.concat(firstString); 
  String result2 =  result.concat(secondString);
  // System.out.println(firstString);
  // System.out.println(secondString);
  System.out.println("Entered recursive section");
  return interleave(result1, result2) + interleave(result1, result2);
  }   

}



//   An interleaving of two strings is a string composed of the characters in each of the input strings while preserving the order in which the characters appeared in the original strings.
//   For example, "abc" and "123" can be interleaved as "a1b2c3" or "abc123" or "ab1c23" or many other permutations. But "12ba3c" is not an interleaving of "abc" and "123" since 'a' and 'b' do not appear in the original order.
//   Your task is to implement a function that prints out all the possible interleavings of two input strings without repeated characters. Each character from each input string should appear exactly one time in the output but if a particular interleaving would result in identical neighboring characters, you should not output the string (see example below for clarification).
//   With an input of "abc" and "123" that would just be all interleavings of those two strings but with "abc" and "cab" as input, the output would be:
//   abcabc
//   acbacb
//   acbabc
//   abcacb
//   cabcab
//   cababc
//   acbcab
//   acabcb
//   cabacb
  
//   Note that "caabcb" (and others like "abccab") is not included in the output since it includes a repeated 'a'.
//   For full credit, don't just generate all interleavings and then filter out the ones with repeated characters but change your recursion logic (that's a hint!) to only generate interleavings without repeated characters.
  

public static String leave(String input1, String input2){
  if ((input1.length() == 1) && (input2.length() == 1)){
    String result = "";
    result = input1 + input2;
    return result;
  }
  else{
    String firstStringWithFirstCharRemoved = input1.substring(1, input1.length());
    String secondStringWithFirstCharRemoved = input2.substring(1, input2.length());
    String firstStringWithLastCharRemoved = input1.substring(0, input1.length() - 1);
    String secinStringWithLastCharRemoved = input2.substring(0, input2.length() - 1);
    return leave(firstStringWithFirstCharRemoved, secondStringWithFirstCharRemoved) + leave(firstStringWithLastCharRemoved, secinStringWithLastCharRemoved); 
  }
}

public static String leaveV2(String input1, String input2){
  if ((input1.length() == 1) && (input2.length() == 1)){
    String result = "";
    result = input1 + input2;
    return result;
  }
  else{
    // remove last char from input and interleave it and add to the interleave of the rest of the string

    String firstInputLastCharRemoved = input1.substring(0,input1.length()-1);
    String secondInputLastCharRemoved = input2.substring(0, input2.length()-1);
    String firstInputLastChar = input1.substring(input1.length()-1, input1.length());
    String secondInputLastChar= input2.substring(input2.length()-1, input2.length());
    System.out.println("flcr: " + firstInputLastCharRemoved);
    System.out.println("slcr: " + secondInputLastCharRemoved);
    System.out.println("flc: " + firstInputLastChar);
    System.out.println("slc: " + secondInputLastChar);

    return leaveV2(firstInputLastCharRemoved, secondInputLastCharRemoved) + leaveV2(firstInputLastChar, secondInputLastChar);
    }
  }



  public static void main(String[] args){
    // String result = interleave("abc","cba");
    // System.out.println(result);
    String result = leaveV2("abc", "123");
    System.out.println(result);
  }
  
}
