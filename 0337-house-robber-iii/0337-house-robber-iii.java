class Solution {
    public int rob(TreeNode root) {
        int[] ans = func(root);
        return Math.max(ans[0],ans[1]);
    }
    // 0 = value ko leliya hai 
    // 1 = value ko nahi liya hai
    int[] func(TreeNode root){
        if(root==null) {
            return new int[]{0,0};
        }
        int[] left = func(root.left);
        int[] right = func(root.right);


        int rob = root.val + left[1]+right[1];
        int notRob = Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        return new int[]{rob,notRob};
    }
}