class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp=new  boolean[s.length()][s.length()];
        String len="";
        for(int g=0;g<s.length();g++){
            for(int i=0 ,j=g;j<s.length();i++,j++){
                if(g==0){
                    dp[i][j]=true;
                }
                else if(g==1){
                    dp[i][j]=s.charAt(i)==s.charAt(j)?true:false;
                }
                else {
                    dp[i][j]=(s.charAt(i)==s.charAt(j))&&(dp[i+1][j-1]==true)?true:false;
                }
            len=dp[i][j]?s.substring(i, j+1):len;

            }
        }  

        return len;
        
    }
}


//Time complexity :- O(n**2)  space  complexity :-  O(N)

