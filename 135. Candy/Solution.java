import java.util.Arrays;

// class Solution {
//     public int candy(int[] ratings) {

//         int candies = 0;
//         int n= ratings.length;
//         int[] left = new int[n];
//         int[] right = new int[n];
//         Arrays.fill(left, 1);
//         Arrays.fill(right, 1);

//         for (int i = 1; i < n; i++) {
//             if (ratings[i] > ratings[i - 1]) {
//                 left[i] = left[i - 1] + 1;

//             }
//         }

//         for (int i = n - 2; i >= 0; i--) {
//             if (ratings[i] > ratings[i + 1]) {
//                 right[i] = right[i + 1] + 1;
//             }
//         }

//         for (int i = 0; i < n; i++) {
//             candies = candies + Math.max(left[i], right[i]);
//         }
//         return candies;

//     }
// }


//time complexity O(n) space complexity O(n)




class Solution {
    public int candy(int[] ratings) {
        int up=0;
        int down =0;
        int  prevslope =0;
        int candies =0;
        for(int i=1;i<ratings.length;i++){
            int curslope = ratings[i]>ratings[i-1]?1:(ratings[i]<ratings[i-1]?-1:0);
        //divide the mountains on three cond \/ || \_ || /-


        if((prevslope<0 &&curslope>=0)||(prevslope>0&&curslope==0)){
            candies+=sum(up)+sum(down)+Math.max(up,down);
            up=0;
            down=0;
        }

        if(curslope>0){
            up++;
        }
        else if(curslope<0) down++;
        else candies++;

        prevslope=curslope;


        }

        candies=candies+sum(up)+sum(down)+Math.max(up, down)+1;
        return candies;



    }

    private int sum(int n){
        return (n*(n+1))/2;
    }
}


//slope method with time  complexity O(n) and  space complexity O(1)

