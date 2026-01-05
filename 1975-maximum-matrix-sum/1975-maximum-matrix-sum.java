class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long sum = 0; 
        int negCount = 0; 
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int absVal = Math.abs(matrix[i][j]);
                sum += absVal; 
                if (matrix[i][j] < 0) {
                    negCount++; 
                }
                min = Math.min(min, absVal); 
            }
        }
        if (negCount % 2 == 0) {
            return sum;
        }
        return sum - 2 * min;
    }
}
