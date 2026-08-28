class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Ek dummy node create karte hain jo head ko point karega (edge cases handle karne ke liye)
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode slow = dummy;
        ListNode fast = dummy;
        
        // Fast pointer ko n + 1 steps aage badhate hain taaki dono ke beech n nodes ka gap ho jaye
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        
        // Fast aur slow dono ko tab tak aage badhate hain jab tak fast end (null) tak na pahunch jaye
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        // Nth node ko skip/remove kar dete hain
        slow.next = slow.next.next;
        
        return dummy.next;
    }
}