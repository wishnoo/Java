package ProblemSolving.Miscellaneous.MaxProductOfThree;

public class MaxProductOfThree {
    /* Something to note here is that two negative numbers when multiplied create a positive number.
        Taking that into account we will have two possibilities 
            a. The largest three numbers 
            b. The smallest two numbers and the largest number (Assuming the smallest two can be negative if not the first case will win) */

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
    }
}
