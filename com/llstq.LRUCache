package com.llstq;

import java.util.HashMap;

/*
Design and implement an LRU cache
LRU cache evicts the least recently used item from the cache. Item insertions, lookups and
evictions should be very efficient.
 */
public class LRUCache {

	private static class Node {
		int key;
		int value;
		Node prev;
		Node next;
		
		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
	
	private int capacity;
	HashMap<Integer, Node> map = new HashMap<>();
	Node head, tail;
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
	}
	
	
	public int get(int key) {
		Node node = map.get(key);
		if(node != null) {
			remove(node);
			setHead(node)
			return node.value;
		} else {
			return -1;
		}
	}
	
	public void remove(Node node){
		if(node==head) {
			head=node.next;
			//head.prev = null;
		} else if(node==tail) {
			tail = node.prev;
			//tail.next = null;
		} else {
			node.prev.next = node.next;
			node.next.prev = node.prev;
		} 
		
	}
	
	private void setHead(Node node){
		node.next = head;
		node.prev = null;
		
		if(head!=null) {
			head.prev = node;
		}
		head = node;
		
		if(tail==null) {
			tail = head;
		}
	}
	
	public void set(int key, int value) {
		Node nodeFromMap = map.get(key);
		if(nodeFromMap != null) {
			nodeFromMap.value = value; //update the value in map
			this.remove(nodeFromMap); //remove from the Dbly LL
			this.setHead(nodeFromMap); //Make it a head, as it is the most recently used.
		} else {
			Node newNode = new Node(key, value);
			if(map.size() >= capacity) { //Capacity reached
				map.remove(tail.key);  //So remove from map
				this.remove(tail);  //And also remove from Dbly LL
			}
			map.put(key, newNode);  //Put the new entry in map
			this.setHead(newNode); //And make it the head because it is the most recently used.
		}
	}
	
	public static void main(String[] args) {
		LRUCache lruCache = new LRUCache(2);
		lruCache.set(1, 2);
		System.out.println("lrucache get 1: " + lruCache.get(1));
		
		LRUCache lruCache2 = new LRUCache(2);
		lruCache2.set(1, 2);
		lruCache2.set(2, 3);
		lruCache2.set(1, 5);
		lruCache2.set(4, 5);
		lruCache2.set(6, 7);
		System.out.println("lrucache2 get 4: " + lruCache2.get(4));
		System.out.println("lrucache2 get 1: " + lruCache2.get(1));

	}

}
