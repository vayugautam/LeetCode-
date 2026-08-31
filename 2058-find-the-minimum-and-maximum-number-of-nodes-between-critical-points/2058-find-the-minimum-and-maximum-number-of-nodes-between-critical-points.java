class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int first =-1;
        int previdx=-1;
        int minDist=Integer.MAX_VALUE;
        int index=1;
        ListNode prev = head;
        ListNode curr = head.next;
        while(curr.next!=null){
            boolean isCritical = (
                curr.val > prev.val && curr.val>curr.next.val) || 
                (curr.val < prev.val && curr.val<curr.next.val);
            if(isCritical){
                if(first==-1){
                    first=index;
                }
                if(previdx!=-1){
                    minDist=Math.min(minDist,index-previdx);
                }
                previdx=index;
            }
            prev=curr;
            curr=curr.next;
            index++;
        }
        if(first==-1 || first==previdx){
            return new int[]{-1,-1};
        }
        int maxDist=previdx-first;
        return new int[]{minDist,maxDist};
    }
}