import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;


public class Program {
	Ans countInversion(int A[],int p, int r){
		Ans a12=new Ans();
		if(p<r){
			int q=(p+r)/2;
			Ans aa1=countInversion(A,p,q);
			Ans aa2=countInversion(A,q+1,r);
			Ans aa3=merge(aa1.getAr(),aa2.getAr());
			int[] aaTempe=aa3.getAr();
			long cp= aa3.getCount()+aa2.getCount()+aa1.getCount();
			a12.setAr(aaTempe);
			a12.setCount(cp);
			return a12;
		}else{
			int[] are= Arrays.copyOfRange(A, p, p+1);
			a12.setAr(are);
			a12.setCount(0);
			return a12;
		}
	}
	// Merge implementation
	Ans merge(int[] a1,int[] a2 ){
		Ans aa=new Ans();
		int counter=0;
		int length= a1.length+a2.length;
		int[] ar1=new int[a1.length+1];
		int[] ar2=new int[a2.length+1];
		ar1[a1.length]=100001;
		ar2[a2.length]=100001;
		int[] arree=new int[length];
		// creating new array with infinity
		// copying elements to array-1
					for(int i=0;i<a1.length;i++){
						ar1[i]=a1[i];
					}
					// copying elements to array-2
								for(int i=0;i<a2.length;i++){
									ar2[i]=a2[i];
								}
		int i=0;
		int j=0;
		for(int k=0;k<length;k++){				
			if(ar1[i]<=ar2[j]){
				arree[k]=ar1[i];
				i++;				
			}else{
				arree[k]=ar2[j];
				j++;				
				counter=counter+ar1.length-i-1;				
			}				
		}
		aa.setAr(arree);
		aa.setCount(counter);
		return aa;
	}
	public static void main(String[] args){
		try{
		BufferedReader br = new BufferedReader(new FileReader("C:/Users/srinath/Desktop/Amazon/Design_analysis/week_1/IntegerArray.txt"));		
		int[] arr=new int[100000];
		for(int i=0;i<100000;i++){
			arr[i]=Integer.parseInt(br.readLine());
		}		
		Program pp=new Program();
		Ans a=pp.countInversion(arr,0,arr.length-1);//pp.merge(arr1, arr2);
		System.out.println(a.getAr()[5]);
		System.out.println(a.getCount());
		}catch(Exception e){
			System.out.println(e);
		}
		
	}

}
