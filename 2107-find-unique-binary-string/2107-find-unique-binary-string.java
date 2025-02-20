class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums[0].length();
        int total = (int)Math.pow(2,n);
        HashSet<String> set = new HashSet<>();
        for(String s : nums){
            set.add(s);
        }
        for(int i =0;i<total;i++){
            String binary = String.format("%"+n+"s",Integer.toBinaryString(i)).replace(' ','0');
            if(!set.contains(binary)){
                return binary;
            }
        }
        return "00";
    }
}