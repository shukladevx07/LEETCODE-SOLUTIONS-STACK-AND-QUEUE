class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int arr[] = new int[l1];
        
        for(int i = 0; i < l1; i++) {
            boolean found = false;
            for(int j = 0; j < l2; j++) {
                if(nums1[i] == nums2[j]) {
                    found = true;
                    // Look for the next greater element
                    boolean greaterFound = false;
                    for(int k = j + 1; k < l2; k++) {
                        if(nums2[k] > nums2[j]) {
                            arr[i] = nums2[k];
                            greaterFound = true;
                            break;
                        }
                    }
                    if(!greaterFound) {
                        arr[i] = -1;
                    }
                    break; // Break out of the inner loop once the element is found
                }
            }
            if(!found) {
                arr[i] = -1; // In case nums1[i] is not found in nums2, though it's stated to be a subset
            }
        }
        return arr;
    }
}
