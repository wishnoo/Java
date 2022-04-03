package Arrays.SingleDimentionalArrays.CountFactors;

public class CountFactors {
    
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

        // Find the sqrt of the number. Here since we are assigning a double value to int, It saves the floor value. 
        // For eg: 3.6 will be converted to 3.
        int squareRootN = (int) Math.sqrt(N);

        // If the sqrt value k to the power of 2 is equal to the given number. The sysmmetric divisor of k will be k. 
        // eg: If N is 16 and k is 4 the symmetric divisor of 4 is 16/4 which is 4.
        // To avoid duplicates we do not process that element and manually increase the factor by 1.
        if(Math.pow(squareRootN, 2) == N)
            factors++;
        // If k to the power of 2 is not equal to N then increase the squareRootN value 
        // this is just increased to use one forloop for both cases and in this case we need to also process the closest sqrt value to N.
        else
            squareRootN++;
        
        // Divide all the numbers upto squareRootN and if they divide without remainder then add 2 instead of 1 to include the symmetric divisor. 
        for (int i = 1; i < squareRootN; i++) {
            if(N % i == 0)
                factors = factors + 2;
        }
        return factors;
    }

    public static void main(String[] args) {
        CountFactors obj = new CountFactors();
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
