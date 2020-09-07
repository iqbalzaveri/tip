package com.strings;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
  char ch;
  Map<Character, TrieNode> childrenMap;
  boolean isWord;

  TrieNode(char ch) {
    this.ch = ch;
    childrenMap = new HashMap<>();
  }
}

class Trie {
    TrieNode root;
    // Constructor
    Trie() {
      root = new TrieNode((char)0);
    }

    void insert(String str) {
      TrieNode node = root;
      for(int i=0; i< str.length(); i++) {
        char ch = str.charAt(i);
        TrieNode child = node.childrenMap.get(ch);
        if(child == null) {
          child = new TrieNode(ch);
          node.childrenMap.put(ch, child);
        }
        node = child;
      } //end of for loop
      node.isWord = true;
    }
    //boolean startsWith(String str)
    boolean prefixMatches(String str) {
      TrieNode node = root;
      for (int i = 0; i < str.length(); i++) {
        char ch = str.charAt(i);
        TrieNode child = node.childrenMap.get(ch);
        if(child == null) {
          return false;
        }
        node = child;
      } // for loop
      return true;
    }

  boolean isWordExist(String str) {
    TrieNode node = root;
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      TrieNode child = node.childrenMap.get(ch);
      if(child == null) {
        return false;
      } else {
        if(node.isWord && i==str.length()-1) {
          return true;
        }
      }
      node = child;
    } // for loop
    return false;
  }

}


public class TrieDemo {
  public static void main(String[] args) {
    Trie myTrie = new Trie();
    myTrie.insert("apple");
    myTrie.insert("art");
    myTrie.insert("ark");
    myTrie.insert("cat");
    myTrie.insert("can");


  }
}
