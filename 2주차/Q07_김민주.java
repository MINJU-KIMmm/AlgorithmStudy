package Ch2_Implementation;

import java.io.*;
import java.util.*;
public class Q07_김민주 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String N=br.readLine();
		
		int half=N.length()/2;

		int first=0;
		int second=0;
		for(int i=0;i<N.length();i++) {
			if(i<half) {
				first+=N.charAt(i)-'0';
			}
			else {
				second+=N.charAt(i)-'0';
			}
		}
		
		if(first==second) System.out.println("LUCKY");
		else System.out.println("READY");
	}

}
