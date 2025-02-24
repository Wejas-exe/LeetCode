class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] a) {
        List<List<Integer>> res=new ArrayList();
        int n=a.length;
        Arrays.sort(a);
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n-1;i++){
            int diff=a[i+1]-a[i];
            if(diff<min){
                min=diff;
                res.clear();
                res.add(Arrays.asList(a[i],a[i+1]));
            }
            else if(diff==min){
                res.add(Arrays.asList(a[i],a[i+1]));
            }
        }
        return res;
    }
}