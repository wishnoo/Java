package ProblemSolving.Miscellaneous.GroupAnagrams;

import java.util.Arrays;
import java.util.HashMap;
// import java.util.ListIterator;
import java.util.ArrayList;

// This solution corresponds to "Group words with same set of characters"
public class GroupAnagrams2 {
    
    // This method returns unique elements in the string in alphabetical order.
    // While using this method we remove the duplicates and therefore we are comparing if the strings contain the same characters and not the exact number of characters.
    public String uniqueElements (String s){
        boolean[] visited = new boolean[26];
        Arrays.fill(visited, false);

        for (int i = 0; i < s.length(); i++) {
            // We are assuming all characters are lowercase.
            // Subtracting with a causes the index to be within 0 to 25
            visited[s.charAt(i) - 'a'] = true;
        }

        String uniqueString = "";

        for (int j = 0; j < visited.length; j++) {
            // char type cast is needed to convert number to character
            if(visited[j]) uniqueString += (char)(j + 'a');
        }

        return uniqueString;
    }


    public ArrayList<ArrayList<String>> solution (String[] input){

        // HashMap to store the unique string as key and the string as values. We are storing the strings and not indexes as value because the output we need is ArrayList of ArrayList<String>
        HashMap<String, ArrayList<String>> processMap = new HashMap<>();

        // method to iterate the input and store the input string as value
        for (int j = 0; j < input.length; j++) {
            // Retrieve the unique string with help of the method uniqueElements
            String unique = uniqueElements(input[j]);

            // If the map does have the key already then add to the list.
            if(processMap.containsKey(unique)){
                processMap.get(unique).add(input[j]);
            }
            // Else create the list and add to the map.
            else{
                ArrayList<String> list = new ArrayList<>();
                list.add(input[j]);
                processMap.put(unique, list);
            }
        }

        System.out.println("processMap: " + processMap);

        // outputList will hold the lists in decreasing order of size
        ArrayList<ArrayList<String>> outputList = new ArrayList<>();

        for(String s : processMap.keySet()){
            outputList.add(processMap.get(s));
        }
        
        // return the ArrayList of ArrayList
        return outputList;
    }

    public static void main(String[] args) {
        GroupAnagrams2 obj = new GroupAnagrams2();
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
        // Time Complexity - 0(N * K + N * A) - Where N is the length of input, K is the length of each string in input, A is the length 26.
        // Space Complexity - 0(N * K + N * A) - HashTable and boolean array of 26 used.
}

