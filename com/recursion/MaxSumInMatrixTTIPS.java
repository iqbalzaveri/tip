public class MaxSumInMatrixTTIPS {

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
}
