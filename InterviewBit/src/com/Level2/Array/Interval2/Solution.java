package com.Level2.Array.Interval2;

import java.util.ArrayList;

public class Solution {	
	 
	  public class Interval {
	      int start;
	      int end;
	     Interval() { 
	    	 start = 0; 
	    	 end = 0; 
	    	 }
	      Interval(int s, int e) {
	    	  start = s; 
	    	  end = e; 
	    	  }
	  }
	  public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		  int i=0;
		  while(i<intervals.size()-1){
			  if((intervals.get(i).end>=intervals.get(i+1).start)&&(intervals.get(i+1).end>intervals.get(i).end)){				  
				  int te=intervals.get(i).start;
				  if(intervals.get(i).start<intervals.get(i+1).start){
					 te=intervals.get(i+1).start;
				  }
				  Interval t1=new Interval(te,intervals.get(i+1).end); 
				  intervals.set(i, t1);
				  intervals.remove(i+1);				  
			  }
			  else if((intervals.get(i).end>=intervals.get(i+1).start)&&(intervals.get(i+1).end<=intervals.get(i).end)){
				  int te=intervals.get(i).start;
				  if(intervals.get(i).start<intervals.get(i+1).start){
					 te=intervals.get(i+1).start;
				  }
				  Interval t1=new Interval(te,intervals.get(i).end);
				  intervals.set(i, t1);
				  intervals.remove(i+1);
			  }else{
				  i++;
			  }
		  }
		  return intervals;
	  }
	  
	  public static void main(String[] args){}
	 

}
