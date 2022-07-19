package ProblemSolving.Miscellaneous.LongestCommonPrefix;

public class LongestCommonPrefix4 {

    // Approach 4 : Use binary search 
    public String solution(String[] input) {
        // Find the length of the smallest string in the input.
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < input.length; i++) {
            minLength = (int)Math.min(input[i].length(), minLength);
        }

        int left = 1;
        int right = minLength;

        // The equal operator is important as it would catch the no prefix string inputs. 
        // For example the return statement would have 0, (!+0) as arguments to the substring which will result in empty string.
        while(left <= right){
            // As binary search we are finding a mid to reduce the number of operations.
            int mid = (left + right) / 2;
            if(prefixCheck(input, mid)){
                // if the length of prefix is present in all strings then we need to select a length greater than mid in this case in between mid and right.
                // There for we need to push left after mid so that in next iteration mid is in between the new left and right.
                left = mid + 1;
            }
            else{
                // If the length of prefix is not present in all strings then we select a length below mid.
                right = mid - 1;
            }
        }
        // when while loop exits we would have pushed left greater than right or right below left
        // If left is pushed above right which means there was a match for e.g., left = 7 and right = 6 then we need 6 as the answer (because 6 had matched in the previous loop) 
        // then (left + right) / 2 with floor division would provide us the answer.
        // Similarly when right is pushed below left at the latest iteration for e.g. if there is no prefix left = 1, right = 0 then (left + right) / 2 would give us 0.
        return input[0].substring(0, (left + right) / 2);
    }

    // method to find if the prefix till the length matches with all the strings.
    public boolean prefixCheck(String[] input, int length) {
        String prefix = input[0].substring(0, length);
        for (int i = 1; i < input.length; i++) {
            if(!input[i].startsWith(prefix)){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        LongestCommonPrefix4 obj = new LongestCommonPrefix4();
        String[] input = {"flower","flow","flight"};
        System.out.println(obj.solution(input));
        // obj.solution(input) should return:
        // f1
        
        String[] input2 = {"dog","racecar","car"};
        System.out.println(obj.solution(input2));
        // obj.solution(input2) should return:
        // ""
    }
    
    // Complexity Analysis
            // Time Complexity - Time complexity : O(S⋅logM), where S is the sum of all characters in all strings, m is the no of levels binary search divides.
            // The algorithm makes logM iterations, for each of them there are S=M⋅N comparisons, which gives in total O(S⋅logM) time complexity.
            // Space Complexity - 0(1) - Constant memory
}
