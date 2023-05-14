
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;



public class Main {
	
	public static int VERTICES_NUM;
	public static int EDGES_NUM;
	
	public static ArrayList<Integer>[] graph; 
	public static boolean[] visited;
	public static Queue<Integer> q = new LinkedList<>();
	
	public static void BFS() {
		while(!q.isEmpty()) {
			int currV = q.poll();
			
			for(int i = 0; i < graph[currV].size(); i++) {
				int nextV = graph[currV].get(i);
				if(!visited[nextV]) {
					visited[nextV] = true;
					q.add(nextV);
				}
			}
		}
	}
	
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		VERTICES_NUM = Integer.parseInt(br.readLine());
		EDGES_NUM = Integer.parseInt(br.readLine());
		graph = new ArrayList[VERTICES_NUM+1];
		for(int i = 1; i <= VERTICES_NUM; i++) {
			graph[i] = new ArrayList<>();
		}
		
		visited = new boolean[VERTICES_NUM + 1];
		
		int[] startPoints = new int[EDGES_NUM];
		int[] endPoints = new int[EDGES_NUM];
		
		
		
		for(int i = 0; i < EDGES_NUM; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			startPoints[i] = Integer.parseInt(st.nextToken());
			endPoints[i] = Integer.parseInt(st.nextToken());
			
		}
		
		for(int i = 0; i < EDGES_NUM; i++) {
			int start = startPoints[i];
			int end = endPoints[i];
			
			graph[start].add(end);
			graph[end].add(start);
		}
		
		int rootVertex = 1;
		visited[rootVertex] = true;
		q.add(rootVertex);
		BFS();
		
		int cnt = 0;
		for(int i = 0; i < visited.length; i++) {
			if(visited[i] == true) {
				cnt++;
			}
		}
		
		System.out.println(cnt-1);
		
		
		
		
		
	}// end of main(String args[])  -----------------------------
		
	
}      


