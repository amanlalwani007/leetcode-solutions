import java.util.ArrayList;

class Solution {
    int merge(int[] nums, int low, int mid, int high) {
        int cnt = 0;
        int j = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (j <= high && nums[i] > (2 * (long) nums[j])) {
                j++;
            }
            cnt += (j - (mid + 1));

        }
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low, right = mid + 1;
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp.add(nums[left++]);
            } else {
                temp.add(nums[right++]);
            }
        }

        while (left <= mid) {
            temp.add(nums[left++]);

        }
        while (right <= high) {
            temp.add(nums[right++]);
        }
        for (int i = low; i <= high; i++) {
            nums[i] = temp.get(i - low);
        }
        return cnt;

    }

    int mergeSort(int[] nums, int low, int high) {
        if (low >= high)
            return 0;
        int mid = (low + high) / 2;
        int inv = mergeSort(nums, low, mid);
        inv += mergeSort(nums, mid + 1, high);
        inv += merge(nums, low, mid, high);
        return inv;

    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);

    }
}

//class Solution {
//     int count=0;
//     public int reversePairs(int[] nums) {
//         mergeSort(0,nums.length-1,nums);
        
//         return count;
//     }
//     private void mergeSort(int start, int end, int[] nums){
        
//         if(start<end){
//         int mid=(start+end)/2;
//         mergeSort(start,mid,nums);
//         mergeSort(mid+1,end,nums);
            
//         merge(start,mid, mid+1,end, nums);
//         }

//     }
//     private void merge(int lstart, int lend, int rstart, int rend, int[] nums){
//         int[] larr=Arrays.copyOfRange(nums,lstart, lend+1);
//         int[] rarr=Arrays.copyOfRange(nums,rstart, rend+1);
//         int li=0;
//         int ri=0;
//         int i=lstart;
//         //comparing
//         int cl=0;
//         int rl=0;
//         for(cl=0;cl<larr.length;cl++){
//             while(rl<rarr.length && (long)larr[cl]>2*(long)rarr[rl]){
//                 rl++;
//             }
//             count+=rl-0;
//         }
//         //fill
//         while(li<larr.length && ri< rarr.length){
//             if(larr[li]<=rarr[ri]){
//                 nums[i]=larr[li];
//                 i++;
//                 li++;
//             }
//             else{
//                 nums[i]=rarr[ri];
//                 i++;
//                 ri++;
//             }
//         }
//         while(li<larr.length){
//             nums[i]=larr[li];
//             i++;
//             li++;
//         }
//         while(ri<rarr.length){
//              nums[i]=rarr[ri];
//             i++;
//             ri++;
//         }
        
//     }
// }