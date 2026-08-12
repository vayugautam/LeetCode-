class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        if (head == null || head.next == null) return head;
        ListNode next;
        while(curr!=null && curr.next!=null){
            while(curr.next != null && curr.val==curr.next.val){
                next=curr.next;
                curr.next=next.next;
            }
            curr=curr.next;
        }
        return head;
    }
}