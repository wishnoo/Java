package ProblemSolving.Miscellaneous.GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams4 {
    // Instead of sorting we would use a string which represents the count of characters as the key of the HashMap.
    public List<List<String>> solution(String[] input) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (int i = 0; i < input.length; i++) {
            // array where index represents the character position and value represents the count.
            int[] count = new int[26];

            // Iterate through each element of the string
            for (int j = 0; j < input[i].length(); j++) {
                // Increase the count of character position once we make it within 26. by subtracting with 'a'.
                count[input[i].charAt(j) - 'a']++;
            }

            StringBuilder str = new StringBuilder();
            for (int k = 0; k < count.length; k++) {
                // We used a delimiter to make the key unique. For example if a and b have count 11 and 1 respectively while merging into a string we could assume a has 1 and b has 11.
                // To avoid we make sure there is a delimiter to differentiate between counts. 
                str.append(count[k]).append('#');
            }

            // Convert the StringBuilder object to string which we will use as key for HashMap
            String key = str.toString();

            // If map does not contain this key add the key with a new arraylist
            map.putIfAbsent(key, new ArrayList<>());
            // If map contains the key then add to the arraylist associated with the key
            map.get(key).add(input[i]);
        }

        List<List<String>> outputList = new ArrayList<>(map.values());

        return outputList;
    }

    public static void main(String[] args) {
        GroupAnagrams4 obj = new GroupAnagrams4();
        String[] input = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(obj.solution(input));
        // obj.solution(input) should return:
        // [[eat, tea, ate], [tan, nat], [bat]]

        String[] input2 = {""};
        System.out.println(obj.solution(input2));
        // obj.solution(input2) should return:
        // [[]]

        String[] input3 = {"ddddddddddg","dgggggggggg"};
        System.out.println(obj.solution(input3));
        // obj.solution(input3) should return:
        // [["dgggggggggg","ddddddddddg"]]
    }

    // Complexity Analysis
        // Time Complexity - 0(N * K + N * A) = 0(N * K) - Where N is the length of input, K is the length of each string in input, A is the length 26. Overall it is equal to 0(N * K)
        // Space Complexity - 0(N * K + N * A) = 0(N * K) - This is the data stored for key value pair and the count array.Where N is the length of input, K is the length of each string in input, A is the length 26.
}
