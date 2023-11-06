걸린 시간 : 35분
레벨 : 실버 2

import java.io.*;
import java.util.*;

public class Main {
	
	static ArrayList<Integer>[] graph;
	static boolean visited[];
	static int[] 방문한노드들;
	static int count = 1;
	
	public static void dfs(int startNode) {
		visited[startNode] = true;
		방문한노드들[startNode] = count;
		
		for(int i = 0; i < graph[startNode].size(); i++) {
			int node = graph[startNode].get(i);
			if(!visited[node]) {
				count++;
				dfs(node);
			}
		}
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		graph = new ArrayList[n+1];
		
		for(int i = 0; i < n+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		visited = new boolean[n+1];
		방문한노드들 = new int[n+1];
		
		for(int i = 0; i <m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph[from].add(to);
			graph[to].add(from);
		}
		
		for(ArrayList list : graph) {
			Collections.sort(list);
		}
		
		dfs(start);
		
		for(int i = 1; i < 방문한노드들.length; i++) {
			System.out.println(방문한노드들[i]);
		}
		

	}// end of main(String args[])  -----------------------------
}      
