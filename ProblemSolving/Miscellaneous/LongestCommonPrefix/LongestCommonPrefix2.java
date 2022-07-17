package ProblemSolving.Miscellaneous.LongestCommonPrefix;

public class LongestCommonPrefix2 {
    
    // Approach 2: Vertical Scanning
    // In horizontal scanning we can encounter a situation where the length of one of the strings were short and we started with a prefix which was relatively long.
    // In vertical scanning we check each letter of the strings before proceeding ahead.

    public String solution(String[] input) {
        
        // Edge Case
        // Null and input empty.
        if(input == null || input.length == 0)
            return "";
        
        for (int i = 0; i < input[0].length(); i++) {
            char c = input[0].charAt(i);

            for (int j = 0; j < input.length; j++) {
                if(i == input[j].length() || c != input[j].charAt(i))
                    return input[0].substring(0, i);
            }
        }
        return input[0];
    }
    
    public static void main(String[] args) {
        LongestCommonPrefix2 obj = new LongestCommonPrefix2();
        String[] input = {"flower","flow","flight"};
        System.out.println(obj.solution(input));
        // obj.solution(input) should return:
        // f1
        
        String[] input2 = {"dog","racecar","car"};
        System.out.println(obj.solution(input2));
        // obj.solution(input2) should return:
        // ""
    }

    // Complexity Analysis
            // Time Complexity - 0(N * K) - 0(S) where S is N * K, N is the number of elements in the array, K is the max length of all the strings.
            // Even though the worst case is still the same as horizontal scanning , in the best case there are at most N * minLen comparisons where minLen is the length of the shortest string in the array.
            // Space Complexity - 0(1) - Constant memory used.
    
}
