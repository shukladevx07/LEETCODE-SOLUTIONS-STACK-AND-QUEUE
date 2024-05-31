import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // Push opening brackets onto the stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // If the stack is empty or the top of the stack doesn't match the closing bracket, return false
                if (stack.isEmpty() || !isMatchingPair(stack.pop(), c)) {
                    return false;
                }
            }
        }
        
        // If the stack is not empty after processing, return false
        return stack.isEmpty();
    }

    // Helper method to check if the characters form a matching pair of brackets
    private boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') || 
               (open == '{' && close == '}') || 
               (open == '[' && close == ']');
    }
}
