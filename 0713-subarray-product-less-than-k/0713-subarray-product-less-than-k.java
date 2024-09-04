class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n=nums.length;
        int c=0;
        for(int i=0;i<n;i++){
            int sum=1;
            for(int j=i;j<n;j++){
                sum=sum*nums[j];
                if(sum<k){
                    c++;
                }
            }
        }
        return c;
    }
}