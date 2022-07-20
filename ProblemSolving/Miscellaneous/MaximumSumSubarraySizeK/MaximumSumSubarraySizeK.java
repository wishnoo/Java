package ProblemSolving.Miscellaneous.MaximumSumSubarraySizeK;

/**
 * MaximumSumSubarraySizeK
 */
public class MaximumSumSubarraySizeK {

    // Approach 1 : Brute Force
    public int solution(int[] input, int k) {
        int maxSum = 0;

        // To avoid out of bounds exception for the inner loop we iterate up to the 3rd element from behind.
        for (int i = 0; i <= input.length - k; i++) {
            int windowSum = 0;
            for (int j = i; j < k + i; j++) {
                windowSum += input[j];
            }
            maxSum = Math.max(windowSum, maxSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSumSubarraySizeK obj = new MaximumSumSubarraySizeK();
        int[] input = {2,1,5,1,3,2};
        int k = 3;
        System.out.println(obj.solution(input, k));
    }

    // Complexity Analysis
        // Time Complexity - Time complexity : O(N * K), where N is the number of elements and K is the number of elements of which you need to find the sum.
        // Space Complexity - 0(1) - Constant memory
}