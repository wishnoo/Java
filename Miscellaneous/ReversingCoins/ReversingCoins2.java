package Miscellaneous.ReversingCoins;

public class ReversingCoins2 {

    public int solution(int N) {
        
        // int value to store the number of tail positions.
        int result = 0;

        // Edge case
        if(N == 1){
            return 1;
        }

        // Each coin results in tail postion only when it is flipped odd number of times. 
        // This means that if a coin postion has odd divisors it ends up in tail position.
        // If k is sqrt of N and k * k = N then N has odd divisors else N has even divisors. Refer to counting divisors question to learn more.
        // Loop through all the positions including N.
        for (int i = 1; i <= N; i++) {
            // save the sqrt of i as a double value.
            double sqrt = Math.sqrt(i);
            // Find if sqrt * sqrt = i. To do that substract the floor value of the sqrt from sqrt. If the result is 0 then sqrt * sqrt = i
            if(sqrt - (int)sqrt == 0)
                // Here i has odd number of divisor hence increase value of result.
                result ++;
        }
        // Result will now have all the tail positions.
        return result;
    }
    
    public static void main(String[] args) {
        ReversingCoins2 obj = new ReversingCoins2();

        int N1 = 10;
        System.out.println(obj.solution(N1));

        int N2 = 11;
        System.out.println(obj.solution(N2));

        int N3 = 16;
        System.out.println(obj.solution(N3));
    }

    // Complexity Analysis
    
    // Time Complexity - 0(n) - sqrt may be executed in logn or constant if we use operations on floating point numbers, 
    // In java Math.sqrt uses constant time. We process all elements only once.
    
    // Space Complexity - 0(1) - No data structure used that scales with n
}
