package com.llstq;

public class MinStack {

    Node head;

    class Node {
        int val;
        Node next;
        int min;

        Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void Push(int val) {
        Node node;
        if (this.head == null || this.head.min > val) {
            node = new Node(val, val);
        } else {
            node = new Node(val, this.head.min);
        }
        node.next = head;
        this.head = node;

    }

    public void Pop() {
        this.head = this.head.next;
    }

    public int Top() {
        return this.head.val;
    }

    public int GetMin() {
        return this.head.min;
    }
}
