package com.llstq;

import java.util.HashMap;
import java.util.Map;

public class LRUCache2 {
    Node head = null;
    Node tail = null;
    Map<Integer, Node> map = new HashMap();
    int capacity;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!this.map.containsKey(key)) {
            return -1;
        } else {
            Node node = this.map.get(key);
            this.moveAccessedNodeToHead(node);
            return node.val;
        }
    }

    private void moveAccessedNodeToHead(Node node) {
        if (this.head != node) {
            if (node == this.tail) {
                node.prev.next = null;
                this.tail = node.prev;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }

            node.next = null;
            node.prev = null;
            this.head.prev = node;
            node.next = this.head;
            this.head = node;
        }

    }

    private void addNodeToHead(Node node) {
        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            this.head.prev = node;
            node.next = this.head;
            this.head = node;
        }

    }

    private void removeLeastRecentlyUsed() {
        if (this.head != this.tail) {
            this.map.remove(this.tail.key);
            this.tail.prev.next = null;
            this.tail = this.tail.prev;
        } else {
            this.map.remove(this.head.key);
            this.head = null;
            this.tail = null;
        }

    }

    public void put(int key, int value) {
        if (this.map.containsKey(key)) {
            this.moveAccessedNodeToHead(this.map.get(key));
            (this.map.get(key)).val = value;
        } else {
            if (this.map.size() == this.capacity) {
                this.removeLeastRecentlyUsed();
            }

            Node node = new Node(key, value);
            this.map.put(key, node);
            this.addNodeToHead(node);
        }

    }

    class Node {
        int val;
        int key;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

