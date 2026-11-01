class Solution {
    public boolean isPowerOfFour(int n) {
//         if (n <= 0) {
//             return false;
//         }

//         while (n % 4 == 0) {
//             n = n / 4;
//         }

//         return n == 1;


       int count=0;
        for (int i = 0; i < 32; i++) {
        if(((n>>>i)&1)==1){
            count++;
         if(i%2!=0){
        return false;
         }
        }

       }
       return count==1;
    }
}
