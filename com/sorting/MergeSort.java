import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {

        int[] ary = {2,5,7,8,2,1,3,9};
        System.out.println("before sort: " + Arrays.toString(ary));
        mergeSort(ary);
        System.out.println("after sort: " + Arrays.toString(ary));


    }

    static void mergeSort(int[] ary) {
        mergeSort(ary, 0, ary.length-1);
    }

    static void mergeSort(int[] ary, int start, int end) {
        if(start < end) { // if start becomes equal to it means there is only one element in the array which is already sorted so go back

            int mid = (start + end) / 2;  // to avoid overflow if lenght of array is very large:   start + ((end-start)/2)
            mergeSort(ary, 0, mid);
            mergeSort(ary, mid+1, end);

            merge(ary, start, mid, end);  // Or merge(ary, start, mid, mid+1, end)

        }
    }

    /*
    static void merge(int[] ary, int leftStart, int leftEnd, int rightStart, int rightEnd) {
    }
     */


    static void merge(int[] ary, int start, int mid, int end) {
        int[] leftArray = new int[mid+1-start];
        int[] rightArray = new int[end-mid];

        // Copy the sorted arrays to temp arrays and then merge the results in original array
        for(int i=0; i<leftArray.length; i++) {
            leftArray[i] = ary[start+i]; //copy the original (sorted) array to temp arrays
        }

        for(int i=0; i<rightArray.length; i++) {
            rightArray[i] = ary[mid+1+i];
        }

        int leftIdx = 0;
        int rightIdx = 0;
        while(leftIdx < leftArray.length && rightIdx < rightArray.length) {
            if(leftArray[leftIdx] <= rightArray[rightIdx]) {  //stable
                ary[start] = leftArray[leftIdx];
                start++;
                leftIdx++;
                //Or ary[start++] = leftArray[leftIdx++];
            } else {
                ary[start] = rightArray[rightIdx];
                start++;
                rightIdx++;
                //Or ary[start++] = rightArray[rightIdx++];
            }
        }

        // copy for remianing left
        while(leftIdx < leftArray.length) {
                ary[start] = leftArray[leftIdx];
                start++;
                leftIdx++;
                //Or ary[start++] = leftArray[leftIdx++];
        }

        // copy for remianing right
        while(rightIdx < rightArray.length) {
                ary[start] = rightArray[rightIdx];
                start++;
                rightIdx++;
                //Or ary[start++] = rightArray[rightIdx++];
        }
    }
}
