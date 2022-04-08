package Algorithm.Sieve;

import java.util.Arrays;

public class Sieve {
    public boolean[] solution(int N) {
        // boolean array which will result in all prime numbers to be true after processing.
        // Default value of boolean array is false.
        // Size is taken as N + 1 this is because we will match each index with N. 
        boolean[] sieve = new boolean[N + 1];
        // Make all the values of the array as true
        Arrays.fill(sieve, Boolean.TRUE);
        // We omit the first two indexes as 0 and 1 cannot be prime. Set it to false.
        sieve[0] = false;
        sieve[1] = false;

        // Prime numbers starts from 2.
        int i = 2;

        // The logic here is to process a prime number and eliminate all the succeeding factors of it by setting them to false.
        // In our logic below the second while loop starts from i * i 
        // if thats the case if i * i is greater then N there is no point of processing elements after that point.
        // Looping though the numbers upto square root of N will eliminate all the factors after then upto N.
        while (i * i <= N) {
            // If loop to determine if the element is processed or not. if it is not processed then proceed.
            if(sieve[i] == true){
                // While encountering a prime we dont have to process all the elements after prime.
                // we can jump to i * i element and proceed towards N
                // This is because all elements below i * i would have been processed by one of prime factors of those elements.
                // For eg; 3 we start from 9 because all elements below 9 would be processed by 2, 5 and 7.
                // The ith element which is a prime number still remains as true and is not set to false. 
                int k = i * i;
                while (k <= N) {
                    // Set the processed elements as false.
                    sieve[k] = false;
                    // k is incremented by i which means we are processing the multiples of i.
                    k += i;
                }
            }
            // Increment i for while loop.
            i++;
        }
        // Return the array where all primes are true and all composite numbers are false.
        return sieve;
    }
    public static void main(String[] args) {
        Sieve obj = new Sieve();
        System.out.println(Arrays.toString(obj.solution(17)));
    }
}