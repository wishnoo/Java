package ProblemSolving.Miscellaneous.BestStockPrice;

public class BestStockPrice2 {
    
    // This solution utilized two pointers
    public int solution(int[] prices) { 
        // i saves the lowest value 
        // j is utilized to iterate through the array.
        int i = 0, j = 1;
        int max = 0;

        // iterating though the array
        while (j < prices.length){
            // If there is a value less than the value at i reset i to j.
            if(prices[j] < prices[i]){
                i = j;
            }
            // else you have some difference and update max.
            else{
                max = Math.max(max, prices[j] - prices[i]);
            }
            j++;
        }
        // return int max.
        return max;
    }

    public static void main(String[] args) {
       BestStockPrice obj = new BestStockPrice();
        int[] prices1 = {7,1,5,3,6,4};
        System.out.println(obj.solution(prices1));
        // obj.solution(prices1) should return:
        // 5

        int[] prices2 = {7,6,4,3,1};
        System.out.println(obj.solution(prices2));
        // obj.solution(prices2) should return:
        // 0
    }

    // Complexity Analysis
        // Time Complexity - O(n). Only a single pass is needed.
        // Space Complexity - O(1). Only variables are used.
}
