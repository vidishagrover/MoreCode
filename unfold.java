import java.util.*;

class unfold {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode reverse(ListNode head) {
      if(head == null || head.next == null) return head;// 
      ListNode curr = head;
      ListNode prev = null;
      while(curr != null){
          ListNode forw = curr.next; //backup
          curr.next = prev;//link
          prev = curr;
          curr = forw;
      }
      head = prev;
        return head;
    }
    // this code kind of failed for 2 len eg 2 2
    // lol worked over edge cases bs ek c1prev maintain krke 
    public static void unfold(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode dummy = new ListNode(-1);
        ListNode c1prev = new ListNode(-1);
        ListNode prev = dummy, c1 = head;
        while(c1 != null && c1.next != null){
            ListNode forw = c1.next;
            c1.next = forw.next;
            prev.next = forw;
            c1prev = c1;
            c1 = c1.next;
            prev = forw;
        }
        prev.next = null;
        ListNode half = reverse(dummy.next);
        if(c1!= null )c1.next =half;
        else c1prev.next =half;
        
    }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = dummy.next;
        unfold(head);
        printList(head);
    }
}
