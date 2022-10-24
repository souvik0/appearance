package com.walmart;

// Two dimensional array represents graph using adjacency matrix.

public class CountIsland {

    public static final int ROW = 4, COL = 5;

    public static void main(String[] args) {
        int M[][] = new int[][] {{1, 1, 0, 0, 0},
                                 {1, 1, 0, 0, 0},
                                 {0, 0, 1, 0, 0},
                                 {0, 0, 0, 1, 1}};
        System.out.println("Number of islands is: " + CountIsland.countIslands(M));
    }

    public static int countIslands(int[][] M) {
        boolean[][] visited = new boolean[ROW][COL];
        int countOfIslands = 0;
        for (int i = 0; i < ROW; ++i) {
            for (int j = 0; j < COL; ++j) {
                if (M[i][j] == 1 && !visited[i][j]) { // If a cell with value 1 is not
                    // visited yet, then new island found, Visit all
                    // cells in this island and increment island count
                    countOfIslands++;
                    DFS(M, i, j, visited);
                }
            }
        }

        return countOfIslands;
    }

    // A utility function to do DFS for a 2D matrix.
    // It only considers the 8 neighbors as adjacent vertices
    public static void DFS(int M[][], int startRow, int startCol, boolean visited[][]) {
        // Mark the source cell as visited
        visited[startRow][startCol] = true;
        // These arrays are used to get row and column numbers
        // of 8 neighbors of a given cell
        int[] Path_Row = new int[] {-1, 0, 1, 0};
        int[] Path_Col = new int[] {0, -1, 0, 1};

        // Recur for all connected neighbors
        for (int k = 0; k < Path_Row.length; k++) {
             int rowNext = startRow + Path_Row[k];
             int colNext = startCol + Path_Col[k];
             if (isSafe(M, rowNext, colNext, visited)) {
                DFS(M, rowNext, colNext, visited);
            }
        }
    }

    // A function to check if a given cell (row, col) can be included in DFS
    public static boolean isSafe(int M[][], int row, int col, boolean visited[][]) {
        // row number is in range, column number is in range
        // and value is 1 and not yet visited
        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) &&
               (M[row][col] == 1 && !visited[row][col]);
    }
}
