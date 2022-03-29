package Arrays.MultiDimentionalArrays.MinesweeperExpand;

import java.util.*;

public class MinesweeperExpand {

    public int[][] click(int[][] field, int numRows, int numCols, int givenI, int givenJ) {
        // Since we need to traverse the array / graph. 
        // bread first search is more apt in this case as the space complexity is significantly smaller.
        // Queue will store all the positions that need to be processed next.
        ArrayDeque<ArrayList<Integer>> queue = new ArrayDeque<>();
        ArrayList<Integer> tempList = new ArrayList<>(2);
        tempList.add(0, givenI); 
        tempList.add(1, givenJ); 

        //Edge case
        // if the given position does not contain 0 return the same matrix.
        if(field[givenI][givenJ] != 0)
            return field;

        // Start by adding the given position into the queue.
        queue.offer(tempList);

        // Until the queue is empty continue the while loop.
        while (queue.isEmpty() != true){
            ArrayList<Integer> currList = new ArrayList<>();
            currList = queue.pop();
            int row = currList.get(0);
            int col = currList.get(1);
            
            // if the given position is zero then change it -2 else skip the element as we already processed it.
            if(field[row][col] == 0)
                field[row][col] = -2;
            else
                continue;

            // traverse the matrix of surrounding 8 elements including the current element.
            for (int i = row - 1; i <= row + 1; i++) {
                for (int j = col - 1; j <= col + 1; j++) {
                    // if the position is out of bound or if the value at the position is not 0 then do not add to queue thus skip.
                    if (i >= 0 && i < numRows && j >= 0 && j < numCols && field[i][j] == 0) {
                        // Remember to use keyword to create a new arraylist each time else the arraylist will point to the same object. 
                        // Also the arraylist will keep on adding and shifting the current elements to right thus expanding even thought the size was intially set to 2.
                        tempList = new ArrayList<>(2);
                        tempList.add(0, i);
                        tempList.add(1, j);
                        // since the value is equal to zero add to queue.
                        queue.offer(tempList);
                    }
                }
            }
        }
        return field;
    }
    public static void main(String[] args) {
        MinesweeperExpand obj = new MinesweeperExpand();

        int[][] field1 = {{0, 0, 0, 0, 0},
                          {0, 1, 1, 1, 0},
                          {0, 1, -1, 1, 0}};
        System.out.println(Arrays.deepToString(obj.click(field1, 3, 5, 2, 2)));
        // click(field1, 3, 5, 2, 2) should return:
        // [[0, 0, 0, 0, 0],
        //  [0, 1, 1, 1, 0],
        //  [0, 1, -1, 1, 0]]

        System.out.println(Arrays.deepToString(obj.click(field1, 3, 5, 1, 4)));
        // click(field1, 3, 5, 1, 4) should return:
        // [[-2, -2, -2, -2, -2],
        //  [-2, 1, 1, 1, -2],
        //  [-2, 1, -1, 1, -2]]


        int[][] field2 = {{-1, 1, 0, 0},
                          {1, 1, 0, 0},
                          {0, 0, 1, 1},
                          {0, 0, 1, -1}};

        System.out.println(Arrays.deepToString(obj.click(field2, 4, 4, 0, 1)));
        // click(field2, 4, 4, 0, 1) should return:
        // [[-1, 1, 0, 0],
        //  [1, 1, 0, 0],
        //  [0, 0, 1, 1],
        //  [0, 0, 1, -1]]

        System.out.println(Arrays.deepToString(obj.click(field2, 4, 4, 1, 3)));
        // click(field2, 4, 4, 1, 3) should return:
        // [[-1, 1, -2, -2],
        //  [1, 1, -2, -2],
        //  [-2, -2, 1, 1],
        //  [-2, -2, 1, -1]]


        // Complexity Analysis
        // Time - 0(m * n) where m * n represents all the elements, m is the rows and n is the no of columns.
        // Space - 0(m + n) - Since we are using breadth first search the max space it would hold is the elements in the outer row and column.
        // if the solution use DFS then the max space used would have 0(m * n) as the elements would have been processed like a snake all the way to the end.
    }
}
