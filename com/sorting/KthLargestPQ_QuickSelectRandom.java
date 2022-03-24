class Solution {
    public int findKthLargestMinHeap(int[] nums, int k) {
        // 1 2 3 4 5 6
        // length n = 6
        // k = 3
        // k largest = n-k smallest
        // 6 - 3 = 3 
        // 3 4 5
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int num : nums) {
            minHeap.offer(num);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
       
        return minHeap.poll();
    }
    
    public int findKthLargest(int[] nums, int k) {
        int kthLargest = quickSelect(nums, nums.length-k);
        return kthLargest;
    }
    
    public int quickSelect(int[] nums, int kSmallestIndex) {
        int start = 0, end = nums.length-1;
        
        while(start <= end) {
            int pivotIndex = partition(nums, start, end);
            if(pivotIndex == kSmallestIndex) {
                return nums[kSmallestIndex];
            } else if(pivotIndex < kSmallestIndex) {
                start = pivotIndex+1;
            } else {
                end = pivotIndex-1;
            }
        }
        return -1;
    }
    /*
    k = 3
    0 1 2 3 4 5
    2 6 4 5 9 8
    pivotIndex = 3
    pivot = 5
    0 1 2 3 4 5
    2 6 4 8 9 5 
    storedIdx = 0
    left = 0, end = 5
    i = 0
    2 6 4 8 9 5
    2 4 6 8 9 5
        |
    2 4 5 8 9 6
    
    pivot index 2
    start = 3
    end = 5
    0 1 2 3 4 5
    2 4 5 8 9 6
    pivot index 3
    pivot = 8
    storIdx = 3
    2 4 5 6 9 8
            |
    2 4 5 6 8 9        
            
    */
    public int partition(int[] nums, int start, int end) {
        Random random = new Random();
        int pivotIndex = start + random.nextInt(end - start+1); // select a random pivot index
        int pivot = nums[pivotIndex];
        
        // move pivot to end
        swap(nums, pivotIndex, end);
        int storeIdx = start;
        
        // move all smaller elements to the left
        for(int i=start; i <= end; i++) {
            if(nums[i] < pivot) {
                swap(nums, storeIdx, i);
                storeIdx++;
            }
        }
        
        // move pivot to its final place
        swap(nums, storeIdx, end);
        
        return storeIdx;
        
        
        
    }
    
    public void swap(int[]nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        
    }
}
