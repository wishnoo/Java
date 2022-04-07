package Arrays.MultiDimentionalArrays.RotateImage;

import java.util.Arrays;

public class RotateImage {
    public int[][] solution(int[][] A) {
        int n = A.length;
        
        for (int i = 0; i < Math.floor((double) n / 2); i++) {
            for (int j = 0; j < Math.ceil((double) n / 2); j++) {
                int[] temp = new int[4];
                int[] currentIndex = new int[2];
                currentIndex[0] = i;
                currentIndex[1] = j;

                for (int k = 0; k < 4; k++) {
                    temp[k] = A[currentIndex[0]][currentIndex[1]];
                    currentIndex = rotateIndex(currentIndex[0], currentIndex[1], n);
                }

                for (int k = 0; k < 4; k++) {
                    A[currentIndex[0]][currentIndex[1]] = temp[(k + 3) % 4];
                    currentIndex = rotateIndex(currentIndex[0], currentIndex[1], n);
                }
            }
        }

        return A;
    }

    public int[] rotateIndex(int i, int j, int n) {
        int[] index = new int[2];
        index[0] = j;
        index[1] = n - 1 - i;
        return index;
    }

    public static void main(String[] args) {
        RotateImage obj = new RotateImage();
        int[][] A = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.deepToString(obj.solution(A))); 
    }
}
