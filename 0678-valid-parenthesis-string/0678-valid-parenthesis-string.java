class Solution {
    public boolean checkValidString(String s) {
        int sc = 0, oc = 0, cc = 0; // starCount, openCount, closeCount
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                oc++;
            } else if (c == ')') {
                if (oc > 0) oc--;
                else if (sc > 0) sc--;
                else return false;
            } else sc++;
        }
        
        sc = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')') {
                cc++;
            } else if (c == '(') {
                if (cc > 0) cc--;
                else if (sc > 0) sc--;
                else return false;
            } else sc++;
        }
        
        return true;
    }
}