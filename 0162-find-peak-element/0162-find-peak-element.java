class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        
        int i = 0;
        int j = nums.length - 1;
        int k = 0; // This stores the peak element's index.
        
        while (i < j) {
            int mid = (i + j) / 2; // Middle index
            
            // If the middle element is greater than its next neighbor, a peak lies to the left (including mid).
            if (nums[mid] > nums[mid + 1]) {
                j = mid;
            } 
            // Else, a peak lies to the right (excluding mid).
            else {
                i = mid + 1;
            }
        }
        
        return i; // At the end of the loop, i will point to the peak element's index.
    }
}
