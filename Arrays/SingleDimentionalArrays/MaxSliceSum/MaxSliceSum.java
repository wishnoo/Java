package Arrays.SingleDimentionalArrays.MaxSliceSum;

public class MaxSliceSum {
    
    // This solution is similar to Contiguous subarray solution. We can use kadane algorithm to solve the solution.
    public int solution(int[] A) {
        //Inputs
        // N is atleast 1
        // N can be negative
        // N is not sorted

        // Since the input contains negative integers it is safer to use first element to initialize the current sum and max sum.
        // Using Integer.MIN_VALUE would create overflow if we add with a negarive integer.
        int currentSum = A[0];
        int maxSum = A[0];

        // Edge case
        // The question has mentioned that the input will be atleast 1
        if(A.length == 1){
            return A[1];
        }

        for (int i = 1; i < A.length; i++) {
            // currentSum is updated when the currentSum of elements is less that current processing element.
            currentSum = Math.max(currentSum + A[i], A[i]);
            // Update maxSum if neccessary.
            maxSum = Math.max(maxSum, currentSum);   
        }
        // since we are constantly updating the maxSum we do not require to check for maxSum after the forloop (end of the array).
        // if we had updated the maxSum when there was a change in currentSum then we would have to check maxSum outside to forloop inorder to compare with the lastest currenSum.
        return maxSum;
    }

    public static void main(String[] args) {
        MaxSliceSum obj = new MaxSliceSum();
        int[] A1 = {3,2,-6,4,0};
        System.out.println(obj.solution(A1));
        // solution(A1) should return 5

        int[] A2 = {-10};
        System.out.println(obj.solution(A2));
        // solution(A2) should return -10


        // Complexity Analysis
        // Time Complexity - 0(n) - processes all elements once.
        // Spcae Complexity - 0(1) - no extra space other than input and single values like currentSum and maxSum.
    }
}
