import java.util.Arrays;

public class CountStarirsNumOfWays {

    public static void main(String[] args) {
        int stairs = 5;
        System.out.println("no of ways: " + countNoOfWays(stairs));
        System.out.println("no of ways w/DP: " + countNoOfWaysDP(stairs));

    }

        // Can take 1 or steps
    private static int countNoOfWays(int stairs) {

        //base case
        if(stairs == 0) {
            return 1;
        }
        if(stairs < 0) {
            return 0;
        }

        return countNoOfWays(stairs-1) + countNoOfWays(stairs-2);
        // T = O(2^n)
    }

    private static int countNoOfWaysDP(int stairs) {
        int[] dp = new int[stairs+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int st= 2; st<dp.length; st++) {
            dp[st] = dp[st-1] + dp[st-2];
        }
        System.out.println("dp: " + Arrays.toString(dp));
        return dp[stairs];

        // T = O(n)
        // S = O(n) -- can we optimized this? yes with 2 varialbes

        // Another variable where steps is dynamic for given int[] steps = {1 ,2...}
        // T = O(m*n) or O(stairs*steps.length)
        // S = O(m*n) or O(stairs*steps.length) - double dimension array, can we do this in constant space?? No, why?
        // because steps is unknown

    }
}
