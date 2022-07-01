package ProblemSolving.Miscellaneous.TopKFrequentElements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;

public class TopKFrequentElements2 {
    // Implement a 0(N) solution with Array of Arraylist
    public int[] topKFrequent(int[] nums, int k){
        HashMap<Integer, Integer> processMap = new HashMap<>();
        // We can use ArrayList of ArrayList or Array of ArrayList
        // We cannot use array of ArrayList without warning of unchecked conversion during declaration.
        // Here we are using ArrayList of ArrayList
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>(k);
        // Output to be returned as an array
        int[] output = new int[k];

        // Fill hashmap with key and its occurrences
        for (int i = 0; i < nums.length; i++) {
            processMap.put(nums[i], processMap.getOrDefault(nums[i], 0) + 1);
        }

        for(Integer e: processMap.keySet()){
            list.get(processMap.get(e)).add(e);
        }

        // Iterate from behind of the list of list as most frequent keys are at back.
        // Using for loop to iterate from behind
        int y = 0;
        // for (int i = list.size() - 1; i >= 0; i--) {
        //     ArrayList<Integer> current = list.get(i);
        //     if (current.isEmpty()) continue;
        //     for (int j = 0; j < current.size(); j++) {
        //         output[y++] = current.get(j);
        //     }
        // }

        // Can use listIterator to iterate from back
        ListIterator<ArrayList<Integer>> iterator = list.listIterator(list.size());
        while(iterator.hasPrevious()){
            ArrayList<Integer> current = iterator.previous();
            if(current.isEmpty()) continue;
            Iterator<Integer> iterator_sub = current.iterator();
            while(iterator_sub.hasNext()){
                output[y++] = iterator_sub.next(); 
            }
        }

        return output;
    }
    
    public static void main(String[] args) {
        TopKFrequentElements obj = new TopKFrequentElements();
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(obj.topKFrequent(nums, k)));
    }
}
