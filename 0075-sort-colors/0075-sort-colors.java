class Solution {
    public void sortColors(int[] nums) {
        quicksort(nums , 0 , nums.length - 1);
    }

    public void quicksort(int[] nums , int si , int ei){
        if (si >= ei) return;
        int pivotIdx = partition(nums , si , ei);
        quicksort(nums, si , pivotIdx - 1);
        quicksort(nums, pivotIdx + 1, ei);
    }

    public int partition(int[] nums , int si , int ei){
        int pivot = nums[ei];
        int i = si - 1;

        for (int j = si; j < ei; j++) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }

        swap(nums, i + 1, ei);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
