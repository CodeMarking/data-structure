package linkList;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.HashMap;
import java.util.Map;

/**
 * @author make
 */
public class LRUCache {

    private class CacacheNode {
        CacacheNode prev;
        CacacheNode next;
        int key;
        int value;

        public CacacheNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;

        }
    }

    private int capacity;
    private Map<Integer, CacacheNode> valNodeMap = new HashMap<>();

    private CacacheNode head = new CacacheNode(-1, -1);
    private CacacheNode tail = new CacacheNode(-1, -1);

    private LRUCache(int capacity) {
        this.capacity = capacity;
        tail.prev = head;
        head.next = tail;
    }

    public int get(int key) {
        if (!valNodeMap.containsKey(key)) {
            return -1;
        }
        CacacheNode current = valNodeMap.get(key);
        //移除当前的节点。
        current.prev.next = current.next;
        current.next.prev = current.prev;
        //
        moveToTail(current);
        return valNodeMap.get(key).value;

    }

    public void put(int key, int value) {
        if (get(key) != -1) {
            valNodeMap.get(key).value = value;
            return;
        }
        if (valNodeMap.size() == capacity) {
            valNodeMap.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        CacacheNode insert = new CacacheNode(key, value);
        valNodeMap.put(key, insert);
        moveToTail(insert);
    }

    private void moveToTail(CacacheNode current) {
        current.prev = tail.prev;
        tail.prev = current;
        current.prev.next = current;
        current.next = tail;
    }

}
