//给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[20,9],[15,7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 广度优先搜索 二叉树 👍 613 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 103:二叉树的锯齿形层序遍历
 */
public class BinaryTreeZigzagLevelOrderTraversal103 {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeZigzagLevelOrderTraversal103().new Solution();
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {this.val = val;}

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            boolean control = true;
            while (!queue.isEmpty()) {
                int size = queue.size();
                Integer[] array = new Integer[size];
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();
                    if (control) {
                        // 正向添加
                        array[i] = poll.val;
                    } else {
                        // 反向添加
                        array[size - 1 - i] = poll.val;
                    }
                    if (poll.left != null) {
                        queue.offer(poll.left);
                    }
                    if (poll.right != null) {
                        queue.offer(poll.right);
                    }
                }
                result.add(Arrays.asList(array));
                // 反转方向
                control = !control;
            }
            return result;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}