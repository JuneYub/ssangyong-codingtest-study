class Solution {
	// 재귀 문제 접근 방법
	// 기본적인 상태, 종료조건, 점화식
	// 1. 기본적인 상태 => 정사각형 (offsetX, offsetY, size) 상단 좌측 시작점을 기준으로 size 만큼의 정사각형임
	// 2. 종료조건 => 정사각형의 모든 내용이 같으면 종료 모두 1이면 1 모두 0이면 0 => {0:1, 1:0} = 0, {0:0, 1:1} = 1
	// 3. 점화식 => 큰 정사각형은 좌측 시작점을 기준으로 사이즈/2 만큼 더해주면서 총 4개의 정사각형으로 나눌 수 있으며 이를 더하면 큰 정사각형이 된다.
	
	
    // 각 네모를 표현하는 클래스를 선언
    public static class Count {
        public final int zero;
        public final int one;
    
        public Count(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }
        
        // 새로운 Count 객체를 생성해서 거기다가 다른 Count 객체의 값을 더해주는 메소드
        public Count add(Count otherCount) {
            return new Count(zero + otherCount.zero ,one + otherCount.one);
        }
    }
    
    private Count countAll(int offsetX, int offsetY, int size, int[][] arr) {
        int h = size/2;
        for(int y = offsetY; y < offsetY+size; y++) {
            for(int x = offsetX; x < offsetX+size; x++) {
                if(arr[y][x] != arr[offsetY][offsetX]) {
                    return countAll(offsetX, offsetY, h, arr)
                        .add(countAll(offsetX+h, offsetY, h, arr))
                        .add(countAll(offsetX, offsetY+h, h, arr))
                        .add(countAll(offsetX+h, offsetY+h, h, arr));
                }
            }
        }
        if(arr[offsetY][offsetX] == 1) {
            return new Count(0, 1);
        }
        else {
            return new Count(1, 0);
        }
    }
    
    public int[] solution(int[][] arr) {
        Count count = countAll(0, 0, arr.length, arr);
        return new int[] {count.zero, count.one};
    }
}