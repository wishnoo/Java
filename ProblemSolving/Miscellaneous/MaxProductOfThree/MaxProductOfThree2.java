package ProblemSolving.Miscellaneous.MaxProductOfThree;
public class MaxProductOfThree2 {
    /* Something to note here is that two negative numbers when multiplied create a positive number.
        Taking that into account we will have two possibilities 
            a. The largest three numbers 
            b. The smallest two numbers and the largest number (Assuming the smallest two can be negative if not the first case will win) */

    public int solution (int[] A) {
        int[] maxes = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        // Invariant: maxes[0] <= maxes[1] <= maxes[2]
        int[] mins = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        // Invariant: mins[0] <= mins[1]
        // O(n)
        for( int a : A )
        {
            updateMaxes( a, maxes );
            updateMins( a, mins );
        }
        int obvious = maxes[0] * maxes[1] * maxes[2];
        int twoBigNegs = mins[0] * mins[1] * maxes[2];
        return Math.max( obvious, twoBigNegs );
    }

    private void updateMaxes( int a, int[] maxes )
    {
        if( a >= maxes[2] ) {
            // Found new max, shift down
            maxes[0] = maxes[1];
            maxes[1] = maxes[2];
            maxes[2] = a;
        } else if( a >= maxes[1] ) {
            maxes[0] = maxes[1];
            maxes[1] = a;
        } else if( a > maxes[0] ) {
            maxes[0] = a;
        }
    }
    private void updateMins( int a, int[] mins )
    {
        if( a <= mins[0] ) {
            // Found new min, shift down
            mins[1] = mins[0];
            mins[0] = a;
        } else if( a < mins[1] ) {
            mins[1] = a;
        }
    }


    public static void main(String[] args) {
        MaxProductOfThree obj = new MaxProductOfThree();
        int[] A = {-3,1,2,-2,5,6};
        System.out.println(obj.solution(A));
        // obj.solution(A) should return:
        // 60
    }

    // Complexity Analysis
        // Time Complexity - 0(N) - Iterated once over the array
        // Space Complexity - 0(1) - Array data structure used to store min and max does not grow based on input.
}
