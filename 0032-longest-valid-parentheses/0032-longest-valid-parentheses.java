class Solution {
    public int longestValidParentheses(String s) {
        if(s.length()==0){
            return 0;
        }
        int count=0;
        Stack<Character> stack=new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='('){
                stack.push(c);
            }
            else if(c==')' &&!stack.isEmpty()){
                stack.pop();
                count+=2;
            }
        }
        return count;
    }
}