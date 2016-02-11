class Base{
	
	public static void main(String[] args){
		String[] temp={"","safd","dsaf"};
		int [] a={1};
		Base t=new Base();
		t.increment(a);
		System.out.println(a[a.length-1]);
System.out.println(Math.ceil(-4.7));
	}
	void increment(int[] i){
		i[i.length-1]++;
	}

}

