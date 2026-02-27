import java.lang.*;
import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        List<String> list = new ArrayList<>();
        for(int i =0;i <numbers.length;i++){
            list.add(String.valueOf(numbers[i]));
        }
        
        Collections.sort(list, (a,b) -> (b+a).compareTo(a+b));
        
        StringBuilder st = new StringBuilder();
        
        if(list.get(0).equals("0")){
            return "0";
        }
        
        for(String num : list){
            // System.out.println(num);
            st.append(num);
        }
        
        
        return st.toString();
    }
}