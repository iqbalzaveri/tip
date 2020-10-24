package com.dp;

/*
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character

e.g. Minimum edit distance between the words 'kitten' and 'sitting', is 3

kitten -> sitten (substitution of "s" for "k")
sitten -> sittin (substitution of "i" for "e")
sittin -> sitting (insertion of "g" at the end).
 

(Assume all inputs and substitutions in lower case)

More about Levenshtein Distance: https://en.wikipedia.org/wiki/Levenshtein_distance

Solution: http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/

 
 */
public class EditDistanceMin {

	public static void main(String[] args) {
		String str1 = "sun";
		String str2 = "sun";
		
		System.out.println("edit distance: " + editDistance(str1,str2, str1.length(), str2.length()));
		System.out.println("edit distancess: " + editDistanceDP(str1,str2));
	}

	private static int editDistanceDP(String str1, String str2) {
		int[][] dp = new int[str1.length()+1][str2.length()+1];
		
		//if s1 is 0
		for(int i=0; i<dp[0].length; i++) {
			dp[0][i] = i;
		}
		//if s2 is 0
		for(int i=0; i<dp.length; i++) {
			dp[i][0] = i;
		}
		
		for(int s1=1; s1<dp.length; s1++) {
			for(int s2=1; s2<dp[0].length; s2++) {
				if(str1.charAt(s1-1) == str2.charAt(s2-1)) {
					dp[s1][s2] = dp[s1-1][s2-1];
				} else {
					dp[s1][s2] = 1 + min(dp[s1][s2-1], 
							dp[s1-1][s2],
							dp[s1-1][s2-1]);
				}
				
			}
		}
		
		printDistSlightlyWrong(str1, str2, dp);
		return dp[dp.length-1][dp[0].length-1];
	}

	private static int editDistance(String str1, String str2, int s1, int s2) {
		if(s1 == 0) {
			return s2;
		}
		if(s2 == 0) {
			return s1;
		}
		
		if(str1.charAt(s1-1) == str2.charAt(s2-1)) {
			return editDistance(str1, str2, s1-1, s2-1);
		}
		
		return 1 + min(
				editDistance(str1, str2, s1, s2-1),  //Insert
				editDistance(str1, str2, s1-1, s2),  //Delete
				editDistance(str1, str2, s1-1, s2-1)  //Replace
				);
	}
	
	private static int min(int x, int y, int z) {
		if(x < y && x < z) {
			return x;
		}
		if(y < x && y < z) {
			return y;
		}
		return z;
	}
	
	private static void printDistSlightlyWrong(String left, String right, int array[][]) {
        int i = 1;
        int j = 1;
        System.out.println(left);
        System.out.println(right);
        int lLength = left.length();
        int rLength = right.length();
        while (i != lLength || j < rLength) {
            if (j >= rLength) {
                System.out.println(i + ": delete " + left.charAt(i-1));
                i++;
                continue;
            }
            if (i >= lLength) {
                System.out.println(j + ": add " + right.charAt(j-1));
                j++;
                continue;
            }
            if (array[i][j] == array[i][j - 1] + 1) {
                System.out.println(i + ": add " + right.charAt(j-1));
                j++;
            } else if (array[i][j] == array[i - 1][j] + 1) {
                System.out.println(i + ": delete " + left.charAt(i-1));
                i++;
            }
            else if (array[i][j] != array[i - 1][j - 1]) {
                System.out.println(i + ": replace " + left.charAt(i-1) + " with " + right.charAt(j-1));
                i++;
                j++;
            }
            else {
                //System.out.println(i + ": move (" + right.charAt(j-1) + ")");
                i++;
                j++;
            }
        }
        //return array[0][0];
	}
	
}
