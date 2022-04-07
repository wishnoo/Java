package ProblemSolving.Arrays.MultiDimentionalArrays.Minesweeper;

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
            int row = bomb[0];
            int col = bomb[1];

            field[row][col] = -1;

            // Traverse through the neighbouring elements and increase the value in those positions. 
            // We could use two for loops to traverse a matrix rows - 1 -> rows + 1 && columns - 1 -> columns + 2
            // These for loops will traverse the current bomb element too.
            
            for (int i = row - 1; i <= row + 1; i++) {
                for (int j = col - 1; j <= col + 1; j++) {
                    // if loop to check whether row and col is within bounds and the value is not equal to -1 which is the bomb.
                    // In the if loop always place out of bounds conditions first followed by comparision condition. 
                    // This is to prevent the outofboundexception if it compares the value first.
                    if (i >= 0 && i <= numRows - 1 && j >= 0 && j <= numCols - 1 && field[i][j] != -1) {
                        field[i][j]++;
                    }
                }
            }
        }

        

        return field;
    }

    public static void main(String[] args) {
        Minesweeper obj = new Minesweeper();
        
        int[][] bombs1 = {{0, 2}, {2, 0}};
        // Arrays cannot be printed directed so you need to use Arrays.toString method for nested arrays we need to use deepToString.
        System.out.println(Arrays.deepToString(obj.mineSweeper(bombs1, 3, 3)));
        // mineSweeper(bombs1, 3, 3) should return:
        // [[0, 1, -1],
        //  [1, 2, 1],
        //  [-1, 1, 0]]

        int[][] bombs2 = {{0, 0}, {0, 1}, {1, 2}};
        System.out.println(Arrays.deepToString(obj.mineSweeper(bombs2, 3, 4)));
        // mineSweeper(bombs2, 3, 4) should return:
        // [[-1, -1, 2, 1],
        //  [2, 3, -1, 1],
        //  [0, 1, 1, 1]]

        int[][] bombs3 = {{1, 1}, {1, 2}, {2, 2}, {4, 3}};
        System.out.println(Arrays.deepToString(obj.mineSweeper(bombs3, 5, 5)));
        // mineSweeper(bombs3, 5, 5) should return:
        // [[1, 2, 2, 1, 0],
        //  [1, -1, -1, 2, 0],
        //  [1, 3, -1, 2, 0],
        //  [0, 1, 2, 2, 1],
        //  [0, 0, 1, -1, 1]]


    }
}
