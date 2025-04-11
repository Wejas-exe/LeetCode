class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int ans[] = new int[k];
        int n = mat.length;
        PriorityQueue<Store> pq = new PriorityQueue<>();
        for(int i =0;i<n;i++){
            int count = 0;
            for(int j =0;j<mat[0].length;j++){
                if(mat[i][j] ==1) count ++;
            }
            pq.add(new Store(count , i));
        }
        for(int i =0;i<k;i++){
            ans[i] = pq.remove().index;
        }
        return ans;
    }
    static class Store implements Comparable<Store>{
        int count ;
        int index ;
        public Store(int count , int index){
            this.count = count ;
            this.index = index ;
        }

        @Override
        public int compareTo(Store s2){
            if(s2.count == this.count){
                return this.index - s2.index;
            }
            return this.count - s2.count ;
        }
    }
}