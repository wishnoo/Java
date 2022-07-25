package ProblemSolving.Miscellaneous.LongestSubstringDistinctCharacters;

import java.util.HashMap;

public class LongestSubstringDistinctCharacters {
    // This problem follows the Sliding Window pattern, and we can use a similar dynamic sliding window strategy as discussed in Longest Substring with K Distinct Characters. We can use a HashMap to remember the last index of each character we have processed. 
    // Whenever we get a duplicate character, we will shrink our sliding window to ensure that we always have distinct characters in the sliding window.
    public int solution(String input) {
        int windowStart = 0, maxLength = Integer.MIN_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int windowEnd = 0; windowEnd < input.length(); windowEnd++) {
            char rightChar = input.charAt(windowEnd);

            // if the map already contains the 'rightChar', shrink the window from the
            // beginning so that we have only one occurrence of 'rightChar'
            if(map.containsKey(rightChar)){
                // this is tricky; in the current window, we will not have any 'rightChar' after
                // its previous index and if 'windowStart' is already ahead of the last index of
                // 'rightChar', we'll keep 'windowStart'
                // You can calculate maxLength here and outside the forloop to reduce the number of maxLength comparisons.
                // maxLength = Math.max(maxLength, windowEnd - windowStart);
                windowStart = Math.max(windowStart, map.get(rightChar) + 1);
            }
            // insert the 'rightChar' into the map
            map.put(rightChar,windowEnd);

            // remember the maximum length so far
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        // maxLength = Math.max(maxLength, (input.length() - windowStart) + 1);
        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringDistinctCharacters obj = new LongestSubstringDistinctCharacters();
        String input = "aabccbb";
        System.out.println(obj.solution(input));
        // obj.solution(input) should return:
        // 3

        String input2 = "abbbb";
        System.out.println(obj.solution(input2));
        // obj.solution(input2) should return:
        // 2

        String input3 = "abbbb";
        System.out.println(obj.solution(input3));
        // obj.solution(input3) should return:
        // 3
    }

    /* 
    Complexity Analysis
        Time Complexity - Time complexity : O(N + N) -> 0(N), where N is the number of elements.
        Space Complexity - 0(26) -> 0(1) - Constant memory
    */
}
