import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int[] result = new int[l1];
        int[] nextGreater = new int[l2];
        
        // Initialize the next greater array with -1
        for (int i = 0; i < l2; i++) {
            nextGreater[i] = -1;
        }
        
        // Stack to keep track of indices of elements for which we are finding the next greater
        Stack<Integer> stack = new Stack<>();
        
        // Process nums2 to find the next greater element for each element
        for (int i = 0; i < l2; i++) {
            // While stack is not empty and the current element is greater than the element at the index stored in the stack
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                nextGreater[stack.pop()] = nums2[i];
            }
            // Push the current index onto the stack
            stack.push(i);
        }
        
        // Map results to nums1
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                if (nums1[i] == nums2[j]) {
                    result[i] = nextGreater[j];
                    break;
                }
            }
        }
        
        return result;
    }
}
