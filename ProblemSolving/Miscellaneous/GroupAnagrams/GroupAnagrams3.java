package ProblemSolving.Miscellaneous.GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams3 {
    // Here we would sort the string and use as a key for HashMap.
    public List<List<String>> solution(String[] input) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (int i = 0; i < input.length; i++) {
            char[] character = input[i].toCharArray();
            Arrays.sort(character);

            // Convert the character array to string which we will use as key for HashMap
            String key = new String(character);

            // If map does not contain this key add the key with a new arraylist
            map.putIfAbsent(key, new ArrayList<>());
            // If map contains the key then add to the arraylist associated with the key
            map.get(key).add(input[i]);
        }

        List<List<String>> outputList = new ArrayList<>(map.values());

        return outputList;
    }

    public static void main(String[] args) {
        GroupAnagrams3 obj = new GroupAnagrams3();
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
        // Time Complexity - 0(N K log K) - Where N is the length of input, K is the length of each string in input.
        // Space Complexity - 0(N * K) - This is the data stored for key value pair. Where N is the length of input, K is the length of each string in input.
}
