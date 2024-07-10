class Solution {
    public int countPrimes(int n) {
       int c=0;
       for(int i=2;i<n;i++){
        if(i%2!=0){
            c++;
        }
       } 
       return c;
    }
}