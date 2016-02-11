package com.Level2.ProblemsMaxSubArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
	/**
	 * Given an array of integers, sort the array into a wave like array and return it, 
       In other words, arrange the elements into a sequence such that 
       a1 >= a2 <= a3 >= a4 <= a5.....
	 * @param a
	 * @return
	 */
	public ArrayList<Integer> wave(ArrayList<Integer> a) {
		ArrayList<ArrayList<Integer>> b=new ArrayList<ArrayList<Integer>>(); 
		//b.add(0, new Integer(1));
		Collections.sort(a);
		for(int i=0;i<a.size()-1;i++){
			if(i%2==0&&a.get(i)<a.get(i+1)){
				Integer temp=a.get(i);
				a.set(i, a.get(i+1));
				a.set(i+1, temp);
			}
			else if(i%2==1&&a.get(i)>a.get(i+1)){
				Integer temp=a.get(i);
				a.set(i, a.get(i+1));
				a.set(i+1, temp);
			}
		}
		return a;
	}
	

	public int maxSubArray(final List<Integer> a) {
	    int maxTill=Integer.MIN_VALUE;//a.get(0);
	    int maxUlti=Integer.MIN_VALUE;//a.get(0);
	    for(int i=0;i<a.size();i++){
	        if(maxTill<0){
	            maxTill=a.get(i);
	        }else{
	            maxTill=Math.max(a.get(i),maxTill+a.get(i));
	        }
	       // maxTill=Math.max(a.get(i),maxTill+a.get(i));
	        maxUlti=Math.max(maxUlti,maxTill);
	    }
	    return maxUlti;
	    
	}
	//test
	public static void main(String[] args){
		Solution ss=new Solution();
	}
}
