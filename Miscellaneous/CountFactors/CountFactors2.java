package Miscellaneous.CountFactors;

public class CountFactors2 {
    
    public int solution(int N) {
        
        int factors = 0;

        // Edge case
        // N starts from 1
        if(N == 1)
            return 1;
        
        // There is a simple way to find an optimal solution
        // Based on one divisor we can find the symmetric divisor.
        // if number a is a divisor of n, then n a is also a divisor. One of these two divisors is less than or equal to √n. 
        // If that were not the case, n would be a product of two numbers greater than √n, which is impossible.
        // For eg: if N = 12 if 2 is a divisor then N/2 which 12/2 = 6 is also a divisor. 
        // The two divisors cannot be both greater than the root, in this eg root is less than 4. There can be two divisors 4 and 4 or greater as it would be greater than the number.

        // Instead of manipulating the sqrt, we can use the theory where i * i is less than N where i starts from 1.
        int i = 1;
        // the reason we used less than "<" and not less than equal to "<=" is so that we don't encounter the condition i * i = N
        // This avoids duplication in such a case.
        while (i * i < N) {
            if(N % i == 0)
                factors += 2;
            i++;
        }

        // if i * i = N then add 1
        if(i * i == N)
            factors += 1;
        
        return factors;
    }

    public static void main(String[] args) {
        CountFactors2 obj = new CountFactors2();
        int N1 = 16;
        System.out.println(obj.solution(N1));
        // obj.solution(N1) should return:
        // 5
        int N2 = 15;
        System.out.println(obj.solution(N2));
        // obj.solution(N2) should return:
        // 4

        // Complexity Analysis
        // Time Complexity - 0(N) - sqrt is greater than logN steps but smaller than N since it is a factor of N based on rule 2 we can omit constants.
        // Space Complexity - 0(1) - No data type other than factors used here that scales with N.
    }
}
