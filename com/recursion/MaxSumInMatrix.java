package com.recursion;


public class MaxSumInMatrix {
  private static class TestCase {
    public TestCase(int[][] a, int r) {
      array = a;
      result = r;
    }
    int result;
    int[][] array;
  }

  private static int[][] arr1 = {{9}};
  private static int[][] arr2 = {{1, 2, 3}};
  private static int[][] arr3 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
  private static int[][] arr4 = {{2, 2, 1, 1, 1}, {1, 2, 1, 1, 1}, {1, 2, 2, 1, 1}, {1, 1, 2, 2, 1}, {1, 1, 1, 2, 2}};

  private static TestCase tests[] = {
      new TestCase(arr1, 9),
      new TestCase(arr2, 6),
      new TestCase(arr3, 29),
      new TestCase(arr4, 18),
  };

public static void main(String args[]) {
  int result;
  int errors = 0;
  for(int i = 0; i < tests.length; ++i) {
    result = maxSumInMatrix(tests[i].array);
    if (result != tests[i].result) {
      System.out.println(
          "Error: Best path of test case number " + i + " is " + tests[i].result + ". Got " + result + " instead");
      errors++;
    }
  }

  if (errors > 0)
    System.out.println("Got " + errors + " errors");
  else
    System.out.println("Good work");

}


  static int maxSumInMatrix(int[][] matrix) {
    return maxSumInMatrix(matrix, 0, 0);
  }

  static int maxSumInMatrix(int[][] matrix, int row, int col) {
      if(row == matrix.length-1 && col == matrix[0].length-1) { //base condition 1 -- last cell
          return matrix[row][col];
      }

      if(row == matrix.length-1) { //base condition 2 -- end of row
        return matrix[row][col] + maxSumInMatrix(matrix, row, col+1);
      }

      if(col == matrix[0].length-1) { //base condition 3 -- end of column
        return matrix[row][col] + maxSumInMatrix(matrix, row+1, col);
      }

      int rightSum = matrix[row][col] + maxSumInMatrix(matrix, row, col+1);
      int downSum = matrix[row][col] + maxSumInMatrix(matrix, row+1, col);

      return Math.max(rightSum, downSum);

  }
}
