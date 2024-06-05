import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        String currentString = "";
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                k = k * 10 + (currentChar - '0');
            } else if (currentChar == '[') {
                countStack.push(k);
                stringStack.push(currentString);
                currentString = "";
                k = 0;
            } else if (currentChar == ']') {
                int repeatTimes = countStack.pop();
                StringBuilder decodedString = new StringBuilder(stringStack.pop());
                for (int j = 0; j < repeatTimes; j++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString.toString();
            } else {
                currentString += currentChar;
            }
        }
        return currentString;
    }
}
