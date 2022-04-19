package ProblemSolving.Arrays.SingleDimentionalArrays.AbsDistinct;

public class AbsDistinct {
    public int solution(int[] A) {
        // input array - Ascending order
        // If we assume that we have negative number and a positive number such that abs value of both are the same.
        // Since the array is ordered, once we encounter the first negative number(part of the duplicate pair) from the left side then 
        // we would encounter its pair on the right side first before we encounter any other duplicates. 
        int head = 0;
        int tail = (A.length) - 1;
        int currMax = Math.max(Math.abs(A[head]), Math.abs(A[tail]));
        int count = 1;
        
        // If head is Integer.MIN_VALUE which is -2147483648 then the absolute value will not change because
        // int can only include numbers from -2147483648 to 2147483647 and therefore positive 2147483648 cannot be created within int and it returns the same value.
        // currMax would not save this and therefore we manually set it to currMax.
        // -2147483648 can only occur in the the beginning of the array as it is the least value you can get for an int array 
        // Therefore you can check before the while loop.
        if(A[head] == Integer.MIN_VALUE){
            currMax = Integer.MIN_VALUE;
        }

        while (head <= tail){
            int currHead = Math.abs(A[head]);
            int currTail = Math.abs(A[tail]);

            if(currHead == currMax){
                head++;
            }
            else if(currTail == currMax) {
                tail--;
            }
            else if(currHead >= currTail){
                currMax = currHead;
                head++;
                count++;
            }
            else{
                currMax = currTail;
                tail--;
                count++;
            }

            
        }
        return count;
    }

    public static void main(String[] args) {
        AbsDistinct obj = new AbsDistinct();
        int[] A = {-5,-3,-1,0,3,6};
        int[] B ={-10};
        int[] C ={-2147483648, -1, 0, 1};

        System.out.println(obj.solution(A));
        // obj.solution(A) must return:
        // 5
        System.out.println(obj.solution(B));
        // obj.solution(A) must return:
        // 1
        System.out.println(obj.solution(C));
        // obj.solution(A) must return:
        // 3
    }

    // Complexity Analysis
        // Time Complexity - 0(n) - The solution processes all elements once.
        // Space Complexity - 0(1) - No extra data structure used which is based on input.
}
