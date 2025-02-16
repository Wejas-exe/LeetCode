class Solution {
    public int[] constructDistancedSequence(int n) {
        int len = 2 * n - 1;
        int[] result = new int[len];
        boolean[] used = new boolean[n + 1]; // To track used numbers
        backtrack(result, used, 0, n);
        return result;
    }

    private boolean backtrack(int[] result, boolean[] used, int index, int n) {
        int len = result.length;
        
        // Base case: if index reaches end, return true
        if (index == len) return true;
        
        // If the current position is already filled, move to next index
        if (result[index] != 0) return backtrack(result, used, index + 1, n);

        // Try placing the largest possible number
        for (int i = n; i >= 1; i--) {
            if (used[i]) continue; // Skip already used numbers
            
            if (i == 1) { // '1' only needs one position
                result[index] = 1;
                used[i] = true;
                if (backtrack(result, used, index + 1, n)) return true;
                result[index] = 0;
                used[i] = false;
            } else {
                int secondIndex = index + i;
                if (secondIndex < len && result[secondIndex] == 0) { // Check if the second position is available
                    result[index] = i;
                    result[secondIndex] = i;
                    used[i] = true;
                    
                    if (backtrack(result, used, index + 1, n)) return true;
                    
                    result[index] = 0;
                    result[secondIndex] = 0;
                    used[i] = false;
                }
            }
        }
        return false;
    }
}
