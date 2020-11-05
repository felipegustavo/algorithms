// problem: https://leetcode.com/problems/rotate-list/

public class RotateList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; } 
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
    
        int size = 1;
        ListNode temp = head;
        while (temp.next != null) {
            size++;
            temp = temp.next;
        }
        ListNode end = temp;
        
        k %= size;
        if (k == 0) {
            return head;
        }
        
        int diff = size - k - 1;
        temp = head;
        while (diff > 0) {
            temp = temp.next;
            diff--;
        }
        
        ListNode start = temp.next;
        temp.next = null;
        end.next = head;
        head = start;
        
        return head;
    }    

}
