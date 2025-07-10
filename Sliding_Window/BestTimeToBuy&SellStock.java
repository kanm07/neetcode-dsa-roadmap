/*
Approach:
- Use a sliding window with two pointers:
  - `left` marks the potential buy day.
  - `right` scans ahead as the sell day.
- If current price at `right` is higher than at `left`, compute profit.
- Update max profit if this profit is higher.
- If price at `right` is lower, shift `left` to `right` (new lower buy price).
- Move `right` forward in each iteration.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int maxProfit(int[] prices) {
        int left = 0, right = 1, profit = 0;
        while (right < prices.length) {
            if (prices[right] >= prices[left]) {
                profit = Math.max(profit, prices[right] - prices[left]);
            } else {
                left = right;
            }
            right++;
        }
        return profit;
    }
}
