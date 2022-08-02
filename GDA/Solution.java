import java.util.Set;

public class Solution{

  public static String[] findTargetWords(String[] input){
    // 1. Loop over list
    // 2. Count consanants
    // 3. If count is greater then previous count,
    //    make it the new word.
    // 4. Count vowels
    // 5. If count is greater than previous word, make
    //    it the new word.
    // 6. Count number of non-vowel and non-constant characters.
    // 7. If count is greater than previous count, set that as the new
    //    word.
   int consanantCount = 0;
   int consanantIndex = 0;
    for (int i = 0; i < input.length; i++){
     int consanantResult = countConsonants(input[i]);
     if (consanantResult > consanantCount){
      consanantIndex = i;
      consanantCount = consanantResult;
     } 
    }
    return new String[] {input[consanantIndex], input[0], input[0]};

  }

  
  public static int countConsonants(String word){
    // 1. Loop over characters.
    // 2. If char is constant, add it to count
    // 3. return int of count.
    Set<String> CONSONANTS =  Set.of("B", "C", "D", "F", "G", "H", "J", "K", "L", "M", "N", "P", "Q", "R", "S", "T", "V", "W", "X", "Z");
    int count = 0;
    String[] characters = word.split("|.");
    for (String character: characters){
      String stringUpper = character.toUpperCase();
      if (CONSONANTS.contains(stringUpper)){
        count = count + 1;
      }
    }
    return count; 
  }


public static void main(String[] args){
  String[] result;
  result = findTargetWords(new String[] {"strengths", "ant 1", "turkey", "facetious"});
}

}

// Given an array of strings, write a function that returns three strings:
//  1. the string with the most consonants, 
//  2. the string with the most vowels 
//  3. and the string with the most characters that are neither vowels nor consonants. 
 
 
//  You can assume only ascii characters in the input strings. For simplicity, we'll consider "aeiouy" to be the only vowels for this exercise and ignore accented letters.
// // If two words are tied for one of these criteria, return the word that would appear first in the dictionary (a.k.a. lower lexicographic order)
// // For example:
// // ["strengths", "ant 1", "turkey", "facetious"] → ["strengths", "facetious", "ant 1"]
// // ["cat", "oat"] → ["cat", "oat", "cat"] 
// // You are allowed (and encouraged) to write helper functions but please try to reuse code as much as possible. 
// // Sample starter code is available in Java but feel free to use a different programming language.