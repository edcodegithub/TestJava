import java.util.Arrays;


public class Answer {
	
	public int add(int i,int[] arr){
		int value1=0;
		
        for(int j=0;j<arr.length;j++){
        	if(arr[j]==i){
            	value1=value1+1;
            }
        }        	
        return value1;
	}

	public int getScore(Category cat,int[] arr){
		int value=0;		
		//Arrays.sort(arr);
		switch (cat) {
        case ONES:  
          return   add(1,arr); 
        case TWOS:
        	return add(2,arr);
        case THREES:
        	return add(3,arr);
        case FOURS:
        	return add(4,arr);           
        case FIVES: 
        	return add(5,arr);
        case SIXES: 
        	return add(6,arr);
        case SEVENS: 
        	return add(7,arr);
        case EIGHTS:
        	return add(8,arr);            
                
        case THREEOFAKIND:          	
        	value=0;
        	int set=0;
        	for(int i=0; i<arr.length;i++){       		
        		value=value+i;
        		int count=0;
        		for(int j=0;j<arr.length;j++){
        			if(arr[i]==arr[j]){
        				count++;
        			}
        			if(count==3){
        				set=3;
        				break;
        			}
        		}
        	}
        	if(set==3)      	  
      	     return value;
        	else 
        		return 0;
        	
        case FOUROFAKIND: 
        	value=0;
        	int set1=0;
        	for(int i=0; i<arr.length;i++){       		
        		value=value+i;
        		int count=0;
        		for(int j=0;j<arr.length;j++){
        			if(arr[i]==arr[j]){
        				count++;
        			}
        			if(count==4){
        				set1=4;
        				break;
        			}
        		}
        	}
        	if(set1==4)      	  
      	     return value;
        	else 
        		return 0;
        	      
        case FULLHOUSE:
        	int l=arr[0];
        	int c=0;int d=0;
        	for(int i=1;i<arr.length;i++){
        		if(arr[i]==arr[0]){
        			c++;        			
        		}else{
        			
        		}
        	}
        	return 25;
        default:
        	return -1;
        	
        
    }
		
	}

}
