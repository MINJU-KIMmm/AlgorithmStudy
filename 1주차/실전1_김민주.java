import java.util.*;
public class 실전1_김민주 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		int M=sc.nextInt();
		int K=sc.nextInt();
		
		int[] arr=new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int first=arr[N-1];
		int second=arr[N-2];
		
		int answer=0;
//		while(M>0) {
//			for(int i=0;i<K;i++) {
//				if(M<=0) break;
//				answer+=first;
//				M--;
//			}
//			
//			if(M<=0)break;
//			
//			answer+=second;
//			M--;
//		}
//		System.out.println(answer);
		
		//수식 이용해서 구하기 
		//수열이 (K+1)단위로 반복 -> M/(K+1) = 반복되는 횟수
//		answer=0;
		
		int n=M/(K+1);
		int r=M%(K+1);
		
		//first가 더해지는 총 횟수 계산
		int count=n*K+r;
		
		answer+=count*first;
		answer+=(M-count)*second;
		
		
		System.out.println(answer);
	}

}
