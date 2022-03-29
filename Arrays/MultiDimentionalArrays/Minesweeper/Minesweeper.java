package Arrays.MultiDimentionalArrays.Minesweeper;

import java.util.Arrays;

public class Minesweeper {
    
    public int[][] mineSweeper(int[][] bombs, int numRows, int numCols) {
        int[][] field = new int[numRows][numCols];

        // Change all values in the array to zero.
        // By default arrays value in java is zero. Following is a way to make use of Arrays class method fill to acheive this.
        // for (int[] row: field)
        //     Arrays.fill(row, 0);

        // Loop through bombs and place -1 in those positions.
        for (int[] bomb : bombs){
            // bomb[0] and bomb[1] contains the row and column of the bomb position
            field[bomb[0]]
        }

        

        return field;
    }

    public static void main(String[] args) {
        Minesweeper obj = new Minesweeper();
        
        int[][] bombs1 = {{0, 2}, {2, 0}};
        System.out.println(Arrays.deepToString(obj.mineSweeper(bombs1, 3, 3)));
        // mineSweeper(bombs1, 3, 3) should return:
        // [[0, 1, -1],
        //  [1, 2, 1],
        //  [-1, 1, 0]]

        int[][] bombs2 = {{0, 0}, {0, 1}, {1, 2}};
        // mineSweeper(bombs2, 3, 4) should return:
        // [[-1, -1, 2, 1],
        //  [2, 3, -1, 1],
        //  [0, 1, 1, 1]]

        int[][] bombs3 = {{1, 1}, {1, 2}, {2, 2}, {4, 3}};
        // mineSweeper(bombs3, 5, 5) should return:
        // [[1, 2, 2, 1, 0],
        //  [1, -1, -1, 2, 0],
        //  [1, 3, -1, 2, 0],
        //  [0, 1, 2, 2, 1],
        //  [0, 0, 1, -1, 1]]


    }
}
