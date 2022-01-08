import java.util.*;

class reverseRange {
  public static Scanner scn = new Scanner(System.in);

  public static class ListNode {
    int val = 0;
    ListNode next = null;

    ListNode(int val) {
      this.val = val;
    }
  }
    public static ListNode th = null;
    public static ListNode tt = null;
        public static void addFirstNode(ListNode node) {
        if (th == null)
            th = tt = node;
        else {
            node.next = th;
            th = node;
        }
    }
  public static ListNode reverseInRange(ListNode head, int n, int m) {
    if (head.next == null) return head;
    ListNode curr = head;
    ListNode prev = null;
    int s = n;
    while(s-- > 1){
        prev = curr;
        curr = curr.next;
    }
    //System.out.println(curr.val);
    int itr = m - n + 1 ;
    while(itr -- > 0){
                ListNode forw = curr.next;
                curr.next = null;
                addFirstNode(curr);
                curr = forw; 
    }
    if(prev != null){
        prev.next = th  ;
        tt.next = curr;
    }else{
        head = th;
        tt.next = curr;
    }
    return head;
  }

  public static void printList(ListNode node) {
    while (node != null) {
      System.out.print(node.val + " ");
      node = node.next;
    }
  }

  public static ListNode createList(int n) {
    ListNode dummy = new ListNode(-1);
    ListNode prev = dummy;
    while (n-- > 0) {
      prev.next = new ListNode(scn.nextInt());
      prev = prev.next;
    }

    return dummy.next;
  }

  public static void main(String[] args) {
    int sz = scn.nextInt();
    ListNode h1 = createList(sz);

    int m = scn.nextInt();
    int n = scn.nextInt();

    h1 = reverseInRange(h1, m, n);
    printList(h1);
  }
}
