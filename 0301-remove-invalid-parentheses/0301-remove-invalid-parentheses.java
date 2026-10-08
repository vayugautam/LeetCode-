class Solution {

    Set<String> result = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {

        int leftRem = 0;
        int rightRem = 0;

        // Calculate minimum removals
        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                leftRem++;

            } else if (ch == ')') {

                if (leftRem > 0) {
                    leftRem--;
                } else {
                    rightRem++;
                }
            }
        }
        dfs(s, 0, 0, 0, leftRem, rightRem, new StringBuilder());
        return new ArrayList<>(result);
    }

    private void dfs(
        String s,
        int index,
        int leftCount,
        int rightCount,
        int leftRem,
        int rightRem,
        StringBuilder sb) {
        // Base case
        if (index == s.length()) {
            if (leftRem == 0 && rightRem == 0) {
                result.add(sb.toString());
            }
            return;
        }
        char ch = s.charAt(index);
        if (ch == '(') {
            if (leftRem > 0) {
                dfs(s,index + 1,leftCount,rightCount,leftRem - 1,rightRem,sb);
            }
            sb.append(ch);
            dfs(s,index + 1,leftCount + 1,rightCount,leftRem,rightRem,sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        else if (ch == ')') {
            if (rightRem > 0) {
                dfs(s,index + 1,leftCount,rightCount,leftRem,rightRem - 1,sb);
            }
            if (rightCount < leftCount) {

                sb.append(ch);
                dfs(s,index + 1,leftCount,rightCount + 1,leftRem,rightRem,sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        else {
            sb.append(ch);
            dfs(s,index + 1,leftCount,rightCount,leftRem,rightRem,sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}