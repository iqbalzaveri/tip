package com.llstq;

import java.util.Stack;

public class StackUsingQueues {

    Stack<Integer> stack1;
    Stack<Integer> stack2;
    int top;

        /** Initialize your data structure here. */
        public StackUsingQueues() {
            stack1= new Stack<>();
            stack2 = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            if(stack1.isEmpty()) {
                top = x;
            }
            stack1.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if(stack2.isEmpty()) {
                while(!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
                return stack2.pop();
        }

        /** Get the front element. */
        public int peek() {
            if(stack2.isEmpty()) {
                return top;
            } else {
                return stack2.peek();
            }
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            if(stack1.empty() && stack2.empty()) return true;
            return false;
        }

}
