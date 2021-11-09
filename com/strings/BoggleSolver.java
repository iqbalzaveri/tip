
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class BoggleSolver {

  static class TrieNode {
    char ch;
    Map<Character, TrieNode> map;
    boolean isWord;

    TrieNode(char c) {
      this.ch = c;
      map = new HashMap<>();
    }
  } // end of Trienode

  static class Trie {

    TrieNode root;

    Trie() {
      root = new TrieNode((char) 0);
    }

    void add(String word) { //apple - a, p
      TrieNode t = root;
      for (int i = 0; i < word.length(); i++) {
        char ch = word.charAt(i);
        TrieNode child = t.map.get(ch);
        if (child == null) {
          child = new TrieNode(ch);
          t.map.put(ch, child);
        }
        t = child;
      } // end of for loop - processed all chars of word
      t.isWord = true;
    }

    boolean startsWith(String prefix) {
      TrieNode t = root;
      for(int i=0; i<prefix.length(); i++) {
        char ch = prefix.charAt(i);
        TrieNode child = t.map.get(ch);
        if(child == null) {
          return false;
        }
        t = child;
      } // end of for loop
      return true;
    }

    boolean search(String word) { //"axe"
      /*
      a
      |
      x
      |
      e
       */
      TrieNode t = root;
      for(int i=0; i<word.length(); i++) {
        char ch = word.charAt(i);
        TrieNode child = t.map.get(ch);
        if(child == null) {
          return false;
        } else {
          if(child.isWord && i==word.length()-1) {
            return true;
          }
        }

        t = child;
      } // end of for loop

      return false;
    }
  }// end of Trie class

  // TL, T, TR, BL, B, L, BR, R
  static int[] rows = {-1, -1, -1,  1, 1, 0,  1, 0};
  static int[] cols = {-1,  0,  1, -1, 0, -1, 1, 1};

  public static void main(String[] args) {
    char[][] board =  {
      {'B', 'P' , 'E', 'A'},
      {'X', 'R' , 'A', 'D'},
      {'Z', 'A' , 'Y', 'T'},
    };

    String[] dict = {"BREAD", "XRAY", "MOM", "DAD"};

    boggleSolver(board, dict);

  }

  private static void boggleSolver(char[][] board, String[] dict) {
    HashSet<String> set = new HashSet<>();
    for(String word : dict) {
      set.add(word);
    }

    Trie trie = new Trie();
    for(String word : dict) {
      trie.add(word);
    }

    boolean[][] isVisited =  new boolean[board.length][board[0].length];
    StringBuilder strBuilder = new StringBuilder();
    for(int r=0; r < board.length; r++) {
      for(int c=0; c < board[0].length; c++) {
        if(!isVisited[r][c]) {
          dfs(r, c, board, strBuilder, set, isVisited);
          //dfsTrie(r, c, board, strBuilder, trie, isVisited);
        }
      }
    }
  }

  private static void dfs(int r, int c, char[][] board, StringBuilder strBuilder,
      HashSet<String> set, boolean[][] isVisited) {
    // mark isVisited
    isVisited[r][c] = true;

    // process the node
    strBuilder.append(board[r][c]);
    if(set.contains(strBuilder.toString())) {
      System.out.println(strBuilder.toString());
    }

    // dfs on neighbor nodes
    for(int i=0; i<8; i++) { //all 8 directions
      int nextRow = r + rows[i];
      int nextCol = c + cols[i];
      if(isValid(nextRow, nextCol, board)) {  //check boundaries; implement later.
        if(!isVisited[nextRow][nextCol]) {
          dfs(nextRow, nextCol, board, strBuilder, set, isVisited);
        }
      }
    }

    strBuilder.deleteCharAt(strBuilder.length()-1); //backtrack; remove last character
    isVisited[r][c] = false; //backtrack to consider in the next path; usually we don't do this in other graph problems
  }

  private static void dfsTrie(int r, int c, char[][] board, StringBuilder strBuilder,
      Trie trie, boolean[][] isVisited) {
    // mark isVisited
    isVisited[r][c] = true;

    // process the node
    strBuilder.append(board[r][c]);
    if(trie.startsWith(strBuilder.toString())) {
      if(trie.search(strBuilder.toString())) {
        System.out.println(strBuilder.toString());
      }

      // dfs on neighbor nodes
      for(int i=0; i<8; i++) { //all 8 directions
        int nextRow = r + rows[i];
        int nextCol = c + cols[i];
        if(isValid(nextRow, nextCol, board)) {  //check boundaries; implement later.
          if(!isVisited[nextRow][nextCol]) {
            dfsTrie(nextRow, nextCol, board, strBuilder, trie, isVisited);
          }
        }
      }
    } // end of trie startsWith
    strBuilder.deleteCharAt(strBuilder.length()-1); //backtrack; remove last character
    isVisited[r][c] = false; //backtrack to consider in the next path; usually we don't do this in other graph problems
  }

  private static boolean isValid(int nextRow, int nextCol, char[][] board) {
    if(nextRow < 0 || nextCol < 0 || nextRow >= board.length || nextCol >= board[0].length) {
      return false;
    }
    return true;
  }
}
