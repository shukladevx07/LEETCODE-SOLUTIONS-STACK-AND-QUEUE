class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int n1=flowerbed.length;
        if(n>1){
            if(flowerbed[0]==0&&flowerbed[1]==0){
                --n;
                flowerbed[0]=1;
            }
        }
        for(int i=1;i<n1-1;i++){
            if(flowerbed[i]==1){
                continue;
            }
            else if(flowerbed[i]==0&&flowerbed[i-1]==0&&flowerbed[i+1]==0){
                --n;
                flowerbed[i]=1;
            }
        }
        if(n==0)
        return true;
        else
        return false;
    }
}