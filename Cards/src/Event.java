import java.util.Random;
import java.util.*;
public class Event{
	public enum Type{DIAMOND,SPADE,HEARTS,CLUB}
	public class Card{
		
		private Type type;
		private int rank;
		public Type getType(){
			return type;
		}
		public int getRank(){
			return rank;
		}
		public Card(Type type,int rank){
			this.rank=rank;
			this.type=type;
		}
	}
	private static ArrayList<Card> dec;
	/*public void setDec(ArrayList<Card> dec){
		this.dec=dec;
	}*/
	public ArrayList<Card> getDec(){
		return dec;
	}
	public void fillDec(){
		ArrayList<Card> dec1=new ArrayList<Card>();
		for(int i=0;i<13;i++){
			Card card=new Card(Type.DIAMOND,i);
			dec1.add(card);
			
		}
		for(int i=0;i<13;i++){
			Card card=new Card(Type.SPADE,i);
			dec1.add(card);
		}
		for(int i=0;i<13;i++){
			Card card=new Card(Type.HEARTS,i);
			dec1.add(card);
		}
		for(int i=0;i<13;i++){
			Card card=new Card(Type.CLUB,i);
			dec1.add(card);
		}
		dec=dec1;
	}
	public static void mix(){
	Collections.shuffle(dec);
	}
	public Card draw1(){
		fillDec();
		mix();
		Card cc=Event.dec.remove(0);
		return cc;
	}
	
	public Card draw(){
		Random rr=new Random();
		int r1 = rr.nextInt(4);
		Type type;
		if(r1==0){
		type=Type.DIAMOND;}
		else if(r1==1){
		type=Type.SPADE;}
		else if(r1==2){
		type=Type.HEARTS;}
		else{
		type=Type.CLUB;}
		int r2 = rr.nextInt(13);
		Card cc=new Card(type,r2);
		return cc;
	}
	public static void main(String[] args){
		Event ee =new Event();
		Card c=ee.draw1();
		System.out.println(c.getRank());
		System.out.println(c.getType());
	}
}