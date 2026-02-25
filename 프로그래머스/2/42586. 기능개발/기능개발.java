import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        
        int index = 0;
        ArrayDeque<Task> queue = new ArrayDeque<>();
        
        for(int i = 0;i<progresses.length;i++){
            queue.add(new Task(progresses[i], speeds[i]));
        }    
        
        while(!queue.isEmpty()){
            int flag = 0;
            
            for(Task task : queue){
                task.turn();
                }
            
             while(!queue.isEmpty() && queue.peek().check()){
                queue.poll();
                flag++;
            }
            if(flag != 0){
                answer.add(flag);                
            }   
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
    
    static class Task{
        int progress;
        int speed;
        
        public Task(int progress, int speed){
            this.progress = progress;
            this.speed = speed;
        }
        
        public boolean check(){
            return progress >= 100;
        }
        
        public void turn(){
            progress+=speed;
        }
    }
}