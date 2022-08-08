import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Iterator;


public class Lru_Cache {
    private Deque<Integer> doublyQueue;
    private HashSet<Integer> hashSet;
    private final int CACHE_SIZE;
    Lru_Cache(int capacity ){
        doublyQueue= new LinkedList<>();
        hashSet= new HashSet<>();
        CACHE_SIZE=capacity;
    }

    public void refer (int page ){
     if(!hashSet.contains(page)){
        if (doublyQueue.size()==CACHE_SIZE){
            int last=doublyQueue.removeLast();
            hashSet.remove(last);      
        }
     }
     else {
        doublyQueue.remove(page);
     }
     doublyQueue.push(page);
     hashSet.add(page);   
    }

    public void display(){
        Iterator<Integer> itr= doublyQueue.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }


    public static void main(String[] args) {
        Lru_Cache cache= new Lru_Cache(4);
        cache.refer(1);
        cache.refer(2);
        cache.refer(3);
        cache.refer(1);
        cache.refer(4);
        cache.refer(5);
        cache.display();
    }

}
