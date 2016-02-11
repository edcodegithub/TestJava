import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


public  class Sort1 {
	public static long count=0;
	public static int[] quickSort(int[] ar,int l, int r){		
		if(ar.length==1){
			return ar;
		}
		if(l<r){
		int p= Sort1.partition(ar, l, r);
		count=count+r-l+1-1;
		quickSort(ar, l,p-1);		
		quickSort(ar, p+1,r);		
		}
		return ar;
	}
	public static int leftpivot(int[] ar,int l, int r){
		return l;
	}
	public static int rightpivot(int[] ar,int l, int r){
		//exchange
				int temp11=ar[l];
				ar[l]=ar[r];
				ar[r]=temp11;
				//end
		return l;
	}
	public static int medianpivot(int[] ar,int l, int r){
		// median-of-three rule
				int a= r-l+1;
				int mid;
				if(a%2==0){
					mid=l+(a/2)-1;
				}else{
					mid=l+(a/2);
				}
				int[] comp=new int[3];
				comp[0]=ar[l];
				comp[1]=ar[mid];
				comp[2]=ar[r];
				int index=l;
				Arrays.sort(comp);
				if(comp[1]==ar[l]){
					index=l;
				}else if(comp[1]==ar[mid]){
					index=mid;
				}else if(comp[1]==ar[r]){
					index=r;			
				}
				int temp11=ar[l];
				ar[l]=ar[index];
				ar[index]=temp11;
				//end of 3-median
		return l;
	}
	public static int partition(int[] ar,int l, int r){
		
		
		int pivot= ar[rightpivot(ar,l,r)];
		int i=l+1;
		for(int j=l+1; j<=r;j++){
			if(ar[j]<pivot){
				int temp=ar[i];
				ar[i]=ar[j];
				ar[j]=temp;
				i++;
			}
		}
		int temp1=ar[i-1];
		ar[i-1]=pivot;
		ar[l]=temp1;
		return i-1;
	}
	//second method- According to corman
	public static int partition1(int[] ar,int l, int r){
		int pivot= ar[r];
		int i=l-1;//l;
		for(int j=l; j<r;j++){
			if(ar[j]<pivot){
				i++;
				int temp=ar[i];
				ar[i]=ar[j];
				ar[j]=temp;
				//i++;
			}
		}
		int temp1=ar[i+1];
		ar[i+1]=pivot;
		ar[r]=temp1;
		return i+1;
	}
	
	public static void main(String[] args){		
		
		try {
			BufferedReader br=new BufferedReader(
					new FileReader("C:/Users/srinath/Desktop/Amazon/Design_analysis/week_2/QuickSort.txt"));
			int[] arr=new int[10000];
			int[] arr1={3,8,2,5,1,4,7,6};
			String line=null;
			int i=0;
			
			//loading the array
			while((line=br.readLine())!=null){				
				arr[i]=Integer.parseInt(line);				
				i++;
			}
			
			
			for(int it: Sort1.quickSort(arr, 0, arr.length-1)){
				System.out.println(it);
			}
			System.out.println(Sort1.count);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
