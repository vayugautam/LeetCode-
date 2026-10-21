class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int n1 = nums1.length;
        int n2 = nums2.length;
        st.push(nums2[n2-1]);
        map.put(nums2[n2-1],-1);
        for(int i=n2-2;i>=0;i--){
            while(!st.isEmpty() && nums2[i]>=st.peek()){
                st.pop();
            }
            if (st.isEmpty()) {
                map.put(nums2[i], -1);
            } else {
                map.put(nums2[i], st.peek());
            }
            st.push(nums2[i]);
        }
        int[] ans = new int[n1];
        for(int i=0;i<n1;i++){
            ans[i]=map.get(nums1[i]);
        }
        return ans;
    }
}