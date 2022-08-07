class Solution {
    public int firstMissingPositive(int[] nums) {

        // step 1: - mark element which are out of range and manage presence of one
        // step 2:- map elements with index
        // step 3:- find out missing integer

        boolean one = false;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                one = true;
            }
            if (nums[i] < 1 || n < nums[i]) {
                nums[i] = 1;
            }
        }
        if (one == false) {
            return 1;
        }
        for (int i = 0; i < n; i++) {
            int idx = Math.abs(nums[i]);
            nums[idx - 1] = -Math.abs(nums[idx - 1]);

        }
        // find out missing integer
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;

    }
}