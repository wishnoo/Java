package ProblemSolving.Miscellaneous.CountDiv;

public class CountDiv {
    
    public int solution(int A, int B, int K) {
        
        // the number which divides by K and just less than B (floor division) should be greater than A or else there are no numbers within A and B which are divisible by K.
        if(Math.floor((double)B/K) * K < A) return 0;

        // if A is 0. Dividing 0 with a number results in 0 and therefore we do not explicitly require to check if its zero.
        int lowerQuotient = (int)Math.ceil((double)A/K);
        int upperQuotient = (int)Math.floor((double)B/K);

        return (upperQuotient - lowerQuotient) + 1;
    }

    public static void main(String[] args) {
        CountDiv obj = new CountDiv();
        System.out.println(obj.solution(6, 11, 2));
        // obj.solution(6,11,2) should return:
        // 3

        System.out.println(obj.solution(10, 11, 3));
        // obj.solution(10,11,3) should return:
        // 0
    }

    // Complexity Analysis
        // Time Complexity - O(1). No iterations required.
        // Space Complexity - O(1). Only two variables are used.
}
