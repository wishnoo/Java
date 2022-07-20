package ProblemSolving.Miscellaneous.MaximumSumSubarraySizeK;

public class MaximumSumSubarraySizeK2 {
    
    // Approach 2 : Use sliding window method to reduce complexity to 0(N).
    // If you observe closely, you will realize that to calculate the sum of a contiguous subarray, we can utilize the sum of the previous subarray. 
    // For this, consider each subarray as a Sliding Window of size ‘k.’ To calculate the sum of the next subarray, we need to slide the window ahead by one element. So to slide the window forward and calculate the sum of the new position of the sliding window, we need to do two things:
    // Subtract the element going out of the sliding window, i.e., subtract the first element of the window.
    // Add the new element getting included in the sliding window, i.e., the element coming right after the end of the window.
    // This approach will save us from re-calculating the sum of the overlapping part of the sliding window.
    public int solution(int[] input, int k) {
        
        int windowStart = 0, maxSum = 0, windowSum = 0;

        for (int windowEnd = 0; windowEnd < input.length; windowEnd++) {
            windowSum += input[windowEnd];

            // This condition satisfies the adding upto to the first k elements and then repetition of moving window thereafter. 
            if(windowEnd >= k - 1){
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= input[windowStart];
                windowStart++;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSumSubarraySizeK2 obj = new MaximumSumSubarraySizeK2();
        int[] input = {2,1,5,1,3,2};
        int k = 3;
        System.out.println(obj.solution(input, k));
    }

    // Complexity Analysis
        // Time Complexity - Time complexity : O(N), where N is the number of elements.
        // Space Complexity - 0(1) - Constant memory
}
