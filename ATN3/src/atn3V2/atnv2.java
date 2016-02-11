package atn3V2;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Arrays;

 

public class atnv2

{
	static int[] temp= new int[1000];
	
	static double sum=0;
	
	static double rowProb=-1;
		
	static int[][] linkMatrix= new int[1024][10];
		
	static int[][] ReflinkMatrix= new int[1024][10];
	
	static int[][] CmplinkMatrix= new int[1024][10];
	
	static int[] randomArray= new int[100];
	
	static int flag = 0;

	private static PrintWriter output;

	
public static void main(String[] args) throws IOException
{
	output = new PrintWriter("C:/Users/srinath/Desktop/output.txt");
	output.flush();
	output.println("\nOutput:\n");
	int k,i;
	
	for(i=0;i<100;i++)
		randomArray[i] =-1;
	reliability();

ReflinkMatrix = linkMatrix;

flag = 1;

for( k = 0 ;k<=50;k++){
//	System.out.print("Reliablity for "+k+ ":");
	for(i=0;i<=k;i++)
		randomArray[i] = (int)(Math.random()*1024);
	buildNewLinkMatrix();

	output.println(reliability());
	//test
	//System.out.println(reliability());
	linkMatrix = ReflinkMatrix;
	for(i=0;i<=k;i++)
		randomArray[i] = -1;
}
output.close();
}

private static void buildNewLinkMatrix() {

	int i,j = 0;
	
	for(i=0;i<100;i++){
	if(randomArray[i] != -1){
		for(j=0;j<10;j++){
//		System.out.println("#########");
//		System.out.println("I = " +randomArray[i]);
		if(linkMatrix[randomArray[i]][j] == 0)
			linkMatrix[randomArray[i]][j] = 1;
		else
			linkMatrix[randomArray[i]][j] = 0;
		}	
	}
	}
}
public static int[][] SetLinks(int[][] linkMatrix)

{

int ArrCnt=0;

for(int a=0;a<=1;a++)

{

for(int b=0;b<=1;b++)

{

for(int c=0;c<=1;c++)

{

for(int d=0;d<=1;d++)

{

for(int e=0;e<=1;e++)

{

for(int f=0;f<=1;f++)

{

for(int g=0;g<=1;g++)

{

for(int h=0;h<=1;h++)

{

for(int i=0;i<=1;i++)

{

for(int j=0;j<=1;j++)

{

linkMatrix[ArrCnt][0]=a;

linkMatrix[ArrCnt][1]=b;

linkMatrix[ArrCnt][2]=c;

linkMatrix[ArrCnt][3]=d;

linkMatrix[ArrCnt][4]=e;

linkMatrix[ArrCnt][5]=f;

linkMatrix[ArrCnt][6]=g;

linkMatrix[ArrCnt][7]=h;

linkMatrix[ArrCnt][8]=i;

linkMatrix[ArrCnt][9]=j;

ArrCnt++;

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

return linkMatrix;

}
private static double reliability() throws IOException {
	
sum=0;

float q = (float) 1.0;
float p = (float) 0.0;
if(flag == 0)
linkMatrix=SetLinks(linkMatrix);


temp=CalculateUpandDown(linkMatrix);


DecimalFormat df2 = new DecimalFormat("###.####");

if(flag != 0 ){
	p=(float) 0.9;
	q = (float) 0.9;
}
for(double i=p;i<=q;)

{

for(int j=0;j<1000;j++)

{

if(temp[j]!=0)

{

for(int k=0;k<10;k++)

{

if(linkMatrix[temp[j]][k]==1)

{

if(rowProb==-1)

rowProb=i;

else

rowProb=rowProb*i;

}

else

{

 

if(rowProb==-1)

rowProb=(1-i);

else

rowProb=rowProb*(1-i);

}

}

sum+=rowProb;

rowProb=-1;

}

}

System.out.println("Prob: "+i+"\t Reliablility: "+sum);

i=i+0.025;

Double iq=Double.valueOf(df2.format(i));
i=Double.parseDouble(iq.toString())+0.0000;
sum =0;

}

System.out.print(" ");

return sum;
}


public static int[] CalculateUpandDown(int[][] linkMatrix) throws IOException

{

	 FileWriter fw= new FileWriter(new File(".//check.txt"),true);
	 
	 int [] temp= new int[1024];
	 int counter=0;
	 
	 for(int i=0;i<1024;i++)
	 {
	  temp[i]=0;
	 }
	  
	 
	 
	 for(int i=0;i<1024;i++)
	 {
	  int [] checkmatrix= new int[5];
	     
	     for(int k=0;k<5;k++)
	      checkmatrix[k]=-1;
	     
	  if(linkMatrix[i][0]==1)
	  {
	   checkmatrix[0]=0;
	   checkmatrix[1]=1;
	  }
	  if(linkMatrix[i][1]==1)
	  {
	   checkmatrix[0]=0;
	   checkmatrix[2]=2;
	  }
	  if(linkMatrix[i][2]==1)
	  {
	   checkmatrix[0]=0;
	   checkmatrix[3]=3;
	  }
	  if(linkMatrix[i][3]==1)
	  {
	   checkmatrix[0]=0;
	   checkmatrix[4]=4;
	  }
	  if(linkMatrix[i][4]==1)
	  {
	   checkmatrix[1]=1;
	   checkmatrix[2]=2;
	  }
	  if(linkMatrix[i][5]==1)
	  {
	   checkmatrix[1]=1;
	   checkmatrix[3]=3;
	  }
	  if(linkMatrix[i][6]==1)
	  {
	   checkmatrix[1]=1;
	   checkmatrix[4]=4;
	  }
	  if(linkMatrix[i][7]==1)
	  {
	   checkmatrix[2]=2;
	   checkmatrix[3]=3;
	  }
	  if(linkMatrix[i][8]==1)
	  {
	   checkmatrix[2]=2;
	   checkmatrix[4]=4;
	  }
	  if(linkMatrix[i][9]==1)
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
	   temp[counter]=i;
	   fw.write(counter+ " ");
	   //System.out.print(counter+ " ");
	   counter++;
	  }
	  
	  }
	 fw.write("\n");
	 fw.close();
	 return temp;

	
}

}

 
