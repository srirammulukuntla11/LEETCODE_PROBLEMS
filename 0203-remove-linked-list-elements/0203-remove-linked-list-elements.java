class Solution {
    public ListNode removeElements(ListNode head, int val) {
        
        ListNode prev = null;
        ListNode cur = head;
        
        while(cur != null)
        {
            if(cur.val == val)
            {
                if(prev != null) {
                    prev.next = cur.next;
                }
                else {
                    head = cur.next;
                }
            }
            else {
                prev = cur;
            }
            
            cur = cur.next;
        }
        
        return head;
    }
}