class Solution {
    public int subtractProductAndSum(int n) {
        int a=n;
        int b=0;
        int product=1,sum=0;
        while(a!=0){
            b=a%10;
            product*=b;
            a=a/10;
        }
        a=n;
        b=0;
        while(a!=0){
            b=a%10;
            sum+=b;
            a=a/10;
        }
        return product-sum;
    }
}