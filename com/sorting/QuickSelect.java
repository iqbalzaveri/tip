import java.util.Arrays;

public class QuickSelect {
    public static void main(String[] args) {

        int[] ary = {5,1,6,8,3,7,2};
        System.out.println("before sort: " + Arrays.toString(ary));
        quickSort(ary);
        System.out.println("after sort: " + Arrays.toString(ary));


    }

    static void quickSort(int[] ary) {
        quickSort(ary, 0, ary.length-1);
    }

    static void quickSort(int[] ary, int start, int end) {
        if(start < end) {
            int pivotIdx = partition(ary, start, end);  // Partitions the array at pivot indx, so all elements less than pivot are on left & greater are on right
            /* can select pivot here and pass to partition(ary, start, end, pivot) */
            //After call to partition function all elements on left are less than pivot and all elements on right are greater than pivot
            quickSort(ary, start, pivotIdx-1);
            quickSort(ary, pivotIdx+1, end);
        }
    }
    static int partition(int[]ary, int start, int end) {
        // Select pivot here or can also be selected in the calling function
        // Select pivot
        // select last elem as pivot
        int pivot = ary[end];
        int pivotIdx = start;
        for(int j=start; j<end; j++) { //find the correct pivotIdx & move all values less the pivot on left of pivotIdx
            if(ary[j] < pivot) {
                swap(ary, pivotIdx, j);
                pivotIdx++;
            }
        } // here we have found the pivotIdx
        swap(ary, pivotIdx, end);  // we found the right place for the pivot, so move pivot there.
        return pivotIdx;

    }

    static void swap(int[]ary, int a, int b) {
        int temp = ary[a];
        ary[a] = ary[b];
        ary[b] = temp;
    }
}
