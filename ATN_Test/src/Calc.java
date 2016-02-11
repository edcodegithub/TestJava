import java.util.Random;
import java.util.Scanner;

public class Calc {
	public static int[][] connection=new int[1024][10];
	private static int[] shuffle= new int[51];
	/**
	 * Decimal to String conversion.Used to convert 10 edges to 10-bit 
	 * binary number varying from 0 to 1023. 
	 */
	
	public static String decToString(int number,int length){
		String ans=null;
		try{
			int a= number;
			String tem="0000000000";
			String b=Integer.toBinaryString(a);
			 ans=b;
			int len=b.length();
			if (len < length)
				  ans = tem.substring(0, length-len).concat(ans);
				else
				  ans = ans.substring(len - 10);			
			}catch(Exception e){
				System.out.println("plz enter integer value");
			}
		return ans;
		
	}
	/**
	 * 10 links can have 2^10 states. We convert it to 10 bit binary and store it in an 
	 * array of lenth 10. So we need a 2D array.
	 */
	public static int[][] connect(int[][] connection){
		for(int i=0;i<1024;i++){
			String temp=decToString(i,10);
			for(int j=0;j<10;j++){
				String we=temp.charAt(j)+"";
				int a=Integer.parseInt(we);
				connection[i][j]=a;				
			}
			
		}
		return connection;
		}
	/**
	 * Method used to print a 2D array. Used the func.
	 * to check intermiate values.
	 * @param arr
	 */
	public static void prinfTwoDarr(int[][] arr){
		int jlen=arr[0].length;
		int iLen=arr.length;		
		for(int i = 0; i<iLen; i++)
		{
		    for(int j = 0; j<jlen; j++)
		    {
		        System.out.print(arr[i][j]+" ");
		    }
		    System.out.println();
		}
	}
	/**
	 * Method used to set a default value -1 to each
	 * element in  the shuffle set.
	 */
	
	public static void defaultShuffleSet(){
		for(int index=0;index<51;index++){
			shuffle[index] =-1;
		}
	}
	/**
	 * checkConnect method is used to check the connectivity of
	 * a graph. It stores all states which are connected. 
	 */
	
	public static int[] checkConnect(int[][] connection){
		int index=0;
		int [] connEdge= new int[1024];	// Array that has list of connected edges	 	 
		 for(int i=0;i<1024;i++){
		  connEdge[i]=0;
		 }	 
		 for(int i=0;i<1024;i++){
		  int [][] tem2dMat= new int[5][5];		  	 			  
			  
		  tem2dMat[0][0]=tem2dMat[1][1]=tem2dMat[2][2]=tem2dMat[3][3]=tem2dMat[4][4]=0;
		  
		  tem2dMat[0][1]=tem2dMat[1][0]=connection[i][0];
		  tem2dMat[0][2]=tem2dMat[2][0]=connection[i][1];
		  tem2dMat[0][3]=tem2dMat[3][0]=connection[i][2];
		  tem2dMat[0][4]=tem2dMat[4][0]=connection[i][3];
		  
		  tem2dMat[1][2]=tem2dMat[2][1]=connection[i][4];
		  tem2dMat[1][3]=tem2dMat[3][1]=connection[i][5];
		  tem2dMat[1][4]=tem2dMat[4][1]=connection[i][6];
		  
		  tem2dMat[2][3]=tem2dMat[3][2]=connection[i][7];
		  tem2dMat[2][4]=tem2dMat[4][2]=connection[i][8];
		  
		  tem2dMat[3][4]=tem2dMat[4][3]=connection[i][9];
		  //Calculating for discontinuity
		  int set=0;
		  for(int a=0;a<5;a++){
			  int total=0;			  
			  for(int b=0;b<5;b++){
				  total=total+tem2dMat[a][b];
			  }
			  if(total==0){
				  set=1;
				  break;
			  }
		  }			  
		  if(set==0){			 
			  connEdge[index]=i;
			  index++;
		  }
		  
		  }
		 
		 return connEdge;
	}
	
	/**
	 * Calculating Reliablility for part-1
	 */
	public static void pReliablity() //a and b is the range in which we want to vary the probability
	{
		
		for(float i=0;i<1.0;i=(float) (i+0.025)){			
			int[][] r=connect(connection);
			int [] e=checkConnect(r);
			double defRoVal=-1; // default row value
			float reli=0;
			for(int at=0;at<1024;at++){
				// if condition written to exit when we get zeros in the array
				if(e[at]!=0){					
					for(int k=0;k<10;k++){
						if(connection[e[at]][k]==1){							
							if(defRoVal==-1){
								defRoVal=i;							
							}								
							else{
								defRoVal=defRoVal*i;
							}								
						}
						else{
							
							if(defRoVal==-1){
								defRoVal=(1-i);
							}								
							else{
								defRoVal=defRoVal*(1-i);
							}								
						}
					}
					reli+=defRoVal;
					defRoVal=-1;				
				}								
			}
			System.out.println(i+"\t"+reli);
		}
	}
	/**
	 * Building 2nd connection by shuffling
	 * @param args
	 */
	private static void build2ndconnection(){
		int i,j = 0;	
		for(i=0;i<51;i++){
		if(shuffle[i] != -1){
			for(j=0;j<10;j++){
			if(connection[shuffle[i]][j] == 0)
				connection[shuffle[i]][j] = 1;
			else
				connection[shuffle[i]][j] = 0;
			}	
		}
		}
	}
	/**
	 * 2nd part. Finding kReliability
	 * @param args
	 */
	public static float kReliablity(float p,int a) //a and b is the range in which we want to vary the probability
	{
		float qw=0;
		
		    float i=(float) p;			
			int [] e=checkConnect(connection);
			double defRoVal=-1; // default row value
			float reli=0;
			for(int at=0;at<1024;at++){
				// if condition written to exit when we get zeros in the array
				if(e[at]!=0){					
					for(int k=0;k<10;k++){
						if(connection[e[at]][k]==1){							
							if(defRoVal==-1){
								defRoVal=i;							
							}								
							else{
								defRoVal=defRoVal*i;
							}								
						}
						else{
							
							if(defRoVal==-1){
								defRoVal=(1-i);
							}								
							else{
								defRoVal=defRoVal*(1-i);
							}								
						}
					}
					reli+=defRoVal;
					defRoVal=-1;				
				}								
			}
			qw=reli;
			
		return qw;
	}
	
	public static void main(String[] args){
		System.out.println("p"+"\t"+"Reli");
		pReliablity();
		//Calculate second part
		System.out.println();
		System.out.println("K"+"\t"+"Reli");
		Random rn = new Random();
		defaultShuffleSet();
		float[] ans=new float[51];
		// clearing ans
		for(int i = 0 ;i<=50;i++){
			ans[i]=0;
		}
		//running 50 times and averaging the answer.
		for(int j = 0 ;j<=20;j++){
			for(int k = 0 ;k<=50;k++){
				// showing dependency on k, in the range k = 0, 1, 2, 3, . . . , 50			 
					for(int i=0;i<=k;i++){
						shuffle[i]= rn.nextInt(1024);
					}				
										
					build2ndconnection();
					
					ans[k]=ans[k]+kReliablity((float) 0.9,k);
					if(j==20){
						ans[k]=(ans[k]+kReliablity((float) 0.9,k))/20;
					}
					
				}
			
		}
		
		//print 2nd part
		for(int i = 0 ;i<=50;i++){
			System.out.println(i+"\t"+ans[i]);
		}
		
	}

}
