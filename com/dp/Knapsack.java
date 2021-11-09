import java.util.Arrays;

public class Knapsack {

    public static void main(String[] args) {
        int val[] = {50, 10, 20};
        int wt[] = {2, 5, 3};
        int W = 5;

        System.out.println("knapsack: " + knapsack(val, wt, W));
        System.out.println("knapsack DP: " + knapsackDP(val, wt, W));
    }

    private static int knapsack(int[] val, int[] wt, int W) {
        return knapsack(val, wt, wt.length, W);
    }
    private static int knapsack(int[] val, int[] wt, int i, int W) {
        if(i==0) {   //Finished processing the array
            return 0;
        }
        if(W == 0) {   //Max Weight limit reached
            return 0;
        }

        if(wt[i-1] > W) {
            return knapsack(val,wt, i-1, W);
        } else {
            return
                    Math.max(val[i-1] + knapsack(val, wt, i - 1, W - wt[i-1]),     //select
                            knapsack(val, wt, i-1, W));     //don't select
            // Return the maximum of two cases:
            // (1) nth item included
            // (2) not included

        }
        /*
        if(wt[i-1] <= W) {
            return
                    Math.max(val[i - 1] + knapsack(val, wt, i - 1, W - wt[i - 1]),     //select
                            knapsack(val, wt, i - 1, W));     //don't select
            // Return the maximum of two cases:
            // (1) nth item included
            // (2) not included
        } else {
            return knapsack(val, wt, i - 1, W);

        }
        */

        // T = O(2^n)
    }

    private static int knapsackDP(int[] val, int[] wt, int W) {
        int[][] dp = new int[wt.length+1][W+1];

        for(int i=0; i<dp.length; i++) { // optiopn for Java becaues ary is initialized to 0 by default
            dp[i][0] = 0; //base condition
        }
        for(int w=0; w<dp[0].length; w++) { // optiopn for Java becaues ary is initialized to 0 by default
            dp[0][w] = 0; //base condition
        }

        for(int i=1; i<dp.length; i++) {
            for(int ww=1; ww<dp[0].length; ww++) {
                if(wt[i-1] > ww) {
                    dp[i][ww] = dp[i-1][ww];
                } else {
                    // val[i-1] + knapsack(val, wt, i - 1, W - wt[i-1]
                    dp[i][ww] = Math.max(val[i-1] + dp[i-1][ww-wt[i-1]], dp[i-1][ww]);
                }
            }
        }

        for(int[] ary : dp) {
            System.out.println(Arrays.toString(ary));
        }
            //wt.length, W
        return dp[wt.length][W];  // or return dp[dp.length-1][dp[0].length-1];

    }

}
