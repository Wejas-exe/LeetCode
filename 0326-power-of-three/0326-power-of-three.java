class Solution {
    public boolean isPowerOfThree(int n) {
        if(n <= 0) return false;
        double ans = Math.log(n)/Math.log(3);
        double epsilon = 1e-10;
        return Math.abs(ans - Math.round(ans)) < epsilon;
    }
}