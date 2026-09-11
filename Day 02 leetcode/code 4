class Solution {
    public int search(int[] nums, int target) {
        int low = 0 , r = nums.length-1;
        while(low<=r){
            int mid = (low + r) / 2;
            if(nums[mid]==target) return mid;
        else if(nums[mid]>target){
            r=mid-1;

        }
        else{
            low=mid+1;
        }
        }
        return -1;
    }
}
