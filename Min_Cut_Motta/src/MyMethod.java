import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;


public class MyMethod {
	public static Integer myAlgo(ArrayList<Integer>[] arr_arlist,int size){
		
		/**
		 * Selecting Random edges
		 */
		/* Enter size*/
		ArrayList<Integer>[] att=arr_arlist;
		int count=size;
		while(count>2){
			
			Random rn = new Random();			
			int tail_index=rn.nextInt(count);	//index	of tail		
			
			int tail_value=att[tail_index].get(0);
			/**
			 * System.out.println(tail_value);//tail 
			*/
			int y=1+rn.nextInt(att[tail_index].size()-1); //head
			
			int head_value=att[tail_index].get(y);
			int head_index=head_value-1; //index of head
			for(int f=0;f<count;f++){
				if(att[f].get(0)==head_value){
					head_index=f;
					break;
				}
			}
			/*System.out.println(head_value);*/
		
			
			//Delete all edges tail,head from both arraylists
			for(int w=1;w<att[tail_index].size();w++){
				if(att[tail_index].get(w)==head_value){
					att[tail_index].remove(w);
					w=w-1;
					//System.out.println("remove from tail_index"+" headvalue: "+head_value+" index: "+w+" index_size: "
					//+att[tail_index].size()+" tail_index:"+tail_index); 
				}
			}
			
			
			for(int u=1;u<att[head_index].size();u++){
				if(att[head_index].get(u)==tail_value){
					att[head_index].remove(u);
					u=u-1;
					//System.out.println("remove from head_index"+" tailvalue: "+tail_value+" index: "+u+" index_size: "
						//	+att[head_index].size()+" head_index:"+head_index); 
				}
			}
			
			//Merging of head with tail
			ArrayList<Integer> ar1;
			if(tail_value<head_value){
				for(int w=1;w<att[head_index].size();w++){						
						att[tail_index].add(att[head_index].get(w));					
				}
				 ar1=att[head_index];
				att[head_index]=att[count-1];
				att[count-1]=ar1;
				// Updating head_value by tail_value
				for(int r=0;r<count-1;r++){
					for(int e=1;e<att[r].size();e++){
						if(att[r].get(e)==head_value && r!=tail_index){
							att[r].set(e, tail_value);
						}
					}
				}
			}
			//tail_value>head_value
			else if(tail_value>head_value){
				for(int w=1;w<att[tail_index].size();w++){						
					att[head_index].add(att[tail_index].get(w));					
				}
				ar1=att[tail_index];
				att[tail_index]=att[count-1];
				att[count-1]=ar1;
				// Updating tail_value by head_value
				for(int r=0;r<count;r++){
					for(int e=1;e<att[r].size();e++){
						if(att[r].get(e)==tail_value && r!=head_index){
							att[r].set(e, head_value);
						}
					}
				}
				//trmoving loops
				
			}
			
			count--;				
			
		}
		
		
		//printing min-cut
		//System.out.println(att[0].size()-1==att[1].size()-1);
		System.out.println(att[1].size()-1+" is the temp min cut");
		return att[0].size()-1;		
	}
	
	public static ArrayList<Integer>[] copyArray(ArrayList<Integer>[] arr){
		//copy
		ArrayList<Integer>[] copy=new ArrayList[200] ;				
		for(int qi=0;qi<arr.length;qi++){
			ArrayList<Integer> ne=new ArrayList<>();
			for(int t=0;t<arr[qi].size();t++){
				//copy[qi].set(t, att[qi].get(t));
				ne.add(arr[qi].get(t));
			}
			copy[qi]=ne;
		}
		return copy;
	}
	
	public static void main(String[] args){
		
		try {
			FileReader fr=new FileReader("C:/Users/srinath/Desktop/Amazon/"
					+ "Design_analysis/week_3/kargerMinCut.txt");
			BufferedReader br=new BufferedReader(fr);			
			String sr;
			/* Enter size*/
			ArrayList<Integer>[] att=new ArrayList[200];
			int i=0;
			while((sr=br.readLine())!=null){				
				ArrayList<Integer> ne=new ArrayList<>();
				Scanner sc=new Scanner(sr);
				//int j=sc.nextInt();
				while(sc.hasNextInt()){
					ne.add(sc.nextInt());					
				}
				att[i++]=ne;				
				sc.close();
			}
			br.close();
			Integer answer=999999999;
			for(int ie=0; ie<1000;ie++){
				//copy
				ArrayList<Integer>[] copy=copyArray(att);				
				//end copy
				Integer comp=myAlgo(copy,200);
				if(answer>comp){
					answer=comp;
				}
								
			}
			System.out.println(answer);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
