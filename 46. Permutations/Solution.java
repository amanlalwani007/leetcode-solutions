import java.util.ArrayList;
import java.util.List;

// class Solution {
//     private void recurPermute(int[] nums, List<Integer> ds, List<List<Integer>> ans, boolean[] freq) {
//         if (ds.size() == nums.length) {
//             ans.add(new ArrayList<>(ds));
//         }
//         for (int i = 0; i < nums.length; i++) {
//             if (!freq[i]) {
//                 freq[i] = true;
//                 ds.add(nums[i]);
//                 recurPermute(nums, ds, ans, freq);
//                 ds.remove(ds.size() - 1);
//                 freq[i] = false;
//             }
//         }
//     }

//     public List<List<Integer>> permute(int[] nums) {
//         List<List<Integer>> ans = new ArrayList<>();
//         List<Integer> ds = new ArrayList<>();
//         boolean freq[] = new boolean[nums.length];
//         recurPermute(nums, ds, ans, freq);
//         return ans;

//     }
// }


class Solution {
    private void recurPermute(int index , int[]nums ,List<List<Integer>> ans) {
        if(index == nums.length){
            List<Integer> ds= new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=index;i<nums.length;i++){
            swap(i,index,nums);
            recurPermute(index+1, nums, ans);
            swap(i, index,nums);
        }
        
    }

    private void swap(int i,int j, int[] nums){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;

    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        recurPermute(0,nums,ans);
        return ans;

    }
}