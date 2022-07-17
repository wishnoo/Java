package ProblemSolving.Miscellaneous.LongestCommonPrefix;

public class LongestCommonPrefix {
    
    // Approach 1: Horizontal Scanning
    // We assume the first string as the prefix and check with the other strings reducing when it doesn't match.

    public String solution(String[] input) {

        // Edge Case
        // Null and input empty.
        if(input == null || input.length == 0)
            return "";

        // Assume prefix 
        String prefix = input[0];

        // Traverse through all the strings expect the first.
        for (int i = 1; i < input.length; i++) {
            
            // Find the prefix with each string 
            // we could use indexOf or startsWith. indexOf returns the index where it matches and we want that to be 0.
            while(input[i].indexOf(prefix) != 0){
                // If not 0 then reduce the prefix by 1 from behind using subString. 2nd argument is exclusive.
                prefix = prefix.substring(0, prefix.length() - 1);

                // If prefix ultimately becomes empty return empty string.
                if(prefix.isEmpty())
                    return "";
            }
        }

        // If prefix is present then return.
        return prefix;
    }

    public static void main(String[] args) {
        LongestCommonPrefix obj = new LongestCommonPrefix();
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
        // Space Complexity - 0(1) - Constant memory used.
}
