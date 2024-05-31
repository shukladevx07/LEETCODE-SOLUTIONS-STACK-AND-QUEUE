import java.util.HashMap;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int[] result = new int[l1];
        
        // Map to store the next greater element for each element in nums2
        HashMap<Integer, Integer> nextGreaterMap = new HashMap<>();
        // Stack to keep track of elements for which we are finding the next greater
        Stack<Integer> stack = new Stack<>();
        
        // Iterate over nums2 to fill the next greater map
        for (int i = 0; i < l2; i++) {
            // While stack is not empty and the current element is greater than the element at the top of the stack
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                nextGreaterMap.put(stack.pop(), nums2[i]);
            }
            // Push the current element onto the stack
            stack.push(nums2[i]);
        }
        
        // For elements still in the stack, there is no next greater element, so map them to -1
        while (!stack.isEmpty()) {
            nextGreaterMap.put(stack.pop(), -1);
        }
        
        // Fill the result array using the next greater map
        for (int i = 0; i < l1; i++) {
            result[i] = nextGreaterMap.get(nums1[i]);
        }
        
        return result;
    }
}
