import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

class Solution {
    HashMap<Integer,Integer> map ;
    Random r;
    int top;
    public Solution(int n, int[] blacklist) {
        
        map= new HashMap<>();
        r=new Random();
        top =n-blacklist.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<blacklist.length;i++){
            set.add(blacklist[i]);
        }
        n--;
        for(int i=0;i<blacklist.length;i++){
            if(blacklist[i]<top){
                while(set.contains(n)==true){
                    n--;
                }
                map.put(blacklist[i], n);
                n--;
            }
        }
    }
    public int pick() {
        int randidx=r.nextInt(top);
        if(map.containsKey(randidx)){
            return map.get(randidx);
        }
        return randidx;
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */