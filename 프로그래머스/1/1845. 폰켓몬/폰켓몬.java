import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int i = 0;i<nums.length;i++){
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1); 
        }
        
        if(hm.size()<nums.length/2){
            answer += hm.size();
        }else{
            answer += nums.length/2;
        }
        
        return answer;
    }
}