class Solution {
    //  width*height -( (width +height-2)*2 )
    public int[] solution(int brown, int yellow) {
        for(int width = 3; width <= 4500; width++ ) {
            for(int height = 3; height<= width; height++) {
                int brBlock = (width +height-2)*2;
                int ylBlock = width*height - brBlock;
                
                if(brBlock == brown && ylBlock == yellow) {
                    return new int[] {width, height};
                }
            }
        }
        return null;
    }
}