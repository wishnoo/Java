package ProblemSolving.Map.HashMap.LongestSubstringKDistinctCharacters;

import java.util.HashMap;

public class LongestSubstringKDistinctCharacters {
    // Approach 1: Sliding window
    public int solution(String input, int k) {
        int windowStart  = 0, maxLength = Integer.MIN_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int windowEnd = 0; windowEnd < input.length(); windowEnd++) {
            // we will insert characters from the beginning of the string until we have K distinct characters in the HashMap.
            map.put(input.charAt(windowEnd), map.getOrDefault(input.charAt(windowEnd), 0) + 1);

            while (map.size() > k) {
                // In each step, we will try to shrink the window from the beginning if the count of distinct characters in the HashMap is larger than K. 
                // We will shrink the window until we have no more than K distinct characters in the HashMap. 
                // This is needed as we intend to find the longest window.
                map.put(input.charAt(windowStart),map.get(input.charAt(windowStart)) - 1 );
                // While shrinking, we’ll decrement the character’s frequency going out of the window and remove it from the HashMap if its frequency becomes zero.
                if(map.get(input.charAt(windowStart)) == 0)
                    map.remove(input.charAt(windowStart));
                windowStart++;
            }
            // The maxLength being updated here takes the case of less than k distinct elements and k distinct elements.
            maxLength = Math.max(maxLength, (windowEnd - windowStart) + 1);
        }

        // If maxLength is not changed then no elements in the string.
        if(maxLength == Integer.MIN_VALUE)
            return 0;
        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringKDistinctCharacters obj = new LongestSubstringKDistinctCharacters();
        String input = "araaci";
        int k = 2;
        System.out.println(obj.solution(input, k));
        // obj.solution(input, k) should return: 
        // 4

        String input2 = "aaaaa";
        int k2 = 2;
        System.out.println(obj.solution(input2, k2));
        // obj.solution(input2, k2) should return: 
        // 5

        String input3 = "";
        int k3 = 2;
        System.out.println(obj.solution(input3, k3));
        // obj.solution(input3, k3) should return: 
        // 0
    }
 /*
    Complexity Analysis
        Time Complexity:    The above algorithm’s time complexity will be O(N)O(N), where N is the number of characters in the input string. 
                            The outer for loop runs for all characters, and the inner while loop processes each character only once; 
                            Therefore, the time complexity of the algorithm will be O(N+N), which is asymptotically equivalent to O(N).
        Space Complexity:   The algorithm’s space complexity is O(K), as we will be storing a maximum of K+1 characters in the HashMap.  
 */
    

}
