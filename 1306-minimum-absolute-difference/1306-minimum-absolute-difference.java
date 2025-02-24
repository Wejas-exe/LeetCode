class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> list = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        for(int i =0;i<arr.length-1;i++){
            int diff = Math.abs(arr[i]-arr[i+1]);
            minDiff = Math.min(diff,minDiff);
        }
        for(int i =0;i<arr.length-1;i++){
            if(Math.abs(arr[i]-arr[i+1]) == minDiff){
                list.add(Arrays.asList(arr[i], arr[i+1]));
            }
        }
        return list;
    }
}