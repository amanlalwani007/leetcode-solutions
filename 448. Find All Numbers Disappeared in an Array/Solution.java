class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
          int n = nums.length;
    int [] missing = new int[n];
    
    for(int i =0; i<n; i++){
        
        int curr = nums[i];
        int miss = curr-1;
        if(missing[miss]==0){
            
            missing[miss] = -1;
        }
    }
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i<n; i++){
            if(missing[i]==0){
                list.add(i+1);
                
            }
            
        }
        return list;
        
    }
}