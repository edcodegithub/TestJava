package com.Arrays.MaxDist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution    {
	public class Ob implements Comparable<Ob> {
		private int value;
		private int index;
		public Ob(int index, int value){
			this.value=value;
			this.index=index;
		}
		public int getValue(){
			return value;
		}
		public int getIndex(){
			return index;
		}
		public void setIndex(int index){
			this.index=index;
		}
		public void setValue(int value){
			this.value=value;
		}
		@Override
		public int compareTo(Ob comparestu) {
			  int compareage=((Ob)comparestu).getValue();
		        /* For Ascending order*/
		        return this.value-compareage;
		}
		
		
	}
	
	/**
	 * O(nLog(n))
	 * @param a
	 * @return
	 */
	public static int maximumGap1(final List<Integer> a) {
		int max=-1;
		Solution ss=new Solution();
		List<Solution.Ob> rr=new ArrayList<Solution.Ob>();
		for(int i=0;i<a.size();i++){
			Solution s=new Solution();
			Solution.Ob ab=s.new Ob(0,0);
			rr.add(i, ab);
		}
		for(int i=0;i<a.size();i++){
			Solution.Ob temp=ss.new Ob(i,a.get(i));
			rr.set(i, temp);
			
		}
		Collections.sort(rr);
		int ind=rr.get(0).getIndex();
		int t=0;
		while(t<rr.size()){
			if(ind<=rr.get(t).getIndex()){
				//System.out.println(rr.get(t).getValue()+" ghj");
				max=Math.max(max, rr.get(t).getIndex()-ind);
				t++;
			}else{
				ind=rr.get(t).getIndex();
			}
		}
		
		return max;
	}
	public static int maximumGap(final List<Integer> a) {
		/*int max=-1;
		for(int i=0;i<a.size();i++){
			for(int j=a.size()-1;j>=i;j--){
				if(a.get(i)<=a.get(j)){
					if(max<j-i){
					    max=j-i;
					}
				}
			}
		}
		return max;*/
		int maxDiff=-1;;
		int[] LMin=new int[a.size()];
		int[] RMax=new int[a.size()];
		LMin[0] = a.get(0);
		for (int i = 1; i < a.size(); ++i)
            LMin[i] = Math.min(a.get(i), LMin[i-1]);
         RMax[a.size()-1] = a.get(a.size()-1);
        for (int j = a.size()-2; j >= 0; --j)
            RMax[j] = Math.max(a.get(j), RMax[j+1]);
        int i = 0, j = 0;
        while (j < a.size() && i < a.size())
        {
            if (LMin[i] <= RMax[j])
            {
             maxDiff = Math.max(maxDiff, j-i);
            j = j + 1;
            }
            else
            i = i+1;
        }
    return maxDiff;
	
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		List<Integer> input=new ArrayList<Integer>();
		
		while(sc.hasNextInt()){
			input.add(sc.nextInt());
		}
		//moving to next line
		sc.nextLine();
		for(Integer i: input){
			System.out.println(i);
		}		
		System.out.println(maximumGap1(input));
		// Parsing inputs with commas
		String a="123,	432,	65456,	43234,	8765678, 32123,	1232,	1432";
		StringBuilder sb=new StringBuilder();
		List<Integer> ans=new ArrayList<>();
		for(int i=0; i<a.length();i++){
			 
			if(a.charAt(i)>='0'&& a.charAt(i)<='9' ){
				sb.append(a.charAt(i));
				
			}else if(a.charAt(i)==','){
				ans.add(Integer.parseInt(sb.toString()));
				sb=new StringBuilder();
			}
		}
		for(Integer at:ans){
		System.out.println(at);
		}
		sc.close();
	}
	
	
	
	

}
