public class GroupSumDP {

    public static boolean groupSum(int[] ary, int target) {
        return groupSum(ary, 0, target);
    }

    public static boolean groupSum(int[] ary, int i, int target) {
        if(i == ary.length) {
            if(target == 0) {
                return true;
            } else {
                return false;
            }
        }

        if(groupSum(ary, i+1, target-ary[i])) {  // select ith element
            return true;
        }

        if(groupSum(ary, i+1, target)) {             //don't select ith select
            return true;
        }

        return false;
    }

    public static boolean groupSum2(int[] ary, int i, int target) {
        if(i == ary.length) {
            return target == 0;
        }

        return groupSum2(ary, i+1, target-ary[i]) || groupSum2(ary, i+1, target);

    }

    public static boolean groupSumDP(int[] ary, int target) {
        boolean[][] dp = new boolean[ary.length+1][target+1];

        for(int i=0; i< dp.length; i++) {
            dp[i][0] = true;           //fill all first columns
        }

        for(int t=1; t< dp[0].length; t++) {
            dp[0][t] = false;            //fill all first row
        }

        for(int i=1; i<dp.length; i++) {
            for(int t=1; t<dp[0].length; t++) {
                dp[i][t] = dp[i+1][t-ary[i]] || dp[i+1][t];  //Add addtional checks ..To be completed
            }
        }

        //debug dp table
        for(int row=0; row<dp.length; row++) {
            for(int col=0; col<dp[0].length; col++) {
                System.out.print(dp[row][col] + " ");
            }
            System.out.println();
        }

        return dp[0][target];


    }
}
