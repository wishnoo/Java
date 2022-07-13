package ProblemSolving.Miscellaneous.MaxProductOfThree;

public class MaxProductOfThree {
    /* Something to note here is that two negative numbers when multiplied create a positive number.
        Taking that into account we will have two possibilities 
            a. The largest three numbers 
            b. The smallest two numbers and the largest number (Assuming the smallest two can be negative if not the first case will win) */
    /* This is an interesting way of doing it. Create an array with size of needed values and fill with either Integer.MAX_VALUE or Integer.MIN_VALUE depending on whether you want the largest or lowest number.
    In the main loop send the created array with new element to a two methods namely updateMaxes and updateMins. These methods implement the same logic as the first answer. */


    public int solution (int[] A) {
        int maxOne = Integer.MIN_VALUE, maxTwo = Integer.MIN_VALUE, maxThree = Integer.MIN_VALUE;
        int minOne = Integer.MAX_VALUE, minTwo = Integer.MAX_VALUE;
        
        for (int i = 0; i < A.length; i++) {
            if(A[i] > maxOne) {
                maxThree = maxTwo;
                maxTwo = maxOne;
                maxOne = A[i];
            }
            else if(A[i] > maxTwo){
                maxThree = maxTwo;
                maxTwo = A[i];
            }
            else if(A[i] > maxThree){
                maxThree = A[i];
            }

            if(A[i] < minOne){
                minTwo = minOne;
                minOne = A[i];
            }
            else if(A[i] < minTwo){
                minTwo = A[i];
            }
        }

        return Math.max(maxOne * maxTwo * maxThree, minOne * minTwo * maxThree);
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
        // Space Complexity - 0(1) - No data structure used.
}
