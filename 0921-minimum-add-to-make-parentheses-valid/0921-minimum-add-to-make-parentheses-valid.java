import java.util.Stack;

class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int unmatchedClosing = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(ch);  // Push opening parenthesis onto the stack
            } else if (ch == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();  // Match found, pop from the stack
                } else {
                    unmatchedClosing++;  // Unmatched closing parenthesis
                }
            }
        }
        
        // Number of unmatched opening parentheses is the size of the stack
        return unmatchedClosing + stack.size();
    }
}
