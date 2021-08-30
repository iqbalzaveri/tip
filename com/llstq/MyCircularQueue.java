package com.llstq;

public class MyCircularQueue {

    int[] array;
    int first = 0;
    int  last = 0;
    int count = 0;
    public MyCircularQueue(int k) {
        array = new int[k];
    }

    public boolean enQueue(int value) {
        if(count == array.length) {
            return false;
        }

        array[last] = value;
        last =circularIndex(last);
//        if(last == first) {
//            first = circularIndex(first);
//        }
        count++;
        return true;
    }

    private int circularIndex(int index) {
        if(index == array.length-1) {
            index = 0;
        } else {
            index++;
        }
        return index;
    }

    public boolean deQueue() {
        if(count == 0) {
            return false;
        }
        first = circularIndex(first);
        count--;
        // reset
        if(count ==0) {
            first =0;
            last =0;
        }
        return true;
    }

    public int Front() {
        return array[first];
    }

    public int Rear() {
        if(last == 0) {
            return array[array.length -1];
        } else {
            return array[last-1];
        }
    }

    public boolean isEmpty() {
        if (count == 0) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if(count == array.length) {
            return true;
        }
        return false;
    }
}


/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */


