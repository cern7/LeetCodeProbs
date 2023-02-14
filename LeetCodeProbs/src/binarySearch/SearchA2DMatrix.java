package binarySearch;


public class SearchA2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3}
        };
        int target = 3;
        System.out.println(new SearchA2DMatrix().searchMatrix(matrix, target));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int rowStart = 0;
        int rowEnd = m - 1;
        int colEnd = n - 1;
        while (rowStart <= rowEnd) {
            int rowMid = rowStart + (rowEnd - rowStart) / 2;
            if (target == matrix[rowMid][0]) {
                return true;
            } else if (target > matrix[rowMid][colEnd]) {
                rowStart = rowMid + 1;
            } else if (target < matrix[rowMid][0]) {
                rowEnd = rowMid - 1;
            } else {
                int l = 0;
                int r = colEnd;
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    if (target == matrix[rowMid][mid]) {
                        return true;
                    } else if (target < matrix[rowMid][mid]) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
                return false;
            }
        }
        return false;
    }
}
