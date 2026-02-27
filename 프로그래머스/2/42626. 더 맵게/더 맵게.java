import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Integer> heap = new PriorityQueue<>();
        int count = 0;
        
        for(Integer num : scoville){
            heap.offer(num);
        }
    
    while(true){
        if(heap.size() <= 1) break;
        int temp1 = heap.poll();
        int temp2 = heap.poll();
        if(temp1 >= K) return count; 
        heap.offer(temp1 + temp2 * 2);
        count++;
    }
    
    if(heap.poll() > K)return count;
    return -1;
    }
}