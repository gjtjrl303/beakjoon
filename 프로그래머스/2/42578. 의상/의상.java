import java.util.*;
    
class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i<clothes.length; i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1],0) + 1);
        }
        
        
        int result = 1;
        for(String key : map.keySet()){
            System.out.println(map.get(key) + "\n");
            result *= map.get(key) + 1;
        }
        return result-1;
    }
}