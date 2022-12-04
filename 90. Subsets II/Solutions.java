import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public void findSubsets(int ind, int[] nums, List<Integer> ds , List<List<Integer>> ansList) {
        ansList.add(new ArrayList<>(ds));
        for(int  i=ind;i<nums.length;i++){
                if(i!=ind &&nums[i]==nums[i-1]) continue;
                ds.add(nums[i]);
                findSubsets(i+1,nums, ds, ansList);
                ds.remove(ds.size()-1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> anslist=new ArrayList<>();
        findSubsets(0, nums,new ArrayList<>(), anslist);
        return anslist;
        
    }
}