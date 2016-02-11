package stickerball_game;

public class Test {
	
	public static int method(int[][] a,int x, int y,int n){
		
		
		if(x==0 && y==0){
			n++;
		}
		if(a[x][y]==0){
			return n;
		}
		else{
		if(x>=1&&y>=0)	
		 n=method(a,x-1, y,n);
		if(y>=1&&x>=0)
		 n=method(a,x, y-1,n);		
		}
		return n;
		
		
		
		
	}
	
	public static void main(String[] args){
		int[][] multi = new int[][]{
				  { 1, 1, 1, 1,1 },
				  { 1, 1, 1, 1,1 },
				  { 1, 1, 1, 1,1 },
				  { 1, 1, 1, 1,1 },
				  { 1, 1, 1, 1,1 }
				  
				};
		for(int i=0; i<3;i++){
			for(int j=0;j<3;j++){
				System.out.print(multi[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println(Test.method(multi, 4, 4,0));
	}

}
