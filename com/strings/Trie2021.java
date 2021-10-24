import java.util.HashMap;
import java.util.Map;

public class Trie2021 {
  static class TrieNode {
    char ch;
    Map<Character, TrieNode> map;
    boolean isWord;

    TrieNode(char c) {
      this.ch = c;
      map = new HashMap<>();
    }
  }
  static class Trie {
    TrieNode root;

    Trie() {
      root = new TrieNode((char)0);
    }

    void add(String word) { //apple - a, p
      TrieNode t = root;
      for(int i=0; i<word.length(); i++) {
        char ch = word.charAt(i);
        TrieNode child = t.map.get(ch);
        if(child == null) {
          child = new TrieNode(ch);
          t.map.put(ch, child);
        }
        t = child;
      } // end of for loop - processed all chars of word
      t.isWord = true;
    }

    void print() {
      TrieNode t = root;
      StringBuilder strBuilder = new StringBuilder();
      for(TrieNode node : t.map.values()) {
        dfs(node, strBuilder);
      }
    }

    private void dfs(TrieNode node, StringBuilder strBuilder) {
      strBuilder.append(node.ch);
      if(node.isWord) {
        System.out.println(strBuilder);
      }

      for(TrieNode n : node.map.values()) {
        dfs(n, strBuilder);
      }

      strBuilder.deleteCharAt(strBuilder.length()-1); //backtrack remove last char
      return;  //optional
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
  }

  public static void main(String[] args) {
    Trie trie = new Trie();

    trie.add("apple");
    trie.add("app");
    trie.add("hi");
    trie.add("hip");
    trie.add("he");


    trie.print();
    System.out.println("search app: " + trie.search("app"));
    System.out.println("search app: " + trie.startsWith("app"));

  }
}
