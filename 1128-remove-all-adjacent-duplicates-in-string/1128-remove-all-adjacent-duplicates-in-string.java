import java.util.Stack;

class Solution {
    public String removeDuplicates(String s) {
        // Initialize an empty stack
        Stack<Character> stack = new Stack<>();

        // Iterate through each character in the input string
        for (char c : s.toCharArray()) {
            // If the stack is not empty and the top element is the same as the current character
            if (!stack.isEmpty() && stack.peek() == c) {
                // Pop the top element as it's a duplicate
                stack.pop();
            } else {
                // Otherwise, push the current character onto the stack
                stack.push(c);
            }
        }

        // Build the result string from the characters remaining in the stack
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        // Return the result as a string
        return result.toString();
    }
}
