package com.Level2.Arrays.Examples;

import java.util.ArrayList;
import java.util.List;

// This class print elements in spiral order
public class Solution {
	

	/**
	 * Algorithm: top-most row-> right-most column ->bottom-most row -> left most column
	 * @param a
	 * @return
	 */
	public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
		 ArrayList<Integer> result = new ArrayList<Integer>();
		 int l=0; // left-most column
		 int r=a.get(0).size()-1; //right-most column
		 int t=0; //top most row
		 int b=a.size()-1; //bottom-most row
		 int dir=0;
		 while(l<=r && t<=b){
			 if(dir==0){
				 for(int i=l;i<=r;i++){
					 result.add(a.get(t).get(i));					 
				 }
				 t++;
			 }
			 else if(dir==1){
				 for(int i=t;i<=b;i++){
					 result.add(a.get(i).get(r));
				 }
				 r--;
			 }
			 else if(dir==2){
				 for(int i=r;i>=l;i--){
					 result.add(a.get(b).get(i));	
				 }
				 b--;
			 }
			 else if(dir==3){
				 for(int i=b;i>=t;i--){
					 result.add(a.get(i).get(l));
				 }
				 ++l;
			 }
			 dir=(dir+1)%4;
		 }
		 // Populate result;
		 return result;
	}
	
	public static void main(String[] args){
		Solution ss=new Solution();		
		 ArrayList<Integer> q1=new ArrayList<Integer>();
		 ArrayList<Integer> q2=new ArrayList<Integer>();
		 ArrayList<Integer> q3=new ArrayList<Integer>();
		 List<ArrayList<Integer>> w=new ArrayList<>();
		q1.add(new Integer(1));
		q1.add(new Integer(2));
		q2.add(new Integer(3));
		q2.add(new Integer(4));
		q2.add(new Integer(5));
		q2.add(new Integer(6));
		q3.add(new Integer(7));
		q3.add(new Integer(8));
		q3.add(new Integer(9));
		w.add(q1);
		w.add(q2);
		w.add(q3);	
		//above test-case
		ss.spiralOrder(w);		
		
	}

}
