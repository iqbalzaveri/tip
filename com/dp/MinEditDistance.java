package com.dp;

import java.util.Arrays;

public class MinEditDistance {
    public static void main(String[] args) {
      String str1 = "red";
      String str2 = "bet";

      int minDist = minDist(str1, str2);
      System.out.println("minDist: " + minDist);
      int minDistDP = minDistDP(str1, str2);
      System.out.println("minDistDP: " + minDistDP);

    }

  private static int minDist(String str1, String str2) {
      return minDist(str1,str2, 0, 0);
  }

  private static int minDist(String str1, String str2, int s1, int s2) {
      if(s1 == str1.length()) { //base case 1
        return str2.length()-s2;
      }
      if(s2 == str2.length()) {  //base case 2
        return str1.length()-s1;
      }
      //none of operations apply
      if(str1.charAt(s1) == str2.charAt(s2)) {
          return minDist(str1, str2, s1+1, s2+1);
      }

      return 1 +
          min(
              minDist(str1, str2, s1, s2+1) ,   //Insert
              minDist(str1, str2, s1+1, s2+1),    //Replace
              minDist(str1, str2, s1+1, s2)     //Delete
          );

  }

  private static int minDistDP(String str1, String str2) {
    int[][] dp = new int[str1.length()+1][str2.length()+1];

    //base case 1
    for(int s2=str2.length(); s2>=0; s2--) {
      dp[str1.length()][s2] = str2.length()-s2;
    }
    //base case 2
    for(int s1=str1.length(); s1>=0; s1--) {
      dp[s1][str2.length()] = str1.length()-s1;
    }

    for(int s1 = str1.length()-1 ; s1>=0; s1--) {
      for(int s2 = str2.length()-1 ; s2>=0; s2--) {
        if(str1.charAt(s1) == str2.charAt(s2)) {
          dp[s1][s2] = dp[s1+1][s2+1];
        } else {
          dp[s1][s2] = 1 + min(dp[s1][s2+1], dp[s1+1][s2+1], dp[s1+1][s2]);
        }
      }
    }

    return dp[0][0];
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



}
