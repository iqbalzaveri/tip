import java.util.Arrays;

public class HouseRobbery {
    public static void main(String[] args) {
        int[] aryHouseValues = {6, 1, 2, 7};

        System.out.println("Max: " + maxStolenValue(aryHouseValues));
        System.out.println("Max With dp: " + maxStolenValueDP(aryHouseValues));
    }

    private static int maxStolenValue(int[] aryHouseValues) {
        return maxStolenValue(aryHouseValues, 0);
    }

    private static int maxStolenValue(int[] aryHouseValues, int i) {
        if(i >= aryHouseValues.length) {
            return 0;
        }
//        if(i == aryHouseValues.length) { //i+1
//            return 0;
//        }
//        if(i == aryHouseValues.length+1) { //i+2
//            return 0;
//        }

        return Math.max(aryHouseValues[i] + maxStolenValue(aryHouseValues, i+2), maxStolenValue(aryHouseValues, i+1));
        // T = O(2^n)
    }

    private static int maxStolenValueDP(int[] aryHouseValues) {
        int[] dp = new int[aryHouseValues.length + 2];
        dp[dp.length-1] = 0;  //base condition
        dp[dp.length-2] = 0; //base condition

        for(int i = dp.length-3; i >= 0; i-- ) {
            dp[i] = Math.max(aryHouseValues[i] + dp[i+2], dp[i+1]);
        }
        System.out.println("dp table: " + Arrays.toString(dp));
        return dp[0];
        // T = O(n)
        // S = O(n)
    }

    private static int maxStolenValueDP2(int[] aryHouseValues) {
        //complete for HW using constant Space

        return -1;

    }
}
