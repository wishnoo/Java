package ProblemSolving.Miscellaneous.SmallestSubarrayGreaterSum;

/**
 * SmallestSubarrayGreaterSum
 */
public class SmallestSubarrayGreaterSum {

    // Approach 1 : Sliding Window

    public int solution(int[] input, int sum) {
        
        int windowSum = 0, windowStart = 0, minLength = Integer.MAX_VALUE;
        
        for (int windowEnd = 0; windowEnd < input.length; windowEnd++) {
            // we will add-up elements from the beginning of the array until their sum becomes greater than or equal to ‘S.’
            windowSum += input[windowEnd];

            // These elements will constitute our sliding window. 
            // We are asked to find the smallest such window having a sum greater than or equal to ‘S.’ We will remember the length of this window as the smallest window so far.
            while(windowSum >= sum){
                // we will keep adding one element in the sliding window (i.e., slide the window ahead) in a stepwise fashion.
                // We will shrink the window until the window’s sum is smaller than ‘S’ again. This is needed as we intend to find the smallest window.
                minLength = Math.min(windowEnd - windowStart + 1, minLength);
                windowSum -= input[windowStart];
                windowStart++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        SmallestSubarrayGreaterSum obj = new SmallestSubarrayGreaterSum();
        int[] input = {2, 1, 5, 2, 3, 2};
        int sum = 7;
        System.out.println(obj.solution(input, sum));
        // obj.solution(input, sum) should return:
        // 2

        int[] input2 = {1, 1, 1, 1, 1, 1};
        int sum2 = 7;
        System.out.println(obj.solution(input2, sum2));
        // obj.solution(input2, sum2) should return:
        // 0
    }

    // Complexity Analysis
        // Time Complexity - Time complexity : O(N), where N is the number of elements, The outer for loop runs for all elements, and the inner while loop processes each element only once; therefore, the time complexity of the algorithm will be O(N+N), which is asymptotically equivalent to O(N).
        // Space Complexity - 0(1) - Constant memory
}