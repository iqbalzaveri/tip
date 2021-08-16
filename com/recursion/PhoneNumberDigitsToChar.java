import java.util.HashMap;
import java.util.Map;

public class PhoneNumberDigitsToChar {

    static int[] phoneDigits = {2,3,5};

    static Map<Integer, String> map = new HashMap<>();
    static {
        map.put(1, "");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno"); //..


    }

    public static void main(String[] args) {
        printInChar(phoneDigits);
    }
    static public void printInChar(int[] phoneDigits) {
        String result = "";
        printInChar(phoneDigits, result, 0);

    }

    static public void printInChar(int[] phoneDigits, String result, int i) {
        if(i == phoneDigits.length) {
            System.out.println(result);
            return;
        }

        String chars = map.get(phoneDigits[i]);  //for eg for digit 2 chars would be "abc"
        for(int c=0; c<chars.length(); c++) { // go over "abc", a , b,  c
            char ch = chars.charAt(c);
//            result += ch; // "a", "d", "j"
//            printInChar(phoneDigits, result, i+1);
//            result = result.substring(0, result.length()-1); //backtrack, remove last char
            printInChar(phoneDigits, result+ch, i+1);   //implicit backtracking
        }

        return;
    }

}
