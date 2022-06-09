package linkList;

import java.util.List;

/**
 * 翻转链表
 *
 * @author make
 */
public class ReverseLinkList {


    public static void main(String[] args) {


    }

    public static ListNode reverseLinkList(ListNode head) {

        if (head == null) {
            return null;
        }

        // 1 -> 2 -> 3 -> 4 -> 5
        //prev = 1
        // current = 2;
        ListNode prev = head;
        ListNode current = head.next;
        // 1  2 -> 3 -> 4 -> 5
        // prev = 1
        // current = 2;
        prev.next = null;
        while (current != null) {
            // first time
            // 先找个当前的下一个。再移动指针。
            ListNode next = current.next;
            // 移动指针。
            current.next = prev;
            // 滑动窗口。
            prev = current;
            current = next;
        }
        return prev;
    }


    /**
     * definition  linkListNode
     */

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
