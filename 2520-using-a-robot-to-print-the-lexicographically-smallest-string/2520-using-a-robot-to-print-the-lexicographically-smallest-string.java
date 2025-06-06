class Solution {
    public String robotWithString(String s) {
        int n = s.length();
        int[] minRight = new int[n];
        minRight[n-1] = s.charAt(n-1);

        for(int i = n-2 ;i>=0 ;i--){
            minRight[i] = Math.min(minRight[i+1] , s.charAt(i));
        }

        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i =0;i<n;i++){
            st.push(s.charAt(i));

            while(!st.isEmpty() && (i == n-1 || st.peek() <= minRight[i+1])){
                sb.append(st.pop());
            }
        }
        return sb.toString();
    }
}