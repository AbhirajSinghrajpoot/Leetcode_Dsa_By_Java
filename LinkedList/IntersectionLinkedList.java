public class IntersectionLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode pA = headA;
        ListNode pB = headB;

        while (pA != pB) {
            pA = (pA == null) ? headB : pA.next;
            pB = (pB == null) ? headA : pB.next;
        }

        return pA;
    }

    public static void main(String[] args) {

        // common part
        ListNode common = new ListNode(8);
        common.next = new ListNode(4);
        common.next.next = new ListNode(5);

        // list A: 4 -> 1 -> 8 -> 4 -> 5
        ListNode a = new ListNode(4);
        a.next = new ListNode(1);
        a.next.next = common;

        // list B: 5 -> 6 -> 1 -> 8 -> 4 -> 5
        ListNode b = new ListNode(5);
        b.next = new ListNode(6);
        b.next.next = new ListNode(1);
        b.next.next.next = common;

        ListNode result = getIntersectionNode(a, b);

        if (result != null) {
            System.out.println("Intersection at: " + result.val);
        } else {
            System.out.println("No Intersection");
        }
    }
}
