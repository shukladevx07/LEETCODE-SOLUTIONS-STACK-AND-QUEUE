import java.util.*;

class Solution {
    public List<String> braceExpansionII(String expression) {
        Set<String> resultSet = expand(expression);
        List<String> resultList = new ArrayList<>(resultSet);
        Collections.sort(resultList);
        return resultList;
    }

    private Set<String> expand(String expression) {
        Stack<Set<String>> stack = new Stack<>();
        stack.push(new HashSet<>());
        Set<String> current = new HashSet<>();
        int i = 0;

        while (i < expression.length()) {
            if (expression.charAt(i) == '{') {
                int j = findClosingBrace(expression, i);
                Set<String> expanded = expand(expression.substring(i + 1, j));
                current = combine(current, expanded);
                i = j + 1;
            } else if (expression.charAt(i) == '}') {
                stack.peek().addAll(current);
                current = new HashSet<>();
                i++;
            } else if (expression.charAt(i) == ',') {
                stack.peek().addAll(current);
                current = new HashSet<>();
                i++;
            } else {
                int j = i;
                while (j < expression.length() && Character.isLetter(expression.charAt(j))) {
                    j++;
                }
                current = combine(current, new HashSet<>(Collections.singleton(expression.substring(i, j))));
                i = j;
            }
        }

        stack.peek().addAll(current);
        return stack.pop();
    }

    private Set<String> combine(Set<String> set1, Set<String> set2) {
        if (set1.isEmpty()) {
            return set2;
        }
        Set<String> combined = new HashSet<>();
        for (String s1 : set1) {
            for (String s2 : set2) {
                combined.add(s1 + s2);
            }
        }
        return combined;
    }

    private int findClosingBrace(String expression, int openIndex) {
        int balance = 0;
        for (int i = openIndex; i < expression.length(); i++) {
            if (expression.charAt(i) == '{') {
                balance++;
            } else if (expression.charAt(i) == '}') {
                balance--;
                if (balance == 0) {
                    return i;
                }
            }
        }
        throw new IllegalArgumentException("Unbalanced braces in the expression");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.braceExpansionII("{a,b}{c,{d,e}}")); // Output: ["ac", "ad", "ae", "bc", "bd", "be"]
        System.out.println(solution.braceExpansionII("{{a,z},a{b,c},{ab,z}}")); // Output: ["a", "ab", "ac", "z"]
    }
}
