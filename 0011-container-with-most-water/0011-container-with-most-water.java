class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left =0;
        int right =n-1;
        int area =0;
        int maxArea =0;
        while(left<right){
            int dist = right-left;
            area = Math.min(height[left],height[right])*dist;
            maxArea = Math.max(area,maxArea);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
}