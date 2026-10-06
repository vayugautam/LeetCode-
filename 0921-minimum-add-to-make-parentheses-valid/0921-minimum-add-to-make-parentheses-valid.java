class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        for(int i=0;i<n;i++){
            char curr = s.charAt(i);
            if(curr == ')' && !st.isEmpty() && st.peek() == '(') {
                st.pop();
            } else {
                st.push(curr);
            }
        }
        return st.size();
    }
}