package LeetCode;

public class SetMatrixZeroes {
    // My Solution : Mark a boolean matrix first when 0s are encountered, then make the rows & columns as zeroes - 59th percentile
    public void setZeroes(int[][] matrix) {
        boolean[][] matMark= new boolean[matrix.length][matrix[0].length];
        for (int i = 0 ; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (0 == matrix[i][j]) {
                    matMark[i][j] = true;
                }
            }
        }
        for (int i = 0 ; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matMark[i][j]) {
                    setColRow(matrix, i, j);
                }
            }
        }
    }

    public void setColRow(int [][] matrix, int r, int c) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][c] = 0;
        }
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[r][j] = 0;
        }
    }

    // Optimal solution : Mark Boolean row & column arrays first when 0s are encountered, then iterate every element, if either row or column marked, make it zero.

    public void setZeroesV2 (int[][] matrix) {
        // boolean arrays
        boolean[] rowMark = new boolean[matrix.length];
        boolean[] colMark = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rowMark[i] = true;
                    colMark[j] = true;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (rowMark[i] || colMark[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
