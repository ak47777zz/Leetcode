//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
// 
// 
// Related Topics 递归 链表 👍 2327 👎 0

package leetcode.editor.cn;

/**
 * 206reverse-linked-list
 */
public class 反转链表206 {
    public static void main(String[] args) {
        Solution solution = new 反转链表206().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        // 迭代法
        public ListNode solutionOne(ListNode head) {
            // 空链表或单节点链表处理
            if (head == null || head.next == null) {
                return head;
            }
            // 正常链表处理
            ListNode current = head;
            ListNode pre = null;

            while (current != null) {
                ListNode next = current.next;
                current.next = pre;
                pre = current;
                current = next;
            }
            return pre;
        }

        // 递归法
        public ListNode reverseList(ListNode head) {
            // base case
            if (head == null || head.next == null) {
                return head;
            }

            // 递归思想就是把问题逐渐化简为一个更小的问题
            ListNode last = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return last;
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