package algorithms.easy_questions.merge_two_sorted_lists;

public class merge_two_sorted_lists {

    public static ListNode mergeLists(ListNode head1, ListNode head2) {
        // Two cases to check for null lists.
        if (head1 == null) {
            return head2;
        } 
        
        if (head2 == null) {
            return head1;
        }
        
        // Choose head of the list to build from, choosing the smaller
        // node between head1 and head2.
        ListNode new_head = null;
        if (head1.val > head2.val) {
            new_head = head2;
            head2 = head2.next;
        } else {
            new_head = head1;
            head1 = head1.next;
        }

        // Loop through list1 and list2.
        // Check which current node is smaller, set as the next node
        // then itterate the pointers of the list until one is null.
        ListNode curr = new_head;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                curr.next = head1;
                head1 = head1.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }

        // If there are remaining nodes in either list, put them at the end.
        if (head1 != null) {
            curr.next = head1;
        } else {
            curr.next = head2;
        }

        return new_head;
    }

    // Function for converting input into linked list.
    public static ListNode createList(int[] list) {
        if (list == null || list.length == 0) { return null; }

        ListNode head = new ListNode(list[0]);
        ListNode current = head;

        for (int i = 1; i < list.length; i++) {
            current.next = new ListNode(list[i]);
            current = current.next;
        }
        return head;
    }

    // Function for printing list.
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //example 1
        int[] list1 = {5};
        int[] list2 = {1,2,4};

        ListNode head1 = createList(list1);
        ListNode head2 = createList(list2);

        ListNode new_head = mergeLists(head1, head2);
        System.out.println("Example 1");
        printList(new_head);

        //example 2;
        int[] list3 = {1,3,6,12,19,23};
        int[] list4 = {1,2,5,9,10};

        ListNode head3 = createList(list3);
        ListNode head4 = createList(list4);

        ListNode new_head2 = mergeLists(head3, head4);
        System.out.println("Example 2");
        printList(new_head2);

    }
}
