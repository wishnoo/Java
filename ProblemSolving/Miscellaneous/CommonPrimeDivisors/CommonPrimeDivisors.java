package ProblemSolving.Miscellaneous.CommonPrimeDivisors;

public class CommonPrimeDivisors {
    public int solution(int[] A, int[] B) {
        // If integer A[i] and B[i] has the same set of prime divisors, A[i] repeatedly divided by the prime divisors of B[i], we can get 1 at last.
        // And also B[i] repeatedly divided by the prime divisors of A[i], we can get 1 at last too.

        // GCD (greatest common divisor) of A[i] and B[i] is a multiple of prime divisors, so we can use gcd to simplify calculations.
        // For eg. gcd of (10 , 30) , prime divisors are (2, 5) and (2,3,5) respectively.
        // 30 can be divided by the prime divisors of 10 but 10 cannot be divided by the prime divisors of 30. 

        // Extended E.g.:
        // A[i] = 270  B[i] = 60

        // For A[i] must meet condition like:
        // 270    60            -> 270%60 != 0 -> 
        // gcd(270, 60) = 30    -> 60/30=2     ->
        //         2            -> 270%2  == 0 -> OK

        // For B[i] must meet condition like:
        // 60    270            -> 60%270 != 0 -> 
        // gcd(60, 270) = 30    -> 270/30 == 9 ->
        //         9            -> 60%9 != 0   ->
        // gcd(60, 9) = 3       -> 9/3 == 3    ->
        //         3            -> 60%3 == 0   -> OK
        int count = 0;
        for (int i = 0; i < B.length; i++) {
            if(A[i] == B[i]){
                count++;
                continue;
            }
            if(hasPrimeFactors(A[i], B[i]) && hasPrimeFactors(B[i], A[i])){
                count++;
            }
        }
        return count;
    }
    
    // hasPrimeFactors finds if prime divisors of A contains the prime divisors of B.
    public boolean hasPrimeFactors(int A, int B) {
        // If B divides A without a remainder then we know the prime divisors of A contains the prime divisors of B
        if(A % B == 0)
            return true;
        // Find the gcd to find the divisor which is a multiple of prime divisors.
        int GCD = gcdBinary(A, B, 1);

        // If GCD is equal to 1 at this particular iteration, divisors of B are not in A and thus there is difference in prime divisor. 
        if(GCD == 1)
            return false;
        
        // B / GCD represents the remaining factors that B has after the GCD 
        // For eg: 15 and 60 for the second iteration we would have hasPrimeFactors (15, 60 / 15)
        // 60 / 15 = 4 where 4 is the remaining factor after GCD ie 15 to make up the number.
        // In the third iteration - GCD (15, 4) will be 1 and it would return false after that.
        return hasPrimeFactors(A, B / GCD);
    }

    // Find gcd based on binary representation.
    public int gcdBinary(int a, int b, int res) {
        if (a == b) return res * a;
        else if (a % 2 == 0 && b % 2 == 0) return gcdBinary(a >> 1, b >> 1, 2 * res);
        else if (a % 2 == 0) return gcdBinary(a >> 1, b, res);
        else if (b % 2 == 0) return gcdBinary(a, b >> 1, res);
        else if (a > b) return gcdBinary(a - b, b, res);
        else return gcdBinary(a, b - a, res);
    }

    public static void main(String[] args) {
        CommonPrimeDivisors obj = new CommonPrimeDivisors();
        int[] A = {15, 10, 3};
        int[] B = {75, 30, 5};
        System.out.println(obj.solution(A, B));
        // obj.solution (A, B) should return:
        // 1
    }

    // Complexity Analysis
        // Time Complexity - O(Z * log(max(A) + max(B))**2) => Detected by Codility
        // Space Complexity - (N)
}
