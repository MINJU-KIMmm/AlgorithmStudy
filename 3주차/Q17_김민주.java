package Ch3_DfsBfs;

import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer; 
public class Q17_김민주  {
    static int N, K, arr[][], X, Y, S;
    static PriorityQueue<Point> pq;
    static int dr[] = {-1,1,0,0};
    static int dc[] = {0,0,-1,1};
    static class Point implements Comparable<Point>{
    	int x;
    	int y;
    	int v;
    	
    	public Point(int x, int y, int v) {
    		this.x=x;
    		this.y=y;
    		this.v=v;
    	}
    	
    	@Override
    	public int compareTo(Point o) {
    		return this.v-o.v;
    	}
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        N = Integer.parseInt(st.nextToken()); 
        K = Integer.parseInt(st.nextToken()); 
        arr = new int[N][N];
        pq = new PriorityQueue<>();
        
        for (int i = 0; i < N; i++) { 
            st = new StringTokenizer(br.readLine()); 
            for (int j = 0; j < N; j++) { 
                arr[i][j] = Integer.parseInt(st.nextToken());
    			if(arr[i][j]!=0) pq.add(new Point(i,j,arr[i][j]));

            } 
        } 
        st = new StringTokenizer(br.readLine()); 
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken())-1; 
        Y = Integer.parseInt(st.nextToken())-1;
        
        while(S-->0) {
        	bfs();
        }
        
        System.out.println(arr[X][Y]); 
    } 
    
    static void bfs() { 
    	PriorityQueue<Point> tmp = new PriorityQueue<>(); 
        

    	
        while(!pq.isEmpty()) { 
            Point cur = pq.poll(); 
            for(int i=0; i<4; i++) { 
                int nx = cur.x+dr[i]; 
                int ny = cur.y+dc[i]; 
                if(nx<0 || nx>=N || ny<0 ||ny>=N || arr[nx][ny]!=0) continue; 
                arr[nx][ny] = cur.v;
                tmp.add(new Point(nx,ny,cur.v)); 
            }
        }
        
       pq = tmp;
    }
}