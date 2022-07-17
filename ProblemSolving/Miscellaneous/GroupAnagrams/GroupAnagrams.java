package ProblemSolving.Miscellaneous.GroupAnagrams;

import java.util.HashMap;
// import java.util.ListIterator;
import java.util.ArrayList;

public class GroupAnagrams {
    
    // This method returns elements in the string in alphabetical order.
    public String orderedElements (String s){
        ArrayList<ArrayList<String>> orderList = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            orderList.add(new ArrayList<>());
        }

        for (int i = 0; i < s.length(); i++) {
            // We are assuming all characters are lowercase.
            // Subtracting with a causes the index to be within 0 to 25
            orderList.get(s.charAt(i) - 'a').add((String.valueOf(s.charAt(i))));
        }

        String orderedString = "";

        for (int j = 0; j < orderList.size(); j++) {
            // char type cast is needed to convert number to character
            String tempString = String.join("",orderList.get(j));
            orderedString += tempString;
        }
        System.out.println("orderedString: " + orderedString);

        return orderedString;
    }


    public ArrayList<ArrayList<String>> solution (String[] input){

        // HashMap to store the unique string as key and the string as values. We are storing the strings and not indexes as value because the output we need is ArrayList of ArrayList<String>
        HashMap<String, ArrayList<String>> processMap = new HashMap<>();

        // method to iterate the input and store the input string as value
        for (int j = 0; j < input.length; j++) {
            // Retrieve the unique string with help of the method uniqueElements
            String unique = orderedElements(input[j]);

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

        // outputList will hold the lists to be outputted
        // ArrayList constructor can accept other collections and therefore we can pass the set view into it.
        ArrayList<ArrayList<String>> outputList = new ArrayList<>(processMap.values());

        // for(String s : processMap.keySet()){
        //     outputList.add(processMap.get(s));
        // }
        
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
        // obj.solution(input2) should return:
        // [[]]

        String[] input3 = {"ddddddddddg","dgggggggggg"};
        System.out.println(obj.solution(input3));
        // obj.solution(input3) should return:
        // [["dgggggggggg","ddddddddddg"]]
    }

     // Complexity Analysis
        // Time Complexity - 0(N * A + N * K + N * A) = 0(N * K) - Where N is the length of input, K is the length of each string in input, A is the length 26. Overall it is equal to 0(N * K)
        // Space Complexity - 0(N * K + N * A) = 0(N * K) - This is the data stored for key value pair and the count array.Where N is the length of input, K is the length of each string in input, A is the length 26.
}

