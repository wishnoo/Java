package ProblemSolving.Map.HashMap.LongestSubstringSameLettersReplace;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringSameLettersReplace {
    public int solution(String input, int k) {
        int windowStart = 0, maxLength = 0, maxRepeatLetterCount = 0;
        // Hashmap to store the frequency of characters within the current window
        Map<Character, Integer> letterFrequencyMap = new HashMap<>();

        // The window will grow till maxRepeatLetterCount + k.
        // The size of the window will only grow if the within the window we find another character than can beat maxRepeatLetterCount.
        // If we find a character within higher count then maxRepeatLetterCount we grow the window and maintain the size while sliding.
        for (int windowEnd = 0; windowEnd < input.length(); windowEnd++) {
            char rightChar = input.charAt(windowEnd);
            letterFrequencyMap.put(rightChar,
                    letterFrequencyMap.getOrDefault(rightChar, 0) + 1);

            maxRepeatLetterCount = 
                    Math.max(maxRepeatLetterCount, letterFrequencyMap.get(rightChar));

            // current window size is from windowStart to windowEnd, overall we have a letter
            // which is repeating 'maxRepeatLetterCount' times, this means we can have a window
            // which has one letter repeating 'maxRepeatLetterCount' times and the remaining
            // letters we should replace. If the remaining letters are more than 'k', it is the
            // time to shrink the window as we are not allowed to replace more than 'k' letters
            if (windowEnd - windowStart + 1 - maxRepeatLetterCount > k) {
                char leftChar = input.charAt(windowStart);
                letterFrequencyMap.put(leftChar, letterFrequencyMap.get(leftChar) - 1);
                windowStart++;
            }

            // Since at every point we are satisfying maxRepeatLetterCount + k window size we can update maxLength at each iteration.
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringSameLettersReplace obj = new LongestSubstringSameLettersReplace();
        System.out.println(obj.solution("aabccbb", 2));
        // obj.solution("aabccbb", 2) should return:
        // 5
        
        System.out.println(obj.solution("abbcb", 1));
        // obj.solution("abbcb", 1) should return:
        // 4

        System.out.println(obj.solution("abccde", 1));
        // obj.solution("abccde", 1) should return:
        // 3

        System.out.println(obj.solution("bbaaaabbbcaa", 2));
        // obj.solution("bbaaaabbbcaa", 2) should return:
        // 6
    }

     // Complexity Analysis
        // Time Complexity - Time complexity : O(N + N) -> 0(N), where N is the number of elements.
        // Space Complexity - 0(26) -> 0(1) - Constant memory
}
