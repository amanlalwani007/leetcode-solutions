import java.util.ArrayList;
import java.util.Collections;

public  class Solution {
    void func(int ind , int sum, ArrayList<Integer> arr ,int N,ArrayList<Integer> sumSubset){
        if(ind==N){
            sumSubset.add(sum);
            return ;
        }
        //element picked
        func(ind+1, sum+arr.get(ind),arr,N, sumSubset);
        //element not picked  
        func(ind+1, sum,arr,N,sumSubset);
    }

    ArrayList<Integer> subsetSums(ArrayList<Integer> arr,int N){
        ArrayList<Integer> sumSubset=new  ArrayList<>();
        func(0,0,arr,N,sumSubset);
        Collections.sort(sumSubset);
        return sumSubset;
    }
}
