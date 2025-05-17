class Solution {
    public void sortColors(int[] nums) {
        quickSort(nums,0,nums.length-1);
    }
    public void quickSort(int[] nums, int si,int ei){
        if(si>=ei) return ;

        int pidx = partition(nums,si,ei);
        quickSort(nums,si,pidx-1);
        quickSort(nums,pidx+1,ei);
    }
    public int partition(int[] nums,int si,int ei){
        int pivot = nums[ei];
        int i = si-1; // this means -1

        for(int j =si;j<=ei-1;j++){
            if(nums[j]<pivot){
                i++; // to make place in array

                //now swap
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp ;
            }
        }
        i++;
        // now lastly shifting pivot to its correct position
        int temp = pivot ;
        nums[ei] = nums[i] ;
        nums[i] = temp;
        return i;
    }
}