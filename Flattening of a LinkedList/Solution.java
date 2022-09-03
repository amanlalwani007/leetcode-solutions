
public class Solution {
    class Node {
       
        int data;
        Node bottom;
        Node(int data){
            this.data=data;
        }
    }
    Node mergeTwoLists(Node a,Node b){
        Node temp= new Node(0);
        Node res = temp ;
        while (a!=null &&b!=null){
            if(a.data<b.data){
                temp.bottom=a;
                temp=temp.bottom;
                a=a.bottom;
            }
            else {
                temp.bottom =b ;
                temp=temp.bottom;
                b=b.bottom;
            }
        }
        if(a!=null) temp.bottom=a;
        else temp.bottom=b;
        return res.bottom;

    }
    
}
