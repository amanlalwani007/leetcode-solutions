class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int k =n-2;
        for(int i= n-1;i>0;i--){
            if(nums[i]<=nums[i-1]){
                k--;
            }
            else {
                break;
            }

        }
        if(k==-1){
            reverse(nums, 0, n-1);
            return;
        }
        for(int i= n-1;i>0;i--){
          if(nums[i]>nums[k]){
              int temp = nums[k];
              nums[k]=nums[i];
              nums[i]=temp;
              break;

          }
          

        }
        reverse(nums, k+1, n-1);


        

        
    }


    void reverse(int[] nums,int start,int  end){
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }


    } 
}



//13542-> 14532
//step 1 find breaking points where   nums[i-1]< nums [i] where i=n-1




