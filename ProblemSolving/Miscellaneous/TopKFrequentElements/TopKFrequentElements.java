package ProblemSolving.Miscellaneous.TopKFrequentElements;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Queue;

public class TopKFrequentElements {
    // Using HashMap and Priority Queue
    public int[] topKFrequent(int[] nums, int k){
        HashMap<Integer, Integer> processMap = new HashMap<>();
        // A priority queue which by default is a min heap
        // Provide a comparator to the priority queue
        Queue<Integer> queue = new PriorityQueue<Integer>(nums.length, new Comparator<Integer>(){
            public int compare (Integer n1, Integer n2){
                return (processMap.get(n1) - processMap.get(n2));
            }
        });

        // Output to be returned as an array
        int[] output = new int[k];

        // Fill hashmap with key and its occurrences
        for (int i = 0; i < nums.length; i++) {
            processMap.put(nums[i], processMap.getOrDefault(nums[i], 0) + 1);
        }

        // Add elements into the priority queue and remove elements if it is greater then k
        for(Integer i: processMap.keySet()){
            queue.offer(i);
            if(queue.size() > k) queue.poll();
        }

        // Transfer the elements from queue to array.
        // Since the queue holds the min value at the top we can fill the array from the back to have the most frequent key in the front of the array.
        for (int j = k - 1; j >= 0; j--) {
            output[j] = queue.poll();
        }

        return output;

    }

    public static void main(String[] args) {
        TopKFrequentElements obj = new TopKFrequentElements();
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(obj.topKFrequent(nums, k)));
    }

    // Complexity Analysis
        // Time Complexity - 0(Nlog(k)) - Process all elements which is N and sort by logk inside priority queue.
        // Space Complexity - 0(N) - We store all elements inside hashmap if there are no duplicates.
}
