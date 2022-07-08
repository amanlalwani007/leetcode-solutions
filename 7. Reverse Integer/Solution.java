class Solution {
    public int reverse(int x) {
        boolean negative=false;
        int num =x ;
        if(num<0){
            negative=true;
            num*=-1;
        }
        
        long reversed=0;
        while(num>0){
            reversed= (reversed)*10+(num%10);
            num/=10;
        }
        
        if(reversed >Integer.MAX_VALUE){
            return 0;    
        }
        return  negative?(int)(-1*reversed):(int)reversed;
        
        
    }
}