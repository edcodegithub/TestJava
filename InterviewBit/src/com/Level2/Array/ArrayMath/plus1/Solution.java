package com.Level2.Array.ArrayMath.plus1;


import java.util.ArrayList;
import java.util.Arrays;


public class Solution {
	public static ArrayList<Integer> plusOne(ArrayList<Integer> a) {
		int c=1;
		int index=0;
		ArrayList<Integer> arr=new ArrayList<>();
		for(int i=0;i<a.size();i++){
			if(a.get(i)>0){				
				index=i;
				break;
			}
			}
			for(int j=a.size()-1;j>=index;j--){
				Integer t=a.get(j)+c;
				//System.out.println(t-c);
				int temp=t%10;
				c=t/10;
				arr.add(0,temp);
			}	
			if(c>0){
				arr.add(0,c);;
			}
		
		return arr;	    
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Integer[] s={new Integer(0),new Integer(4),new Integer(2),new Integer(9)};
			ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(s));			
			
			System.out.println(plusOne(arrayList));
	}

}
