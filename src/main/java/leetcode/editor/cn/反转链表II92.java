//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
// Related Topics 链表 👍 1174 👎 0

package leetcode.editor.cn;

/**
 * 92reverse-linked-list-ii
 */
public class 反转链表II92 {
    public static void main(String[] args) {
        Solution solution = new 反转链表II92().new Solution();
        ListNode five = new ListNode(5, null);
        ListNode three = new ListNode(3, five);
        solution.reverseBetween(three, 1, 2);

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        // 普通穿针法  1.截取 2.反转 3.拼接
        public ListNode reverseBetween(ListNode head, int left, int right) {
            // base case
            if (head == null || head.next == null) {
                return head;
            }

            ListNode dummyNode = new ListNode(-1, head);

            // 找到待反转链表前面的节点
            ListNode pre = dummyNode;
            for (int i = 0; i < left - 1; i++) {
                pre = pre.next;
            }

            // 找到待反转链表的尾部节点
            ListNode tail = pre;
            for (int i = 0; i < right - left+1; i++) {
                tail = tail.next;
            }

            // 记录子链表头节点
            ListNode newHead = pre.next;
            ListNode tailNext = tail.next;

            // 切断子链表
            pre.next = null;
            tail.next = null;

            // 反转子链表
            reserve(newHead);
            
            pre.next = tail;
            newHead.next = tailNext;
            
            return dummyNode.next;

        }

        private void reserve(ListNode head) {
            ListNode pre = null;
            while (head != null) {
                ListNode next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    static class ListNode {
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