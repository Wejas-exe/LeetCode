class Solution {
    public int countLargestGroup(int n) {
        if(n<10) return n;
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for(int i =1;i<=n;i++){
            int sum = 0;
            int temp = i;
            while(temp > 0){
                sum += temp%10;
                temp /= 10;
            }
            map.put(sum , map.getOrDefault(sum , 0) + 1);
            max = Math.max(max , map.get(sum));
        }
        int count = 0;
        for(Integer value : map.values()){
            if(value == max) count ++;
        }
        return count;
    }
}