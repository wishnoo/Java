package Arrays.SingleDimentionalArrays.MaxSliceDoubleSum;

public class MaxSliceDoubleSum {
    
    public int solution(int[] A) {
        // we require two arrays
        // left to store the sum upto each index as you move along from left to right.
        // right to store the sum upto each index as you move along from right to left
        int[] left = new int[A.length];
        int[] right = new int[A.length];

        int maxSum;

        // Edge Case
        // According to question N cannot be empty so no need to check empty/null case
        // If the length is 3 or below we cannont find a sum and therefore can return 0.
        if(A.length < 4)
            return 0;

        // As this is a double slice sum the first index (X) and last index (Y) will not be included in any combination and they can be avoided.
        // This is the reason we iterate from 1 upto A.length - 2
        // We are also making use of a property of Java arrays where the default value is 0 and not null
        // When we are adding the 0 index value with the first index it does not result in an error as the 0 index consists of the value 0.
       
        for (int i = 1; i < A.length - 1; i++) {
            left[i] = Math.max(left[i - 1] + A[i], A[i]);

            // Since X Y Z are close to each other the value is 0 so the minumum value you can get is 0. 
            // If negative values arise we would keep the triplet close to each to get atleast 0.
            // Even when there is a mix of negative and positive values for eg: [0, 10, -5, -2, 0] 
            // we could get the answer 10 if we place X at 0, Y at -5 and Z at -2
            // Which means anytime time we encounter negative we reset it to 0.

            if(left[i] < 0)
                left[i] = 0;

        // we could avoid the if loop by implementing like this:
        // left[i] = Math.max(left[i - 1] + A[i], 0);
        // if we are resetting all negatives to zero Math.max(left[i - 1] + A[i], A[i]) will only be equal to A[i] if either left[i - 1] or A[i] is negative
        // since we know that left[i - 1] cannot be negative as we reset them from beginning all we need to check is if left[i - 1] + A[i] > 0 
        }

        // Similarly store the max sum from A.length - 2 to 1 in the right array
        for (int j = A.length - 2; j > 0; j--) {
            right[j] = Math.max(right[j + 1] + A[j], A[j]);

            if(right[j] < 0)
                right[j] = 0;
        }

        // The reason to use Kandane's algorithm here and not just add one element after the other upto the current index is because
        // If you think of brute force method you will have to shift X Y Z in multiple locations and find the splice between these 3 to find the sum
        // Now with Kadane's approach, at a particular index you get the max value from the one side anyway 
        // that means you dont have to move the X and Z and find their combination sum with respect to each other.
        // instead we could place X and Z at the end itself and move the Y along every index. 

        // we need a loop where we could shift y and calculate left sum and right sum, add it and store it in variable
        // left[i - 1] and left [i + 2] allows us to skip an element in between considered to be Y in case of the problem.
        // the iteration happens from 1 to A.length - 2 and this allows left [i - 1] and right [i + 1] to not reach out of bounds.
        // maxSum is assigned as Integer.MIN_VALUE as assigning zero or first element of either array can cause issues for negative value comparison.
        maxSum = Integer.MIN_VALUE;
        for (int i = 1; i < A.length - 1; i++) {
            maxSum = Math.max(left[i - 1] + right[i + 1], maxSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        MaxSliceDoubleSum obj = new MaxSliceDoubleSum();
        int[] A = {3,2,6,-1,4,5,-1,2};
        System.out.println(obj.solution(A));
        // obj.solution(A) must return:
        // 17

        int[] B = {-3,-2,-6,-1,-4,-5,-1,-2};
        System.out.println(obj.solution(B));
        // obj.solution(B) must return:
        // 0
        
        int[] C = {0, 10, -5, -2, 0};
        System.out.println(obj.solution(C));
        // obj.solution(C) must return:
        // 10


    }
}
