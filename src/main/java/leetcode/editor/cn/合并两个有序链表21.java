//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 👍 2212 👎 0

package leetcode.editor.cn;

/**
 * 21merge-two-sorted-lists
 */
public class 合并两个有序链表21 {
    public static void main(String[] args) {
        Solution solution = new 合并两个有序链表21().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null && list2 == null) {
                return null;
            }

            // 虚拟头节点
            ListNode virtual = new ListNode(-1);
            // 合并头节点
            ListNode head = virtual;

            // 第一个指针
            ListNode one = list1;
            // 第二个指针
            ListNode two = list2;

            while (one != null && two != null) {
                if (one.val <= two.val) {
                    head.next = one;
                    head = one;
                    one = one.next;
                } else {
                    head.next = two;
                    head = two;
                    two = two.next;
                }
            }

            if (one != null) {
                head.next = one;
            }

            if (two != null) {
                head.next = two;
            }
            return virtual.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {this.val = val;}

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}