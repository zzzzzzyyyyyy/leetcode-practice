// 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。
//
// 你可以认为每种硬币的数量是无限的。
//
//
//
// 示例 1：
//
//
// 输入：coins = [1, 2, 5], amount = 11
// 输出：3
// 解释：11 = 5 + 5 + 1
//
// 示例 2：
//
//
// 输入：coins = [2], amount = 3
// 输出：-1
//
// 示例 3：
//
//
// 输入：coins = [1], amount = 0
// 输出：0
//
//
// 示例 4：
//
//
// 输入：coins = [1], amount = 1
// 输出：1
//
//
// 示例 5：
//
//
// 输入：coins = [1], amount = 2
// 输出：2
//
//
//
//
// 提示：
//
//
// 1 <= coins.length <= 12
// 1 <= coins[i] <= 231 - 1
// 0 <= amount <= 104
//
// Related Topics 动态规划
// 👍 945 👎 0

package com.javatiku.leetcode.editor.cn;

public class CoinChange {

    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
        System.out.println(solution.coinChange(new int[] {1, 2, 5}, 100));
    }

    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 迭代，动态规划
     */
    class Solution {
        public int coinChange(int[] coins, int amount) {
            if (amount < 0 || coins == null || coins.length == 0) {
                return -1;
            } else if (amount == 0) {
                return 0;
            }
            int[] dpTable = new int[amount + 1];
            for (int i = 1; i <= amount; i++) {
                dpTable[i] = amount + 1;
            }
            dpTable[0] = 0;
            for (int i = 1; i <= amount; i++) {
                for (int coin : coins) {
                    if (i - coin < 0) {
                        continue;
                    }
                    if (dpTable[i - coin] == -1) {
                        continue;
                    }
                    dpTable[i] = Math.min(dpTable[i], 1 + dpTable[i - coin]);
                }
                if (dpTable[i] == amount + 1) {
                    dpTable[i] = -1;
                }
            }

            return dpTable[amount];
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    /**
     * 递归 + 保存最小硬币数的数组
     */
    class Solution2 {
        public int coinChange(int[] coins, int amount) {
            if (amount < 0 || coins == null || coins.length == 0) {
                return -1;
            } else if (amount == 0) {
                return 0;
            }
            int[] dpTable = new int[amount + 1];
            for (int i = 1; i <= amount; i++) {
                dpTable[i] = -2;
            }
            return coinChange(coins, amount, dpTable);
        }

        public int coinChange(int[] coins, int amount, int[] dpTable) {
            if (amount < 0 || coins == null || coins.length == 0) {
                return -1;
            } else if (amount == 0) {
                return 0;
            }
            if (dpTable[amount] != -2) {
                return dpTable[amount];
            }
            int result = Integer.MAX_VALUE;
            for (int coin : coins) {
                int subChange = coinChange(coins, amount - coin);
                if (subChange == -1) {
                    continue;
                }
                result = Math.min(result, 1 + subChange);
            }
            dpTable[amount] = result == Integer.MAX_VALUE ? -1 : result;
            return dpTable[amount];
        }
    }
}