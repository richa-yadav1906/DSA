class Solution {
    public int binaryGap(int n) {
        String binary=Integer.toBinaryString(n);
        int currIdx=0;
        int prevIdx=0;
        int maxDis=0;

        while(currIdx<binary.length()){
            if(binary.charAt(currIdx)=='1'){
                maxDis=Math.max(maxDis,currIdx-prevIdx);
                prevIdx=currIdx;
            }
            currIdx++;
        }
       return maxDis;
    }
}