//给你一个整数数组 nums，请你将该数组升序排列。
//
//
//
//
//
//
// 示例 1：
//
//
//输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
//
//
// 示例 2：
//
//
//输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 5 * 10⁴
// -5 * 10⁴ <= nums[i] <= 5 * 10⁴
//
// Related Topics 数组 分治 桶排序 计数排序 基数排序 排序 堆（优先队列） 归并排序 👍 506 👎 0

package leetcode.editor.cn;

import java.util.Random;

/**
 * 912:排序数组
 */
public class SortAnArray912 {
    public static void main(String[] args) {
        Solution solution = new SortAnArray912().new Solution();
        int[] test = new int[] {1,2};
        solution.sortArray(test);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArray(int[] nums) {
            shuffle(nums);
            sort(nums, 0, nums.length - 1);
            return nums;
        }

        // 洗牌算法，将输入的数组随机打乱
        private  void shuffle(int[] nums) {
            Random rand = new Random();
            int n = nums.length;
            for (int i = 0 ; i < n; i++) {
                // 生成 [i, n - 1] 的随机数
                int r = i + rand.nextInt(n - i);
                swap(nums, i, r);
            }
        }

        // 快速排序
        public void sort(int[] nums, int low, int high) {
            if (low >= high) {
                return;
            }
            // 对 nums[lo..hi] 进行切分
            // 使得 nums[lo..p-1] <= nums[p] < nums[p+1..hi]
            int p = partition(nums, low, high);

            sort(nums, low, p - 1);
            sort(nums, p + 1, high);
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