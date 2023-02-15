class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> arr = new ArrayList<>();
        int len1 = nums1.length;
        int len2 = nums2.length;
        for(int i=0 ; i<len1 ; i++){
            int x = nums1[i];
            if(map.containsKey(x)){
                map.put(x,map.get(x)+1);
            }
            else{
                map.put(x,1);
            }
        }
        
        for(int i=0 ; i<len2 ; i++){
            int y = nums2[i];
            if(map.containsKey(y)&&map.get(y)>0){
                arr.add(y);
                map.put(y,map.get(y)-1);
            }
        }
        
        int[] a = new int[arr.size()];
        int j=0;
        for(int i: arr){
            a[j++] = i;
        }
  
        return a;
        
    }
}