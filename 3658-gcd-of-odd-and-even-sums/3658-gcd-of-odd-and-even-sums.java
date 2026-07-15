class Solution {
    public int gcdOfOddEvenSums(int n) {
        int a = n*n;
        int b = (n+1)*(n);
        return gcd(b,a);
    }
    public int gcd(int x, int y){
        return y == 0 ? x : gcd(y, x % y);
    }
}