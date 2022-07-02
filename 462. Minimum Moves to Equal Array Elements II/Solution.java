// import java.util.Arrays;

// class Solution {
//     public int minMoves2(int[] nums) {
//         //sort the array
//         Arrays.sort(nums);
//         int n=nums.length;
//         // find median 
//         int median= n%2==0?(nums[n/2]+nums[n/2-1])/2:nums[n/2];
//         //calculate steps
//         int steps =0;
//         for(int num:nums){
//             steps +=Math.abs(num -median);

//         }
//         return  steps;
//     }
// }

// time comlexity O(nlogn) space complexity :- O(1)

import java.util.Arrays;

class Solution {
    public int minMoves2(int[] nums) {
        // sort the array
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int steps = 0;
        while (i < j) {
            steps += nums[j] - nums[i];
            i++;
            j--;
        }
        return steps;

    }
}

// time comlexity O(nlogn) space complexity :- O(1)

