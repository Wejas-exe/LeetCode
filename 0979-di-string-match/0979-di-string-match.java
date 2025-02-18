class Solution {
    public int[] diStringMatch(String s) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for(int i =0;i<s.length()+1;i++){
            st.push(i);
            if(i==s.length() || s.charAt(i)=='I'){
                while(!st.isEmpty()){
                    list.add(st.pop());
                }
            }
        }
        int arr[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }
}