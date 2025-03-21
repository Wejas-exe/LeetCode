class Solution {
public:
    int rob(vector<int>& nums) {\
        if(nums.size() == 1){
            return nums[0];
        }
        int pre = 0;
        int prev = nums[0];
        int max = 0;
        for(int i =1;i<nums.size();i++){
            max = std::max(pre+nums[i] , prev);
            pre = prev;
            prev = max;
        }
        return max ;
    }
};