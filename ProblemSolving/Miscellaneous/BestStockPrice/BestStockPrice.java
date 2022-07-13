package ProblemSolving.Miscellaneous.BestStockPrice;

public class BestStockPrice {
    
    // This question can be solve using Kadane's algorithm. 
    // current sum saves the difference value and is used for the next iteration. Initial value is 0
    // From the given example [7,1,5,3,6,4] 
    // 1-7 = -6 this indicates the stock has reduced and we don't care about 7 anymore we would rather buy at 1 and sale at a latter point
    // How to retrieve the difference two far apart values:
    // 5-1 = 4 so 4 is stored in current sum
    // 3 - 5 = -2 we add -2 with current sum which is 4 and we get 2 which is the difference between 3 and 1. So the overall operation we did combined with previous line is 5 - 1 + 3 - 5
    // Notice how the 5 cancels each other out. This is how we carry over our difference ahead
    // 6-3 = 3 adding current sum which is 2 we get 5
    // at each iteration we update max sum and this allows us to store the max difference.
    // whenever the value is less than 0 we can reset current sum to 0 which means we starting from scratch for that iteration.

    public int solution(int[] prices) {
        
        int currentProfit = 0;
        int maxProfit = 0;
        // iterate from 0 to length - 1 to avoid index out of bound exception. 
        for (int i = 0; i < prices.length -1; i++) {
            int temp = (prices[i+1] - prices[i]) + currentProfit;
            currentProfit = Math.max(temp, 0);
            maxProfit = Math.max(currentProfit, maxProfit);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        BestStockPrice obj = new BestStockPrice();
        // int[] prices = {7,1,5,3,6,4};
        int[] prices = {7,6,4,3,1};
        System.out.println(obj.solution(prices));
    }

    // Complexity Analysis
        // Time Complexity - O(n). Only a single pass is needed.
        // Space Complexity - O(1). Only two variables are used.
}
