import java.util.Random;
import java.util.Scanner;
public class Calculation{	
	private static int[] midVal= new int[1024];	
	private static double Total=0;	
	private static double defRoVal=-1;
	//private static int[][] backUp= new int[1024][10];
	private static int[] shuffle= new int[51];	
	private static int[][] connection= new int[1024][10];	
	
	public static void main(String[] args){	
		//System.out.println("Enter the number number of nodes and links");
		System.out.println("Prob"+"\t"+"Reli");
		reliability(0,0);
		//test
		/**
		 * System.out.println();
		System.out.println("Test");
		for(int i=0;i<1024;i++){
			System.out.println(midVal[i]);
		}
		 */
		
		/**
		 * Second part
		 */
		//backUp = connection;		
		System.out.println();
		System.out.println("K"+"\t"+"Reli");
		Random rn = new Random();
		defaultShuffleSet();
		for(int k = 0 ;k<=50;k++){
		// showing dependency on k, in the range k = 0, 1, 2, 3, . . . , 50			 
			for(int i=0;i<=k;i++){
				shuffle[i]= rn.nextInt(1024);
			}				
								
			build2ndconnection();
			reliability(1,k);	
			//connection = backUp;
			//for(int i=0;i<=k;i++)
				//shuffle[i] = -1;
		}
	}

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
	
	public static void defaultShuffleSet(){
		for(int index=0;index<51;index++){
			shuffle[index] =-1;
		}
	}
	public static int[][] SetLinks(int[][] connection){
		int inter=0;
		for(int a=0;a<=1;a++){
			for(int b=0;b<=1;b++){				
				for(int c=0;c<=1;c++){
					for(int d=0;d<=1;d++){
						for(int e=0;e<=1;e++){
							for(int f=0;f<=1;f++){
								for(int g=0;g<=1;g++){
									for(int h=0;h<=1;h++){
										for(int i=0;i<=1;i++){
											for(int j=0;j<=1;j++){
												connection[inter][0]=a;
												connection[inter][1]=b;
												connection[inter][2]=c;
												connection[inter][3]=d;
												connection[inter][4]=e;
												connection[inter][5]=f;
												connection[inter][6]=g;
												connection[inter][7]=h;
												connection[inter][8]=i;
												connection[inter][9]=j;
												inter++;
												}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return connection;
	}
	private static double reliability(int mode,int a){		
		float am = (float) 1.0;
		float wr = (float) 0.0;
		Total=0;
		if(mode == 0){
			connection=SetLinks(connection);
			midVal=CalculateUpandDown(connection);
		}
		else{
			wr=(float) 0.9;
			am = (float) 0.9;
			midVal=CalculateUpandDown(connection);
		}
				
		
		for(float i=wr;i<=am;i=(float) (i+0.025)){
			int pos=0;
			int neg=0;
			for(int j=0;j<1024;j++){
				if(midVal[j]!=0){					
					for(int k=0;k<10;k++){
						if(connection[midVal[j]][k]==1){
							pos++;
							if(defRoVal==-1){
								defRoVal=i;
							
							}								
							else{
								defRoVal=defRoVal*i;
							}								
						}
						else{
							neg++;
							if(defRoVal==-1){
								defRoVal=(1-i);
							}								
							else{
								defRoVal=defRoVal*(1-i);
							}
								
						}
					}
					Total+=defRoVal;
					defRoVal=-1;
				}
			}
			if(mode==0){
			System.out.println(i+"\t"+Total);
			}
			else{
				System.out.println(a+"\t"+Total);	
			}
						
			Total =0;
		}
		System.out.print(" ");
		return Total;
	}


	public static int[] CalculateUpandDown(int[][] connection){
		int [] midVal= new int[1024];
		 int counter=0;	 
		 for(int i=0;i<1024;i++){
		  midVal[i]=0;
		 }	 
		 for(int i=0;i<1024;i++){
		  int [] checkmatrix= new int[5];	     
		     for(int k=0;k<5;k++){
		    	 checkmatrix[k]=-1;
		     }  
		     
		  if(connection[i][0]==1){
		   checkmatrix[0]=0;
		   checkmatrix[1]=1;
		  }
		  if(connection[i][1]==1)
		  {
		   checkmatrix[0]=0;
		   checkmatrix[2]=2;
		  }
		  if(connection[i][2]==1)
		  {
		   checkmatrix[0]=0;
		   checkmatrix[3]=3;
		  }
		  if(connection[i][3]==1)
		  {
		   checkmatrix[0]=0;
		   checkmatrix[4]=4;
		  }
		  if(connection[i][4]==1)
		  {
		   checkmatrix[1]=1;
		   checkmatrix[2]=2;
		  }
		  if(connection[i][5]==1)
		  {
		   checkmatrix[1]=1;
		   checkmatrix[3]=3;
		  }
		  if(connection[i][6]==1)
		  {
		   checkmatrix[1]=1;
		   checkmatrix[4]=4;
		  }
		  if(connection[i][7]==1)
		  {
		   checkmatrix[2]=2;
		   checkmatrix[3]=3;
		  }
		  if(connection[i][8]==1)
		  {
		   checkmatrix[2]=2;
		   checkmatrix[4]=4;
		  }
		  if(connection[i][9]==1)
		  {
		   checkmatrix[3]=3;
		   checkmatrix[4]=4;
		  }
		  
		  int count=0;
		  
		  for(int j=0;j<5;j++)
		  {
		   count+=checkmatrix[j];
		  }
		  
		  if(count==10)
		  {
		   midVal[counter]=i;	   
		   
		   counter++;
		  }
		  
		  }
		 
		 return midVal;
	}
}

 
