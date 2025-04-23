class Solution {
    public int countLargestGroup(int n) {
        if(n<10) return n;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =1;i<=n;i++){
            int sum = 0;
            int temp = i;
            while(temp > 0){
                sum += temp%10;
                temp /= 10;
            }
            map.put(sum , map.getOrDefault(sum , 0) + 1);
        }
        HashMap<Integer,Integer> map2 = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for(Integer value : map.values()){
            max = Math.max(max , value);
        }
        int count = 0;
        for(Integer value : map.values()){
            if(value == max) count ++;
        }
        return count;
    }
}