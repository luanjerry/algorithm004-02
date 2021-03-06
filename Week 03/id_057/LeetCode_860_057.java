package app.homeworkWeekThird;

/*
 * @lc app=leetcode id=860 lang=java
 *
 * [860] Lemonade Change
 *
 * https://leetcode.com/problems/lemonade-change/description/
 *
 * algorithms
 * Easy (50.76%)
 * Likes:    371
 * Dislikes: 63
 * Total Accepted:    35.6K
 * Total Submissions: 70.1K
 * Testcase Example:  '[5,5,5,10,20]'
 *
 * At a lemonade stand, each lemonade costs $5. 
 * 
 * Customers are standing in a queue to buy from you, and order one at a time
 * (in the order specified by bills).
 * 
 * Each customer will only buy one lemonade and pay with either a $5, $10, or
 * $20 bill.  You must provide the correct change to each customer, so that the
 * net transaction is that the customer pays $5.
 * 
 * Note that you don't have any change in hand at first.
 * 
 * Return true if and only if you can provide every customer with correct
 * change.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [5,5,5,10,20]
 * Output: true
 * Explanation: 
 * From the first 3 customers, we collect three $5 bills in order.
 * From the fourth customer, we collect a $10 bill and give back a $5.
 * From the fifth customer, we give a $10 bill and a $5 bill.
 * Since all customers got correct change, we output true.
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [5,5,10]
 * Output: true
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: [10,10]
 * Output: false
 * 
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: [5,5,10,10,20]
 * Output: false
 * Explanation: 
 * From the first two customers in order, we collect two $5 bills.
 * For the next two customers in order, we collect a $10 bill and give back a
 * $5 bill.
 * For the last customer, we can't give change of $15 back because we only have
 * two $10 bills.
 * Since not every customer received correct change, the answer is false.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 0 <= bills.length <= 10000
 * bills[i] will be either 5, 10, or 20.
 * 
 * 
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean lemonadeChange(int[] bills) {
        return lemonadeChange_bruce(bills);
    }

    /**
     * 暴力法
     * 按照实际实际生活中收营员的收纳方式，面值相同的钱币放在同一个抽屉里；找零时按照找零的金额快速组合。
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * @param bills
     * @return
     */
    private boolean lemonadeChange_bruce(int[] bills) {
        int fiveNums = 0;
        int tenNums = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                fiveNums ++;
            } else if (bills[i] == 10) {
                if (fiveNums > 0) {
                    tenNums++;
                    fiveNums--;
                } else {
                    return false;
                }

            } else if (bills[i] == 20) {
                //重点
                if (fiveNums > 0 && tenNums > 0) {
                    tenNums--;
                    fiveNums--;
                } else if (fiveNums >= 3) {
                    fiveNums-=3;
                } else {
                    return false;
                }
                // if (fiveNums > 0 && tenNums * 10 + fiveNums * 5 >= 15) {
                //     fiveNums--;
                //     //剩余10元的策略，应该是有10元币值，先用10元
                //     if (tenNums >= 1) {
                //         tenNums--;
                //     } else {
                //         fiveNums-=2;
                //     }
                // } else {
                //     return false;
                // }
            }
        }
        return true;
    }

    
}
// @lc code=end

