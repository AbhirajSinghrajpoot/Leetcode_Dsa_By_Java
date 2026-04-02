import java.util.*;

// LeetCode ki ListNode class VS Code ke liye
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeKSortedLists {
    
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            
            tail.next = minNode;
            tail = tail.next;
            
            if (minNode.next != null) {
                pq.add(minNode.next);
            }
        }
        
        return dummy.next;
    }

    public static void main(String[] args) {
        // Test Case: [[1,4,5], [1,3,4], [2,6]]
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1, new ListNode(4, new ListNode(5)));
        lists[1] = new ListNode(1, new ListNode(3, new ListNode(4)));
        lists[2] = new ListNode(2, new ListNode(6));

        ListNode result = mergeKLists(lists);
        
        System.out.print("Merged List: ");
        while (result != null) {
            System.out.print(result.val + (result.next != null ? " -> " : ""));
            result = result.next;
        }
        System.out.println();
    }
}