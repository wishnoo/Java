package ProblemSolving.Miscellaneous.GroupAnagrams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.ArrayList;

public class GroupAnagrams {
    
    // This method returns unique elements in the string in alphabetical order.
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

        // ArrayList of ArrayList does not have default value hence we must assign empty ArrayList we need to refer them with index.
        // This list is used to store the string values at the index which corresponds to how many values it holds.
        ArrayList<ArrayList<String>> processList = new ArrayList<>();
        for (int i = 0; i < input.length + 1; i++) {
            processList.add(new ArrayList<String>());
        }

        // Iterate through the map get the value size from the map which corresponds to the index at which ArrayList<String> needs to be inserted.
        for(String s : processMap.keySet()){
            processList.add(processMap.get(s).size(),processMap.get(s));
        }

        // outputList will hold the lists in decreasing order of size
        ArrayList<ArrayList<String>> outputList = new ArrayList<>();

        // List iterator helps to iterate from the back. Do not forget to add the size as parameter while creating ListIterator so that it starts from behind.
        ListIterator<ArrayList<String>> iterator = processList.listIterator(processList.size());
        
        // Iterate from behind and add elements only if it has any value.
        while(iterator.hasPrevious()){
            ArrayList<String> tempList = iterator.previous();
            if(!tempList.isEmpty()) outputList.add(tempList);
        }
        // return the ArrayList of ArrayList
        return outputList;
    }

    public static void main(String[] args) {
        GroupAnagrams obj = new GroupAnagrams();
        String[] input = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(obj.solution(input));
        // obj.solution(input) should return:
        // [[eat, tea, ate], [tan, nat], [bat]]

        String[] input2 = {""};
        System.out.println(obj.solution(input2));
        // obj.solution(input) should return:
        // [[]]
    }

     // Complexity Analysis
        // Time Complexity - 0(N + A + B) - Where N is the length of input, A is the length of each string in input, B is the length of HashMap. Overall it is equal to 0(N)
        // Space Complexity - 0(1) - No data structure used.
}
}
