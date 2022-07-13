package ProblemSolving.Miscellaneous.Triangle;

import java.util.Arrays;

public class Triangle {
    // For this solution the triplets cannot be negative or zero they need to be positive.
    // A[P] + A[Q] > A[R] cannot be realized if one of them is negative or zero
    // Sorting the array will meet two conditions
    // A[Q] + A[R] > A[P] & A[R] + A[P] > A[Q] will be met.
    // Now we need to just check if A[P] + A[Q] > A[R] condition is met and it is positive.

    public int solution(int[] A) {

        if(A == null || A.length < 3){
            return 0;
        }

        // sort the input
        Arrays.sort(A);

        // Iterate to check A[P] + A[Q] > A[R] and the input value is positive. This would make sure that all triplets are positive too.
        // To avoid out of bounds exception iterate up to A.length-2
        for (int i = 0; i < A.length-2; i++) {
            // Cast to long to avoid the addition be outside Integer size
            // The reason we only type cast one element is that the runtime would automatically recognize the long element and use long for the rest of the elements to complete the operation.
            if(A[i] > 0 && A[i] + (long)A[i+1] > A[i+2]) return 1;
            // We can also calculate the above comparison as such:
            // A[i+2] - A[i-1] > A[i]
            // In this case we don't have to cast to long.
        }
        // if the condition inside iteration is not met return 0.
        return 0;
        
    }

    public static void main(String[] args) {
        Triangle obj = new Triangle();

        int[] A = {10,2,5,1,8,20};
        System.out.println(obj.solution(A));
        // obj.solution(A) should return:
        // 1

        int[] B = {10,50,5,1};
        System.out.println(obj.solution(B));
        // obj.solution(B) should return:
        // 0
    }

    // Complexity Analysis
        // Time Complexity - 0(Nlog(N)) - sorted the array and based on Rule 4 of Big 0 we can drop the non dominant term which is N for iterating over the array.
        // Space Complexity - 0(1) - No data structure used to affect space.
}
