import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1){
            return intervals;
        }
        Arrays.sort(intervals,(arr1,arr2)-> Integer.compare(arr1[0], arr2[0]));
        Stack<int[]> stack = new Stack<>();
        stack.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int startpoint2 = intervals[i][0];
            int endpoint2= intervals[i][1];
            int[]  poparray=stack.pop();
            int startpoint1= poparray[0];
            int endpoint1= poparray[1];
            int endmax = Math.max(endpoint2, endpoint1);
            if(endpoint1>=startpoint2){
                int[] merge= new int[]{startpoint1,endmax};
                stack.add(merge);
            }
            else {
                stack.add(poparray);
                stack.add(intervals[i]);
            }


        }

        int[][] output =new int[stack.size()][2];
        for(int i=output.length-1;i>=0;i--){
            int[] poparray=stack.pop();
            output[i][0]=poparray[0];
            output[i][1]=poparray[1];
        }
        return output;

        
    }
}