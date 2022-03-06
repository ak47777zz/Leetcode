//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 👍 3009 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Stack;

/**
 * 20valid-parentheses
 */
public class 有效的括号20 {
    public static void main(String[] args) {
        Solution solution = new 有效的括号20().new Solution();
        String s = "){";
        System.out.println(solution.isValid(s));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            if (s == null || "".equals(s) || s.length() == 1) {
                return false;
            }
            HashMap<Character, Character> index = new HashMap<Character, Character>() {
                {
                    put(')', '(');
                    put(']', '[');
                    put('}', '{');
                }
            };
            char[] chars = s.toCharArray();
            Stack<Character> stack = new Stack<>();
            for (char c : chars) {
                if (index.containsKey(c)) {
                    if (stack.isEmpty() || !stack.peek().equals(index.get(c))) {
                        return false;
                    }
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            return stack.isEmpty();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}