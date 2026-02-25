
import java.util.*;

class Solution {
    boolean solution(String s) {
        
        char[] array = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        
        for(int i =0;i<array.length; i++){
            if(stack.isEmpty()){
                stack.push(array[i]);
            }else{
                if(stack.peek() == '('){
                    if(array[i] == ')'){
                        stack.pop();
                    }else{
                        stack.push(array[i]);
                    }
                }else{
                    stack.push(array[i]);
                }
            }
        }
        
        if(stack.isEmpty()){
            return true;
        }
        
        return false;
    }
}