//请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。
//
// 实现 LRUCache 类： 
//
// 
// 
// 
// LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 
//key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。 
// 
//
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。 
// 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10000 
// 0 <= value <= 10⁵ 
// 最多调用 2 * 10⁵ 次 get 和 put 
// 
// Related Topics 设计 哈希表 链表 双向链表 👍 2007 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;


/**
 * 146:LRU 缓存
 */
public class LruCache146 {
    public static void main(String[] args) {
        LRUCache lruCache = new LruCache146().new LRUCache(2);

        // case 3
        lruCache.put(2, 1);
        lruCache.put(2, 2);
        lruCache.get(2);
        lruCache.put(1, 1);
        lruCache.put(4, 1);
        lruCache.get(2);

        // case 2
        //lruCache.get(2);
        //lruCache.put(2, 6);
        //lruCache.get(1);
        //lruCache.put(1, 5);
        //lruCache.put(1, 2);
        //lruCache.get(1);
        //lruCache.get(2);

        // case 1
        //lruCache.get(2);
        //lruCache.put(1, 1);
        //lruCache.put(2, 2);
        //lruCache.get(1);
        //lruCache.put(3, 3);
        //lruCache.get(2);
        //lruCache.put(4, 4);
        //lruCache.get(1);
        //lruCache.get(3);
        //lruCache.get(4);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {

        private Map<Integer, Node> map;
        private int capacity;
        private DoubleList doubleList;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>(capacity);
            doubleList = new DoubleList();
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            Node node = map.get(key);
            makeRecently(key);
            return node.value;
        }

        public void put(int key, int value) {
            // 已经存在此key
            if (map.containsKey(key)) {
                deleteKey(key);
                addRecently(key, value);
                return;
            }

            // 容量不足
            if (doubleList.size == capacity) {
                removeLeastRecently();
            }

            addRecently(key, value);

        }

        /* 将某个 key 提升为最近使用的 */
        private void makeRecently(int key) {
            Node node = map.get(key);
            doubleList.remove(node);
            doubleList.addLast(node);
        }

        /* 添加最近使用的元素 */
        private void addRecently(int key, int val) {
            Node node = new Node(key, val);
            doubleList.addLast(node);
            map.put(key, node);
        }

        /* 删除某一个 key */
        private void deleteKey(int key) {
            Node node = map.get(key);
            doubleList.remove(node);
            map.remove(key);
        }

        /* 删除最久未使用的元素 */
        private void removeLeastRecently() {
            Node node = doubleList.removeFirst();
            map.remove(node.key);
        }


    }

    class Node {
        int key;
        int value;
        Node pre;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class DoubleList {
        Node dummyHead;
        Node dummyTail;
        int size;

        // 双链表初始化
        DoubleList() {
            dummyHead = new Node(-1, -1);
            dummyTail = new Node(-1, -1);
            dummyHead.next = dummyTail;
            dummyTail.pre = dummyHead;
            size = 0;
        }

        // 在队尾加节点
        public void addLast(Node node) {
            Node tail = dummyTail.pre;
            tail.next = node;
            node.next = dummyTail;
            node.pre = tail;
            dummyTail.pre = node;
            size++;
        }

        // 删除一个指定的节点
        public void remove(Node node) {
            Node pre = node.pre;
            Node next = node.next;
            pre.next = next;
            next.pre = pre;
            size--;
        }

        // 删除头节点
        public Node removeFirst() {
            if (dummyHead.next == dummyTail) {
                return null;
            }
            Node head = dummyHead.next;
            Node headNext = head.next;
            dummyHead.next = headNext;
            headNext.pre = dummyHead;
            size--;
            return head;
        }

        public int size() {
            return size;
        }

    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    //leetcode submit region end(Prohibit modification and deletion)

}