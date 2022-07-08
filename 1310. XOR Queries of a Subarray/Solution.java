class Solution {
    public int[] xorQueries(int[] arr, int[][] q) {
         int n = arr.length;
         int qs=q.length;
         int[] prefXor =new int[n];
         prefXor[0]=arr[0];
         for(int i=1; i<n;i++){
             prefXor[i]=prefXor[i-1] ^ arr[i];
         }
         int[] ans = new int[qs];
         for(int i=0;i<qs;i++){
            int l=q[i][0];
            int r=q[i][1];
            if(l==0) ans[i]=prefXor[r];
            else ans[i]=prefXor[r]^prefXor[l-1];
          }
          return ans;
 
         
     }
 }