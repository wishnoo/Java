package ProblemSolving.Miscellaneous.Primality;

public class Primality {

    public boolean solution(int N) {
        
        // Edge Case:
        if(N < 2)
            return false;
        
        // Prime numbers start from 2 or above.
        int i = 2;
        // Using the property of symmetric divisor find if one part of symmetric divisors exist below or equal to sqrt(N) 
        while(i * i <= N){
            if(N % i == 0)
                return false;
            i++;
        }
        return true;
    }
    public static void main(String[] args) {
        Primality obj = new Primality();

        int N1 = 9;
        System.out.println(obj.solution(N1));
        // obj.solution(N1) should return:
        // false

        int N2 = 11;
        System.out.println(obj.solution(N2));
        // obj.solution(N2) should return:
        // true

        int N3 = 1;
        System.out.println(obj.solution(N3));
        // obj.solution(N3) should return:
        // false
    }

    // Complexity Analysis
        // Time Complexity - 0(sqrt(N)) - Process elements upto sqrt(N)
        // Space Complexity - 0(1) - No data type other than factors used here that scales with N.
}
