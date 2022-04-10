package ProblemSolving.List.ArrayList.CountSemiPrimes;

import java.util.ArrayList;
import java.util.Arrays;

public class CountSemiPrimes {

    public int[] solution(int N, int[] P, int[] Q) {
        // prime array is to find the primes below N / 2.
        // The reason we pass N / 2 : Our goal is to find SemiPrimes and the lowest prime is 2 which means one of the factor of SemiPrime should be at least 2 or above.
        // If our N is 26 then we just need to find primes upto 13 because if we use the primes above that it would not be within 26. for eg. 17 is the next prime and any prime product with 17 will be greater then 26.
        // Here we are expecting an integer array instead of int. This because we are making use of list within sieve function.
        Integer[] prime = sieve(N / 2);

        // find SemiPrimes below N
        // semiPrime array consists of 0's and 1's where 1 is present and 0 is not present.
        int[] semiPrime = semiPrime(prime, N);

        // find sum of semiPrimes instances at any index. Similar to Kadane's algorithm.
        int[] semiPrimeSum = new int[N + 1]; 
        for (int i = 1; i < semiPrime.length; i++) {
            // Update the current semiPrimeSum value based on its previous value and the current semiPrime value (0's and 1's).
            semiPrimeSum[i] = semiPrimeSum[i - 1] + semiPrime[i];
        }

        // The result will be of same length as P and Q 
        int[] result = new int[P.length];

        // Since P and Q are of same length iterate based on either of its length.
        for (int j = 0; j < P.length; j++) {
            // Q has upper limit and P has the lower limit.
            // At index of Q or P semiPrimeSum represents the sum of SemiPrimes inclusive of Q or P
            // We require the SemiPrimes from P to Q inclusive of both numbers
            // To achieve that we subtract the sum at Q index with the P - 1 index. We used P - 1 so that we don't subtract P's value.
            result[j] = semiPrimeSum[Q[j]] - semiPrimeSum[P[j] - 1];
        }

        // Return the result array.
        return result;
    }

    public Integer[] sieve (int N){
        // This function is used to find all the primes below the passed value N using sieve of Eratosthenes algorithm.
        // By default boolean array consists of value false.
        boolean[] process = new boolean[N + 1];
        // Fill the process array with true.
        Arrays.fill(process, Boolean.TRUE);
        // We can make index 0 and 1 false but in this case as you see below we make sure we start the index from 2.
        // Prime starts from 2
        int i = 2;
        // ArrayList to store the prime value which are the true indexes in the process array.
        ArrayList<Integer> prime = new ArrayList<>();

        // Sieve of Eratosthenes implementation
        while (i * i <= N) {
            if (process[i]) {
                int j = i * i;
                while(j <= N){
                    process[j] = false;
                    j += i;
                }
            }
            i++;
        }

        // Save the true values indexes of process array into prime List. 
        for (int k = 2; k <= N; k++) {
            if(process[k])
                prime.add(k);
        }

        // When we use arrayList it is easy to convert it into an Integer array of same size. int array would not work here.
        // We require the new statement as argument because by default toArray method returns an Object array.
        return prime.toArray(new Integer[prime.size()]);
    }

    public int[] semiPrime(Integer[] prime, int N){
        // create an int array of size N + 1.
        // We need to find the SemiPrimes below inclusive of N and the max SemiPrimes can be N
        // Reason we used N + 1 is because we omitting the 0 index to match index with value fromm 1 to N.
        int[] semiPrime = new int[N + 1];

        // From the prime array find combination of all products below or equal to N. SemiPrime is product of 2 primes.
        for (int i = 0; i < prime.length; i++) {
            for (int j = i; j < prime.length; j++) {
                int product = prime[i] * prime[j];
                if(product <= N)
                    semiPrime[product] = 1;
            }
        }
        // Return int array.
        return semiPrime;
    }

    public static void main(String[] args) {
        
        CountSemiPrimes obj = new CountSemiPrimes();
        int N = 26;
        int[] P = {1, 4, 16};
        int[] Q = {26, 10, 20};
        System.out.println(Arrays.toString(obj.solution(N, P, Q)));
        // obj.solution(N, P, Q) should return:
        // [10, 4, 0]
    }
}
