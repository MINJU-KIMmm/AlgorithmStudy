import java.util.*;
import java.io.*;
public class 실전2_김민주 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        int[][] arr=new int[N][M];
        int[] minArr=new int[N];

        for(int i=0;i<N;i++) {
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                arr[i][j]=Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr[i]);
            minArr[i]=arr[i][0];
        }

        Arrays.sort(minArr);

        System.out.println(minArr[minArr.length-1]);
    }

}
