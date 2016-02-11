
public class Series {
	public static int checkStart(String abc){
		int j=1;
		while(j<=abc.length()/2){
			Integer a=(Integer.parseInt(abc.substring(0, j))+1);
			//System.out.println(a);
			String av=a.toString();
			int be=av.length();
			
			Integer temp=a+1;
			int le=temp.toString().length();
			Integer w=a+1;
			Integer c=a+2;
			//System.out.println(c);
			String cv=c.toString();
			int de=cv.length();			
			if(av.equals(abc.substring(j, j+be))&&
					w.toString().equals(abc.substring(j+be, j+be+w.toString().length()))
					){
				System.out.println(j+" we");
				break;
			}
			else if(cv.equals(abc.substring(j+le, j+le+de))){				
				System.out.println(j+" ee");
				 break;
				 }
			j++;
			
	}
		return j;
	}
	public static int Answer(String value){
		int i=0;
		while(i<value.length()){
			int temp=Integer.parseInt(value.substring(i,i+Series.checkStart(value)));
			Integer temp1=temp+1;
			Integer temp2=temp+2;
			String str=temp1.toString();
			String str1=temp2.toString();
			if(str.equals(value.substring(i+Series.checkStart(value),i+Series.checkStart(value)+str.length()))){				
				i=i+temp2.toString().length();
			}else if((str1.equals(value.substring(i+Series.checkStart(value),i+Series.checkStart(value)+str1.length())))){
				//System.out.println(temp2-1);
				return temp2-1;
			}else{
				break;
			}
		}
		return -1;
	} 
	public static void main(String[] args){
		String value="8101112";
		
		//System.out.println(Series.checkStart(value));
		//System.out.println(" ");
		Series sc=new Series();
		System.out.println(sc.Answer(value));
		//System.out.println(sc.checkStart(value));
		
	}

}
