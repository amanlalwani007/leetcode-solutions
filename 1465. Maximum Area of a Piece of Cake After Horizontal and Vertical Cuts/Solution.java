import java.util.Arrays;

// class Solution {
//     public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {

//         Arrays.sort(horizontalCuts);
//         Arrays.sort(verticalCuts);
//         horizontalCuts = Arrays.copyOf(horizontalCuts, horizontalCuts.length + 1);
//         verticalCuts = Arrays.copyOf(verticalCuts, verticalCuts.length + 1);
//         horizontalCuts[horizontalCuts.length-1]=h;
//         verticalCuts[verticalCuts.length-1]=w;
//         int  largest_area =0;
//         int prev_height=0,prev_width=0;
//         for(int hc:horizontalCuts){
//             prev_width=0;
//             for(int vc:verticalCuts){
//                 int area=(int)((long)((hc-prev_height)*(vc-prev_width))%1000000007);
//                 largest_area=Math.max(area,largest_area);
//                 prev_width=vc;

//             }
//             prev_height=hc;


//         }

//         return largest_area;
        
//     }
// }





//naive solution 
//sort the horizontal cuts 
// C[i][j]=(h[i]-h[i-1])*(vc[j]-vc[j-1]) 


//optimize one 






class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        int maxHeight=Math.max(horizontalCuts[0]-0,h-horizontalCuts[horizontalCuts.length-1]);
        for(int i=1;i<horizontalCuts.length;i++){
            maxHeight=Math.max(maxHeight,horizontalCuts[i]-horizontalCuts[i-1]);
        }
        int maxWidth=Math.max(verticalCuts[0]-0,w-verticalCuts[verticalCuts.length-1]);
        for(int i=1;i<verticalCuts.length;i++){
            maxWidth=Math.max(maxWidth,verticalCuts[i]-verticalCuts[i-1]);
        }
        long ans= 1L * maxWidth * maxHeight;
        return (int)(ans%1000000007);
    }
}
