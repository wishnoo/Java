package Miscellaneous.ReversingCoins;

/**
 * ReversingCoins
 */
public class ReversingCoins {

    public int solution(int N) {
        
        // An array to store the position (Head or Tail) of all the coins
        // Create an array of size N + 1 , don't utilize the 0th index.
        // By default all indexes will be of value 0.
        // For this problem we assume 0 is head position.
        int[] coin = new int[N + 1];
        int result = 0;

        // Loop from 1 to N
        for (int i = 1; i < N + 1; i++) {
            // k is used to iterate through all the multiples of i.
            int k = i;
            
            // Loop through all multiples of i with help of k upto N.
            while (k <= N){
                // This statement sets 1 to 0 or 0 to 1. This is a good way to shift between 0 and 1.
                // Assume 1 is tail position.
                coin[k] = (coin[k] + 1) % 2;
                // Increase k with i to go to the next multiple of i.
                k += i;
            }
            // Now the ith element has been processed and can be updated in the result. Result adds all the positions.
            result += coin[i];
        }

        // After processing all the elements in the for loop, result will contain the number of tail positions.
        return result;
    }
    public static void main(String[] args) {
        ReversingCoins obj = new ReversingCoins();

        int N1 = 10;
        System.out.println(obj.solution(N1));
        // obj.solution(N1) should return:
        // 3

        int N2 = 11;
        System.out.println(obj.solution(N2));
        // obj.solution(N2) should return:
        // 3

        int N3 = 16;
        System.out.println(obj.solution(N3));
        // obj.solution(N3) should return:
        // 4
    }

    // Complexity Analysis

    // Time Complexity - 0(nlogn) - The number of operation can be estimated by n/1 + n/2 + ... + n/n which equal to n(1/1 + 1/2 + ... + 1/n)
    // The sums of multiplicative inverses (reciprocals) of the first n numbers are called harmonic numbers, which asymptotically equal O(log n).
    // In summary, the total time complexity is O(n log n)
    
    // Space Complexity - 0(n) - Use to array to store the current position.
}