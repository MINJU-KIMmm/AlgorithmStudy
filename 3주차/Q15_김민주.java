package Ch3_DfsBfs;
import java.util.*;
import java.io.*;
public class Q15_김민주 {
	
	static ArrayList<Integer>[] arr;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		int X=Integer.parseInt(st.nextToken());
		
		arr=new ArrayList[N+1];
		for(int i=0;i<=N;i++) {
			arr[i]=new ArrayList<Integer>();
		}
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			
			arr[x].add(y);
		}
		
		//bfs
		int[] distance=new int[N+1];
		distance[X]=0;
		
		Queue<Integer> q=new LinkedList<>();
		q.offer(X);
		
		while(!q.isEmpty()) {
			int curr=q.poll();
			for(int i=0;i<arr[curr].size();i++) {
				if(distance[arr[curr].get(i)]==0) {
					distance[arr[curr].get(i)]=distance[curr]+1;
					q.offer(arr[curr].get(i));
				}
			}
		}
		
		boolean flag=false;
		for(int i=0;i<=N;i++) {
			if(distance[i]==K && i!=X) {
				System.out.println(i);
				flag=true;
			}
		}
		
		if(!flag) System.out.println(-1);
	}

}
