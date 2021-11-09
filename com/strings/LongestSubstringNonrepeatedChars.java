import java.util.HashSet;
import java.util.Set;

public class LongestSubstringNonrepeatedChars {
  public static void main(String[] args) {
    //String str = "abcadefc";
    String str = "abcadef";

    String longestSubstrNonrepeatedChars = getLongestSubstrNonrepeatedChars(str);
    System.out.println("result: " + longestSubstrNonrepeatedChars);
  }

  private static String getLongestSubstrNonrepeatedChars(String str) {
    Set<Character> charSet = new HashSet<>();
    int left = 0;
    String res = "";
    int max_lenth = Integer.MIN_VALUE;

    for(int right=0; right<str.length(); right++) {
      char ch = str.charAt(right);

      if (!charSet.contains(ch)) { //not seen ch; not repeating
        charSet.add(ch);
      } else { // seen ch; ie repeating
        //create new candidate substring
        if (right - left > max_lenth) {
          res = str.substring(left, right); //endIndex is exclusive
          max_lenth = right - left;
        }

        while (left < right && str.charAt(left) != ch) {
          charSet.remove(ch);
          left++;
        }
        left++;

      }
    }// end of for loop

      //If rest of the string is a candidate greater than max lenght
      if(str.length()-left > max_lenth) {
        res = str.substring(left, str.length());
      }


    return res;
  }
}
