import java.util.*;

class Solution {
    // 상태 {원판개수, from, to}
    // 종료조건 {1, from, to}
    // 점화식 {n, from, to} = {n-1, from, empty} + {1, from, to} + {n-1, empty, to}
    private void doHanoi(int n, int from, int to, List<int[]> process) {
        if(n == 1) {
            process.add(new int[] {from, to});
            return;
        }
        
        int empty = 6 - from - to;
        doHanoi(n-1, from, empty, process);
        doHanoi(1, from, to, process);
        doHanoi(n-1, empty, to, process);
    }
    
    
    public int[][] solution(int n) {
        List<int[]> process = new ArrayList<>();
        doHanoi(n, 1, 3, process);
        return process.toArray(new int[0][]);
    }
}