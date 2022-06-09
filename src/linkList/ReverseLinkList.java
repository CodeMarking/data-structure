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
     * 翻转链表的处理
     * @param head 头节点
     * @param m  起始位置。
     * @param n  结束位置。
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m >= n) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
        for (int i = 1; i < m; i++) {
            head = head.next;
        }
        ListNode prevM = head;
        ListNode mNode = head.next;
        ListNode nNode = mNode;
        ListNode postN = nNode.next;
        // nNode => prev;
        //postN => current
        for(int i = m; i < n; i++) {
            /**
             ListNode next = current.next;
             current.next = prev;
             prev = current;
             current = next;
             **/
            ListNode next = postN.next;
            postN.next = nNode;
            nNode = postN;
            postN = next;
        }
        mNode.next = postN;
        prevM.next = nNode;
        return dummy.next;
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
