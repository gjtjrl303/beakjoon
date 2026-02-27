import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int commandCount = commands.length;
        int[] result = new int[commandCount];
        int index = 0;
        
        for(int i = 0 ; i<commandCount ; i++){
            int start = commands[i][0];
            int end = commands[i][1];
            int targetIndex = commands[i][2];
            int[] newArray = Arrays.copyOfRange(array, start - 1, end);
            Arrays.sort(newArray);
            result[index++]  = newArray[targetIndex - 1];
        }
        return result;
    }
}