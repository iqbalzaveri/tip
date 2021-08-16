import java.util.ArrayList;
import java.util.List;

public class StringDecomposition {

    public static void main(String[] args) {
        String str = "apple";
        /*
        // n ^2   ; but because of substring and print n^3
        for (int start = 0; start < str.length(); start++) {
            for (int end = start + 1; end < str.length() + 1; end++) {
                String subStr = str.substring(start, end);  //end is exclusive
                System.out.print(subStr + "|");
            }
            System.out.println();
        }
        */
        printSubStringSets(str);
    }
        //subset string combination
        /*
        apple
        a p p l e
        a pp l e
        a ppl e
        a pple
        ap p l e
        app l e

         */

        static void printSubStringSets(String str) {
            List<String> resultList = new ArrayList<>();
            printSubStringSets(str, 0, resultList);
        }

        static void printSubStringSets(String str, int start, List<String> resultList) {
            if(start == str.length()) {
                System.out.println("result: " + resultList);
                return;
            }

            for(int end = start+1; end< str.length()+1; end++) {
                String subStr = str.substring(start, end);
                resultList.add(subStr);
                printSubStringSets(str, end, resultList);
                resultList.remove(resultList.size()-1); // remove last element ie backtrack
            }

/*
list
0 - h
1 - e
2 - o
result.size() => 3
result.size()-1 => 2  // get the index of last element
resultList.remove(2) ie remove last element

 */
        }


}
