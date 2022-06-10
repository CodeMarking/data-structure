package linkList;

class AddTwoLinkList {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return null;
        }
        if (l2 == null) {
            return null;
        }
        int carry = 0;
        //创建一个新的链表
        ListNode head = new ListNode(-1);
        ListNode pre = head;

        while (l1 != null && l2 != null) {
            int number = l1.val + l2.val + carry;
            carry = number / 10;
            ListNode node = new ListNode(number % 10);
            pre.next = node;
            pre = pre.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int number = l1.val = carry;
            carry = number / 10;
            ListNode node = new ListNode(number % 10);
            pre.next = node;
            pre = pre.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int number = l2.val = carry;
            carry = number / 10;
            ListNode node = new ListNode(number % 10);
            pre.next = node;
            pre = pre.next;
            l2 = l2.next;
        }
        while (carry != 0) {
            ListNode node = new ListNode(carry);
            pre.next = node;
        }
        return head.next;
    }

    /**
     * Definition for single-linked list
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ;

        ListNode(int x) {
            val = x;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
