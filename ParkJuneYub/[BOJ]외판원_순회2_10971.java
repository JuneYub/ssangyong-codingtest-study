걸린 시간 : 60분
레벨 : 실버 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static int n;
	public static int minPrice = Integer.MAX_VALUE;
	public static int[][] map;
	
	public static void backTracking(int depth, boolean[] visited, int price, int preDestination, int start) {
		if(depth == n-1) {
			if(map[preDestination][start] != 0) {
				price += map[preDestination][start];
				if(price < minPrice) {
					minPrice = price;
				}
			}
			return;
		}
		for(int destination = 0; destination < n; destination++) {
		
			if(!visited[destination] && destination != preDestination && map[preDestination][destination] != 0) {
				visited[preDestination] = true;
				price += map[preDestination][destination];
				backTracking(depth+1, visited, price, destination, start);
				visited[destination] = false;
				price -= map[preDestination][destination];
			}
		}
		
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		boolean[] visited = new boolean[n];
		
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int start = 0; start < n; start++) {
			visited[start] = true;
			backTracking(0, visited, 0, start, start);
		}

		System.out.print(minPrice);
	}// end of main(String args[])  -----------------------------
}      
