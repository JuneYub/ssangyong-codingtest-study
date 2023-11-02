걸린 시간 : 90분
레벨 : 골드 5

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
				
		int[] 종유석배열 = new int[h+1];
		int[] 석순배열 = new int[h+1];
		
		for(int i = 0; i < n; i++) {
			int k = Integer.parseInt(br.readLine());
			if((i+1) % 2 == 0) { // 종유석
				종유석배열[k]++;
			} 
			else { // 석순
				석순배열[k]++;
			}
		}
		for(int i = h; i > 0; i--) {
			석순배열[i-1] = 석순배열[i] + 석순배열[i-1];
			종유석배열[i-1] = 종유석배열[i] + 종유석배열[i-1];
		}

		int min = Integer.MAX_VALUE;
		int count = 0;
		
		for(int i = 1; i <= h; i++) {
			int temp = 석순배열[i] + 종유석배열[h+1-i];
			if(temp < min) {
				min = temp;
				count = 1;
			}
			else if(temp == min) {
				count++;
			}
		}
		System.out.println(min + " " + count);
	}// end of main(String args[])  -----------------------------
}      