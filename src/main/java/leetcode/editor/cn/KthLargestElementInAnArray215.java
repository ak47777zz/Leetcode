//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 1565 👎 0

package leetcode.editor.cn;

/**
 * 215:数组中的第K个最大元素
 */
public class KthLargestElementInAnArray215 {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray215().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            int low = 0;
            int high = nums.length - 1;
            k = nums.length - k;

            while (low <= high) {
                int p = partition(nums, low, high);
                if (p < k) {
                    low = p + 1;
                }
                if (p > k) {
                    high = p - 1;
                }
                if (p == k) {
                    return nums[p];
                }
            }
            return -1;
        }

        // 固定p点位置并返回
        private int partition(int[] nums, int low, int high) {
            int pivot = nums[low];

            int left = low;
            int right = high;

            while (left <= right) {
                // 右指针找到最近一个小于pivot的点
                while (right > left && nums[right] >= pivot) {
                    right--;
                }
                if (right > left) {
                    swap(nums, left, right);
                }
                // 左指针找到最近一个大于pivot的点
                while (left < right && nums[left] <= pivot) {
                    left++;
                }
                if (left < right) {
                    swap(nums, left, right);
                }
                if (left == right) {
                    nums[left] = pivot;
                    return left;
                }
            }
            return 0;
        }

        private void swap(int[] nums, int low, int right) {
            int temp = nums[low];
            nums[low] = nums[right];
            nums[right] = temp;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}