package ProblemSolving.List.ArrayList.CountSemiPrimes;

import java.util.Arrays;

public class CountSemiPrimes2 {
    public int[] solution(int N, int[] P, int[] Q) {
        // We didn't half the input size as we need to find the prime factors of all elements below N.
        int[] primeFactors = primeFactors(N);

        // The result will be of same length as P and Q 
        int[] result = new int[P.length];
        
        // Find all the semi primes represented as 1 and non semi primes represented as 0.
        int[] semiPrimeArray = semiPrimeArray(N, primeFactors);

        // find sum of semiPrimes instances at any index. Similar to Kadane's algorithm.
        int[] semiPrimeSum = semiPrimeSum(semiPrimeArray);

        // Since P and Q are of same length iterate based on either of its length.
        for (int i = 0; i < P.length; i++) {
            // Q has upper limit and P has the lower limit.
            // At index of Q or P semiPrimeSum represents the sum of SemiPrimes inclusive of Q or P
            // We require the SemiPrimes from P to Q inclusive of both numbers
            // To achieve that we subtract the sum at Q index with the P - 1 index. We used P - 1 so that we don't subtract P's value.
            result[i] = semiPrimeSum[Q[i]] - semiPrimeSum[P[i] - 1];
        }
        
        // result result array.
        return result;
    }

    // primeFactors is based on factorization of sieve of Eratosthenes.
    // It returns an array where the indexes that represent the composite numbers contain the first prime divisor of the number.
    public int[] primeFactors(int N) {
        // Reason we used N + 1 is because we omitting the 0 index to match index with value fromm 1 to N.
        int[] temp = new int[N + 1];
        int i = 2;
        while(i * i <= N){
            if(temp[i] == 0){
                int j = i * i;
                while (j <= N) {
                    if(temp[j] == 0){
                        // If index is not processed replace 0 with i.
                        temp[j] = i;
                    }
                    j += i;
                }
            }
            i++;
        }
        return temp;
    }

    // semi Prime function to find whether a num is semi prime or not.
    // Based on the primeFactors array we find if the number has exactly two factors. 
    // Which means num index should have a value and then num/ primeFactors[num] should have 0 which is exactly two factors.
    public boolean semiPrime (int num, int[] primeFactors){
        if(primeFactors[num] == 0)
            return false;
        num = num / primeFactors[num];

        if(primeFactors[num] == 0)
            return true;    
        
        return false;    
    }

    // Create an array of semiPrimes with help of semiPrime method
    public int[] semiPrimeArray(int N, int[] primeFactors) {
        int[] semiArray = new int[N + 1];

        for (int i = 4; i < primeFactors.length; i++) {
            if(semiPrime(i, primeFactors)){
                semiArray[i] = 1;
            }
        }
        return semiArray;
    }

    // Find the sum of semiPrimes at a particular index.
    public int[] semiPrimeSum (int[] semiPrimeArray){
        int[] sumArray = new int[semiPrimeArray.length];

        for (int i = 1; i < semiPrimeArray.length; i++) {
            // Update the current semiPrimeSum value based on its previous value and the current semiPrime value (0's and 1's).
            sumArray[i] = sumArray[i - 1] + semiPrimeArray[i];
        }

        return sumArray;
    }

    public static void main(String[] args) {
        CountSemiPrimes2 obj = new CountSemiPrimes2();
        int N = 26;
        int[] P = {1, 4, 16};
        int[] Q = {26, 10, 20};
        System.out.println(Arrays.toString(obj.solution(N, P, Q)));
        // obj.solution(N, P, Q) should return:
        // [10, 4, 0]
    }
    // Complexity Analysis
        // Time Complexity - 0(N * log(log N) + M)
        // 0(N * log(log N)) is the complexity for a series of reciprocal of primes times N.(Harmonic series of primes)
        // 0(M) is the complexity of rest of for loops.

        // Space Complexity - 0(N)
        // Array's used space upto max N + 1
        // Even though it should have 3 * N Based on the 2nd rule of Big 0 we can avoid all the constants.
}
