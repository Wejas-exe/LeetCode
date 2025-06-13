class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int i = 0 ;
        int j = rows*cols - 1 ;
        while(i<=j){
            int mid = i+((j-i)/2);
            int row = mid/cols;
            int col = mid%cols;
            if(matrix[row][col] == target){
                return true ;
            }else if(matrix[row][col] > target){
                j = mid-1 ;
            }else{
                i = mid+1;
            }
        }
        return false ;
    }
}