public class MaxSumInMatrixDP {
    int maxSumInPath(int[][] ary) {

        return maxSumInPath(ary, 0, 0);
    }

    int maxSumInPath(int[][] ary, int row, int col) {
        // base condition 1; only one cell (or last cell)
        if(row == ary.length-1 && col == ary[0].length-1) {
            return ary[row][col];
        }

        // base condition 2;
        if(row == ary.length-1) { //reached bottom row of the matrix
            return ary[row][col] + maxSumInPath(ary, row, col+1); // take current cell value + max value from right
        }

        // base condition 3;
        if(col == ary[0].length-1) { //reached rightmost col of the matrix
            return ary[row][col] + maxSumInPath(ary, row+1, col); // take current cell value + max value from down
        }

        /*
        //recursive case 4. Option 1
        int maxFromDown = ary[row][col] + maxSumInPath(ary, row+1, col);
        int maxFromRight =  ary[row][col] + maxSumInPath(ary, row, col+1);

        return Math.max(maxFromDown, maxFromRight);
        */

        /*
        //recursive case 4. Option 2
        int maxFromDown = maxSumInPath(ary, row+1, col);
        int maxFromRight =  maxSumInPath(ary, row, col+1);

        return ary[row][col] + Math.max(maxFromDown, maxFromRight);
        */

        return ary[row][col] + Math.max(maxSumInPath(ary, row+1, col), maxSumInPath(ary, row, col+1));

    }

    int maxSumInPathDP(int[][] ary) {
        int lastRow = ary.length-1;
        int lastCol = ary[0].length-1;

        int[][] dp = new int[ary.length][ary[0].length];  //new int[lastRow+1][lastCol+1];

        dp[lastRow][lastCol] = ary[lastRow][lastCol];  // base condition 1

        for(int col=lastCol-1; col>=0; col--) { // bdse condition 2
            //return ary[row][col] + maxSumInPath(ary, row, col+1);
            dp[lastRow][col] = ary[lastRow][col] + dp[lastRow][col+1];
        }

        for(int row=lastRow-1; row>=0; row--) {  //base condition 3
            // return ary[row][col] + maxSumInPath(ary, row+1, col);
            dp[row][lastCol] = ary[row][lastCol] + dp[row+1][lastCol];
        }

        //return ary[row][col] + Math.max(maxSumInPath(ary, row+1, col), maxSumInPath(ary, row, col+1));
        for(int row=lastRow-1; row>=0; row--) {
            for(int col=lastCol-1; col>=0; col--) {
                dp[row][col] =  ary[row][col] + Math.max(dp[row+1][col], dp[row][col+1]);
            }
        }

        return dp[0][0];
    }

}
