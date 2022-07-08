import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        int left =0,right=0;
        HashMap<Character,Integer> map =new HashMap<>();
        int n =s.length();
        int len=0;
        while(right<n){
            if(map.containsKey(s.charAt(right))){
                left=Math.max(map.get(s.charAt(right))+1,left);
            }

            map.put(s.charAt(right),right);
            len=Math.max(len,right-left+1);
            right++;
        }

        return len;
        
    }
} 


//Time complexity:- O(n) space  complexity :- O(n)


