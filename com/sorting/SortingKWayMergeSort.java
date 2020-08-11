package com.sorting.iqz;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * 
Merge K sorted arrays, size N each
This is a popular facebook problem: Given K sorted arrays of size N each, merge them and
print the sorted output. Assume N is very large compared to K. N may not even be known. i.e.
the arrays could be just sorted streams, e.g. timestamp streams.
For example:
Input: K = 3, N = 4
arr[][] = { {1, 3, 5, 7},
{2, 4, 6, 8},
{0, 9, 10, 11}} ;
First parameter: How many arrays
Second parameter: Length of each array
Output: 0 1 2 3 4 5 6 7 8 9 10 11
* Repeats are allowed.
* Negative numbers and zeros are allowed.
* Assume all arrays are sorted in the same order (asc or desc). Preserve that sort order in
output.
Hint: Realize that you don't need to access all N*K elements in order to merge. Merging can
start with fewer elements.
Solution runtime: Optimal known solution is NKLog(K).
Solution: https://leetcode.com/discuss/9279/a-java-solution-based-on-priority-queue
[Extra credit: Implement the Priority Queue instead of using existing library functions.]
 */
public class SortingKWayMergeSort {

	public static void main(String[] args) {
		int[][] arrays = {
				{-1,-3,-5,-7},
				{-2,-6,-8,-10},
				};

		System.out.println(Arrays.toString(mergearrays(arrays)));
	}
	
static class Node {
    int value;
    int ary;
    
    Node(int value, int ary) {
        this.value = value;
        this.ary = ary;
    }
}

static class NodeComparator implements Comparator<Node> {
	boolean isAsc = false;
	
	public NodeComparator(boolean isAsc) {
		this.isAsc = isAsc;
	}
	
    public int compare(Node n1, Node n2) {
        if(n1.value < n2.value) {
        	if(isAsc)
        		return -1;
        	else
        		return 1;
        } else if(n1.value > n2.value) {
        	if(isAsc) 
        		return 1;
        	else
        		return -1;
        } else {
            return 0;
        }
    }
}

static int[] mergearrays(int[][] iarray) {
        int k = iarray.length;
        int n = iarray[0].length;
        int[] result = new int[n*k];
        int[] ptrs = new int[k];
        Boolean isAsc = true;
        
        for(int i=0; i<k; i++) {
        	if(iarray[i][0] < iarray[i][iarray[i].length-1]) {
        		isAsc = true;
        		break;
        	} else if(iarray[i][0] > iarray[i][iarray[i].length-1]) {
        		isAsc = false;
        		break;
        	}
        }
        
        PriorityQueue<Node> minHeap = new PriorityQueue<Node>(k, new NodeComparator(isAsc));
        for(int i=0; i<k; i++) {
            Node node = new Node(iarray[i][0], i);
            minHeap.offer(node);       
        }
        
        int i=0;
        while(!minHeap.isEmpty()) {
            Node node = minHeap.poll();
            result[i++] = node.value;
            int ary = node.ary;
            if(++ptrs[ary] < iarray[ary].length) {
                int nextVal = iarray[ary][ptrs[ary]];
                minHeap.offer(new Node(nextVal, ary));
            }
            
        }
//        System.out.println(Arrays.toString(result));

        return result;
    }



}
