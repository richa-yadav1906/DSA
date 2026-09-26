class Solution {
    public int numRescueBoats(int[] people, int limit) {
     int len=people.length;
     
     Arrays.sort(people);

     int i=0;
     int j=len-1;

     int boats=0;

     while(i<=j){
    if(people[i]+people[j]<=limit){
        j--;
        i++;
        boats++;
    }
    else{
        j--;
        boats++;
    }
     }
     return boats;
            
}}