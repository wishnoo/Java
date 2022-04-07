package List.ArrayList.Peaks;

import java.util.ArrayList;

public class Peaks {
    
    public int solution(int[] A) {
        
        // Array list to store all the peaks of input array.
        ArrayList<Integer> peaksIndexList = new ArrayList<>();

        // Length of array
        int N = A.length;

        // For loop to find the peak elements.
        for (int i = 1; i < A.length - 1; i++) {
            // find if the current element is greater then previous element and the next element. If yes, add to the list.
            if(A[i - 1] < A[i] && A[i] > A[i + 1])
                peaksIndexList.add(i);
        }

        // The maximum number of blocks is N if the size of each block is 1. Start from the largest block so as to return when we meet our condiiton.
        // Can also iterate based on size of each block from 1 to N. Size must start from 1 as when the size is 1 the number of blocks is the maximum. 
        for (int numBlocks = N; numBlocks > 0; numBlocks--) {
            // Check if the numBlocks can divide the length equally which means there are equal number of elements in each block. 
            // If not, skip this iteration.
            if(N % numBlocks != 0)
                continue;
            
            // since we have number of blocks now find the no of elements in each block.
            int blockSize = N / numBlocks;
            
            // This variable allows to check if the peak belongs to the respective block in order.
            int ithBlock = 0;

            // When we divide peak value with the block size and if the value is less than 1 then it means the peak index resides within the first block.
            // For eg. If the block size is 3 and the index is 1 - then 1 / 3 will be less than 1 which signifies index 1 resides in the first block. 
            // We make use of floor division of int to get the value.
            // Similary if the index resides in the second block, peak / blocksize with floor division will be between 1 and 2
            // Using methodology we can increase ithBlock when peak / blockSize is equal to ithBlock. This avoids the increase of ithBlock when 2 peaks exist in the same block.
            // When 2 peaks exist in the same block , peak / blockSize will not be equal to 0 and thus we won't increase the counter of ithBlock.
            // When peak / blockSize is greater the ithBlock, it means that peak does not exist for the current block and exists on the next block, 
            // For the solution we need atleast one peak in one block and therefore we can break the loop. 
            for (Integer peak : peaksIndexList) {
                if(peak / blockSize > ithBlock)
                    break;
                if(peak / blockSize == ithBlock)
                    ithBlock++;
            }

            // Check if ithBlock is equal to numBlock which means we have a peak for each block and we can return the numBlocks. 
            // Since we are iterating from N which is the max to 1 the first value that we encounter to match the condition will be the max blocks that we could return.
            if(ithBlock == numBlocks)
                return numBlocks;
        }

        // If we haven't returned yet then there is no peak for any number of blocks and hence return 0.
        return 0;
    }
    public static void main(String[] args) {
        Peaks obj = new Peaks();
        int[] A1 = {0,1,0,2,1,4,6,4};
        System.out.println(obj.solution(A1));
        // obj.solution(A1) must return:
        // 2

        int[] A2 = {1,2,3,4,3,4,1,2,3,4,6,2};
        System.out.println(obj.solution(A2));
        // obj.solution(A2) must return:
        // 3

        int[] A3 = {1,1000000000};
        System.out.println(obj.solution(A3));
        // obj.solution(A3) must return:
        // 0
    }
}
