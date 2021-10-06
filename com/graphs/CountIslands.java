package com.graphs;

public class CountIslands {
  // pair of row & col
  // 0th element is row
  // 1st element is column
  static int[][] directions = {
      {-1,0}, //up
      {1,0}, //down
      {0,-1}, //left
      {0,1}, //right
      {-1,-1}, //up left
      {1,1}, //down right
      {1,-1}, //down left
      {-1,1} //up right
  };
  public static void main(String[] args) {
    int[][] matrix = {
        {1,1,0,0,0},
        {0,1,0,0,1},
        {1,0,0,1,1},
        {0,0,0,0,0},
        {1,0,1,0,1}
    };

    System.out.println("count:" + countIslands(matrix));

  }

  static int countIslands(int[][] matrix) {
    int count = 0;

    for(int row = 0; row < matrix.length; row++) { //for each node/vertex in graph
      for(int col = 0; col < matrix[0].length; col++) {
        if(matrix[row][col] == 1) { //not visited (1 also mean a vertex)
          dfs(matrix, row, col);
          count++; //count number of connected components
        }
      }
    }


    return count;
  }

  private static void dfs(int[][] matrix, int row, int col) {
    matrix[row][col] = -1; //mark as visited
    for(int i = 0; i<directions.length; i++) { // Get all neighbors
      int newRow = row + directions[i][0];  //neigbhor row
      int newCol = col + directions[i][1]; //neigbhor col
      //add isSafe
      if(isValid(matrix, newRow, newCol) && matrix[newRow][newCol] == 1) {  //not visited and it is not a 0
        dfs(matrix, newRow, newCol);
      }
    }
    /*
    either use the above direction trick OR

    int newRow = row + 1;
    int newCol = col; //up
    if(isValid(matrix, newRow, newCol) && matrix[newRow][newCol] == 1)
          dfs(matrix, newRow, newCol);
    }
     newRow = row - 1;
     newCol = col; //down
    if(isValid(matrix, newRow, newCol) && matrix[newRow][newCol] == 1)
          dfs(matrix, newRow, newCol);
    }

     newRow = row -1 ;
     newCol = col -1; //up left
    if(isValid(matrix, newRow, newCol) && matrix[newRow][newCol] == 1)
          dfs(matrix, newRow, newCol);
    }


    ... total 8 statements


     */

  }

  static boolean isValid(int[][] matrix, int r, int c) {
    if(r < 0 || r >= matrix.length || c < 0 || c >= matrix[0].length) {
      return false;
    }
    return true;
  }

}
