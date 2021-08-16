public class IsPalindrome {

    // isPaln("racecar");
    // isPalin("abc"
    // isPalin("a"
    // str = "aaaaaaaaaaabcaaaaaaaaaaaaaa"
    /*
    boolean isPalin(String str) {
        if(str.length() == 0 || str.length() == 1) {   //str.length <= 1  // base case
            return true;
        }

        //recurse case
        if(str.charAt(0) == str.charAt(str.length()-1)) {
            return isPalin(str.substring(1, str.length()-1)); //if length is 5 then str.substring(1, 4); endpos is exclusive
        }

        return false;
    }
    */

    /*
   r/c  0   1   2   3
   0    4   2   3   3
   1    1   2   1   4
   2    2   1   6   2



     */
    /*
    boolean isPalin(String str) {
        return isPalin(str, 0, str.length()-1);

    }

    boolean isPalin(String str, int start, int end) {

    }

    boolean isPalindrome(String str) {
        return isPalindrome_helper(str, 0, str.length()-1);

    }

    boolean isPalindrome_helper(String str, int start, int end) {

    }
    */
}
