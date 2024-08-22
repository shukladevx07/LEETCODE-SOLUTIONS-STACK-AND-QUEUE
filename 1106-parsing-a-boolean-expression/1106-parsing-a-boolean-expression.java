class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (c == ')') {
                // When we hit a closing bracket, evaluate the expression inside the brackets
                Set<Character> seen = new HashSet<>();
                while (stack.peek() != '(') {
                    seen.add(stack.pop());
                }
                stack.pop(); // remove the '(' from stack

                char operator = stack.pop(); // operator before '('

                if (operator == '&') {
                    stack.push(seen.contains('f') ? 'f' : 't'); // AND operation
                } else if (operator == '|') {
                    stack.push(seen.contains('t') ? 't' : 'f'); // OR operation
                } else if (operator == '!') {
                    stack.push(seen.contains('t') ? 'f' : 't'); // NOT operation
                }
            } else if (c != ',') {
                stack.push(c); // push the current character unless it's a comma
            }
        }
        return stack.pop() == 't'; // final result on top of the stack
    }
}