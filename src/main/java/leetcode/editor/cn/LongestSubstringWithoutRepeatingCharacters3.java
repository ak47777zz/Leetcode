//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 7132 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * 3:无重复字符的最长子串
 */
public class LongestSubstringWithoutRepeatingCharacters3 {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters3().new Solution();
        System.out.println(solution.lengthOfLongestSubstring("au"));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 暴力循环
        //public int lengthOfLongestSubstring(String s) {
        //    if (s == null || s.length() == 0) {
        //        return 0;
        //    }
        //
        //    char[] chars = s.toCharArray();
        //    int maxLength = 0;
        //    for (int i = 0; i < chars.length; i++) {
        //        List<Character> container = new ArrayList<>();
        //        container.add(chars[i]);
        //        for (int j = i + 1; j < chars.length; j++) {
        //            // 不包含
        //            if (!container.contains(chars[j])) {
        //                container.add(chars[j]);
        //            } else {
        //                break;
        //            }
        //        }
        //        if (container.size() > maxLength) {
        //            maxLength = container.size();
        //        }
        //    }
        //    return maxLength;
        //}

        public int lengthOfLongestSubstring(String s) {
            // 哈希集合，记录每个字符是否出现过
            Set<Character> set = new HashSet<>();
            int n = s.length();
            // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
            int right = -1, maxLength = 0;
            for (int i = 0; i < n; i++) {
                if (i != 0) {
                    // 左指针向右移动一格，移除一个字符
                    set.remove(s.charAt(i - 1));
                }
                while (right + 1 < n && !set.contains(s.charAt(right + 1))) {
                    // 不断地移动右指针
                    set.add(s.charAt(right + 1));
                    right++;
                }
                // 第 i 到 rk 个字符是一个极长的无重复字符子串
                maxLength = Math.max(maxLength, set.size());
            }
            return maxLength;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}