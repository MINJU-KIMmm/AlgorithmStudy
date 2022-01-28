package Ch3_DfsBfs;
import java.util.*;
import java.io.*;
public class 실전4_김민주 {

	static int[] dx= {-1, 1, 0, 0};
	static int[] dy= {0, 0, -1, 1};
	static int[][] arr;
	static int N, M;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		arr=new int[N][M];
		for(int i=0;i<N;i++) {
			String str=br.readLine();
			for(int j=0;j<M;j++) {
				arr[i][j]=str.charAt(j)-'0';
			}
		}
		
		bfs();
		
		System.out.println(arr[N-1][M-1]);
	}
	
	static void bfs() {
		Queue<Maze>q=new LinkedList<>();
		
		q.offer(new Maze(0,0));		


		while(!q.isEmpty()) {
			Maze maze=q.poll();
			int x=maze.x;
			int y=maze.y;
			
			for(int i=0;i<4;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				
				if(nx<0||nx>=N||ny<0||ny>=M) continue;
				
				
				if(arr[nx][ny]==1) {
					q.offer(new Maze(nx,ny));
					arr[nx][ny]=arr[x][y]+1;
				}
			}
		}
		
	}
}

class Maze{
	int x;
	int y;
	
	public Maze(int x, int y) {
		this.x=x;
		this.y=y;
	}
}