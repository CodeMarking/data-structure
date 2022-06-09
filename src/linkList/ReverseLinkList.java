package linkList;

import java.util.List;

/**
 * ��ת����
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
            // ���Ҹ���ǰ����һ�������ƶ�ָ�롣
            ListNode next = current.next;
            // �ƶ�ָ�롣
            current.next = prev;
            // �������ڡ�
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
