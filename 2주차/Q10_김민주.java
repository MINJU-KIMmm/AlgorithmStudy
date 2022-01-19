package Ch2_Implementation;

// 73/100 (1, 23~33실패)
public class Q10_김민주 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] key= {{0,0,0},
				{1,0,0},
				{0,1,1}
		};
		
		int[][] lock= {{1,1,1},
				{1,1,0},
				{1,0,1}
		};
		
		System.out.println(solution(key, lock));
	}
	
	public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        int len=lock.length;
        int[][] checkLock=new int[3*len-2][3*len-2];
        
        
        for(int i=0;i<len;i++) {
        	for(int j=0;j<len;j++) {
        		checkLock[len-1+i][len-1+j]=lock[i][j];
        	}
        }
        
        for(int i=0;i<4;i++) {
        	key=rotate(key);
        	
//        	for(int ky=0;ky<key.length;ky++) {
//        		for(int jy=0;jy<key.length;jy++) {
//        			System.out.print(key[ky][jy]);
//        		}
//        		System.out.println();
//        	}
//        	
//        	System.out.println();
        	
        	for(int j=len-key.length;j<2*len-2;j++) {
        		for(int k=len-key.length;k<2*len-2;k++) {
        			isValid(key, checkLock, j, k, len);
        		}
        	}
        	
        }
        
        
        return answer;
    }

	
	//시계방향 90도 
	static int[][] rotate(int[][] key) {
		int[][] newKey=new int[key.length][key.length];
		for(int i=0;i<key.length;i++) {
			for(int j=0;j<key.length;j++) {
				newKey[j][key.length-1-i]=key[i][j];
			}
		}
		
		return newKey;
	}
	
	static boolean isValid(int[][] key, int[][] checkLock, int x, int y, int len) {
		boolean flag=true;
		for(int i=0;i<key.length;i++) {
			for(int j=0;j<key.length;j++) {
				checkLock[x+i][y+j]+=key[i][j];
			}
		}
		
//		for(int i=0;i<checkLock.length;i++) {
//			for(int j=0;j<checkLock.length;j++) {
//				System.out.print(checkLock[i][j]);
//			}
//			
//			System.out.println();
//		}
//		
//		System.out.println();
		for(int i=len-1;i<2*len-1;i++) {
			for(int j=len-1;j<2*len-1;j++) {
				if(checkLock[i][j]!=1) {
					flag=false;
				}
			}
		}
		
		if(!flag) {
			for(int i=0;i<key.length;i++) {
				for(int j=0;j<key.length;j++) {
					checkLock[x+i][y+j]-=key[i][j];
				}
			}
		}
		
		return flag;
	}
	
}
