class Solution {
    public int binaryGap(int n) {
        String s = Integer.toBinaryString(n);
        int count =1;
        int maxCount =1;
        int oneCount = 0;
        System.out.println(s);
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                oneCount++;
                maxCount = Math.max(maxCount,count);
                count=1;
            }else{
                count++;
            }
        }
        if(oneCount==1 || oneCount ==0){
            return 0;
        }
        return maxCount;
    }
}