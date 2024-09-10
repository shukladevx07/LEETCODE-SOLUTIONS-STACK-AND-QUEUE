class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            if(!ans.contains(nums[i])){
                ans.add(nums[i]);
            }
        }
        int[] arr=new int[ans.size()];
          int p=0;
          for(int num:ans)
          {
              arr[p++]=num;
          }
         if(arr.length<3)
         return arr[arr.length-1];
         else
         return arr[arr.length-3];


    }
}