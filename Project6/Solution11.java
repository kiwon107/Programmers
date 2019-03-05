class Solution11 {
    
    int answer;
    
    public int solution(int[] numbers, int target) {
        
        if(truth(numbers, target))
            answer = answer+1;
        
        BFS(numbers, target, -1);
        
        return answer;
    }
    
    public void BFS(int[] numbers, int target, int iter) {
        iter = iter+1;
        
        if (iter==numbers.length)
            return;
        
        numbers[iter] = numbers[iter]*1;
        BFS(numbers, target, iter);
        
        numbers[iter] = numbers[iter]*(-1);
        if(truth(numbers, target))
            answer = answer+1;
        BFS(numbers, target, iter);
    }
    
    public boolean truth (int[] numbers, int target) {
        
        int sum=0;
        
        for (int i=0; i<numbers.length; i++) {
            sum=sum+numbers[i];    
        }
        
        if (sum==target)
            return true;
        else
            return false;
    }
}