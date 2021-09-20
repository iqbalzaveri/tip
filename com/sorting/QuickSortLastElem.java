package com.sorting;

import java.util.Arrays;

public class QuickSortLastElem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] values = {5,2,1,6,8,3,7,2};
		System.out.println("before sort: " + Arrays.toString(values));
		quicksort(values, 0, values.length-1);
		System.out.println("after sort: " + Arrays.toString(values));
	}

	private static void quicksort(int[] values, int low, int high) {
		if(low < high) {
			int pivotIdx = partition(values, low, high);
			
			quicksort(values, low, pivotIdx-1);
			quicksort(values, pivotIdx+1, high);
		}
		
	}

	private static int partition(int[] values, int low, int high) {
		int pivot = values[high];
		int i = low;
		for(int j=low; j<=high-1; j++) {
			if(values[j] < pivot) {
				swap(values, i, j);
				i++;
			}
		}
		swap(values, i, high);
		return i;
	}

	private static void swap(int[] values, int i, int j) {
		int temp = values[i];
		values[i] = values[j];
		values[j] = temp;
	}
}
