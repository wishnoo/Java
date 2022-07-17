package ProblemSolving.Miscellaneous.LongestCommonPrefix;

public class LongestCommonPrefix3 {
    
    // Approach 3: Recursion using Divide and Conquer
    public String solution(String[] input) {
        // Edge Case
        // Null and input empty.
        if(input == null || input.length == 0)
            return "";

        return recursivePrefix(input, 0, input.length - 1);
    }

    // Recursive function with input array and left and right index as arguments.
    public String recursivePrefix(String[] input, int left, int right) {
        // Base condition 
        if(left == right)
            return input[left];

        // Dividing into 2 similar to a tree.
        int middle = (left + right) / 2;
        // Retrieve the left most string and then right above and keep repeating.
        String leftPrefix = recursivePrefix(input, left, middle);
        String rightPrefix = recursivePrefix(input, middle + 1, right);
        // find common Prefix of the left and right counterpart and pass it up to the call stack.
        return commonPrefix(leftPrefix, rightPrefix);
    }

    // Find common prefix between two strings.
    public String commonPrefix(String left, String right) {
        // to use for loop its better to loop through the smaller string as that is the max length of prefix and to avoid out of bound exception.
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if(left.charAt(i) != right.charAt(i))
                // If the characters don't match return prefix (can be left or right) upto i.
                return left.substring(0, i);
        }
        //since there were no mismatches return the smallest string or return any string upto min index. 
        return left.substring(0, min);
    }

    public static void main(String[] args) {
        LongestCommonPrefix3 obj = new LongestCommonPrefix3();
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
            // Space Complexity - 0(M * logN) - There is a memory overhead since we store recursive calls in the execution stack. There are logN recursive calls, each store need mm space to store the result.
}
