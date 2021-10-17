import java.util.Arrays;

public class MinEditDistanceLenToZero {
    public static void main(String[] args) {
        String str1 = "red";
        String str2 = "bet";

        int minDist = minDist(str1, str2);
        System.out.println("minDist: " + minDist);

        minDistDP(str1, str2);
        System.out.println("minDist DP: " + minDist);

    }
    private static int minDist(String str1, String str2) {
        return minDist(str1, str2, str1.length(), str2.length());
    }

    private static int minDist(String str1, String str2, int s1, int s2) {
        //base condition  -- 1
        if(s1 == 0) {
            return s2;
        }

        if(s2 == 0) {
            return s1;
        }
/*
be
bed

be@  --insertion
bed

be
be



 */
        // no-op  -- 2
        if(str1.charAt(s1-1) == str2.charAt(s2-1)) {  // chars are equal
            return minDist(str1, str2, s1-1, s2-1);
        }

        // operation -- 3 ; chars are not equal
        return 1 + min(
        minDist(str1, str2, s1, s2-1),       //Insert
        minDist(str1, str2, s1-1, s2-1),       //Replace
        minDist(str1, str2, s1-1, s2)       //Delete
        );
    }

    static int min(int x, int y, int z) {
        //Math.min(Math.min(x,y),z);
        if(x < y && x < z) {
            return x;
        }
        if(y < x && y < z) {
            return y;
        }
        return z;
    }

    private static int minDistDP(String str1, String str2) {
        int[][] dp = new int[str1.length()+1][str2.length()+1];

        //if s1 == 0  base case
        for(int i=0; i<dp[0].length; i++) {
            dp[0][i] = i;
        }

        //if s2 == 0  base case
        for(int i=0; i<dp.length; i++) {
            dp[i][0] = i;
        }

        for(int s1=1; s1<dp.length; s1++) {
            for(int s2=1; s2<dp[0].length; s2++) {
                if(str1.charAt(s1-1) == str2.charAt(s2-1)) {
                    dp[s1][s2] = dp[s1-1][s2-1];
                } else {
                    dp[s1][s2] = 1 + min(dp[s1][s2-1], dp[s1-1][s2-1], dp[s1-1][s2]);  // Ins, Rep, Del
                }
            }
        }
        for(int[] ary : dp) {
            System.out.println(Arrays.toString(ary));
        }
        return dp[str1.length()][str2.length()]; // dp[dp.length-1][dp[0].length-1];
    }

}
