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

    for(int row = 0; row < matrix.length; row++) {
      for(int col = 0; col < matrix[0].length; col++) {
        if(matrix[row][col] == 1) { //not visited
          dfs(matrix, row, col);
          count++;
        }
      }
    }


    return count;
  }

  private static void dfs(int[][] matrix, int row, int col) {
    matrix[row][col] = -1; //mark as visited
    for(int dir = 0; dir<directions.length; dir++) {
      int rowDirection = row + directions[dir][0];
      int colDirection = col + directions[dir][1];
      //add isSafe
      if(matrix[rowDirection][colDirection] == 1) {  //not visited and it is not a 0
        dfs(matrix, rowDirection, colDirection);
      }
    }

  }


}
