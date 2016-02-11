package DiceYatch;

public class Result {
	
	public int getScore(Category kategory, int[] scores){
		int sum = 0;
		int score = 0;
		int[] allScore = {0,0,0,0,0,0,0,0};
		
		for(int i=0; i<5; i++){
			allScore[scores[i]-1] += 1;
			sum = sum + scores[i];
		}
		
		switch(kategory){
		
			case Ones:
				score = allScore[0]*1;
				break;
				
			case Twos:
				score = allScore[1]*2;
				break;
				
			case Threes:
				score = allScore[2]*3;
				break;
				
			case Fours:
				score = allScore[3]*4;
				break;
				
			case Fives:
				score = allScore[4]*5;
				break;
				
			case Sixes:
				score = allScore[5]*6;
				break;
				
			case Sevens:
				score = allScore[6]*7;
				break;
				
			case Eights:
				score = allScore[7]*8;
				break;
			
			case AllSame:
			{
				for(int i=0; i<8; i++){
					if(allScore[i]==5){
						score = 50;
						break;
					}
					else
						score = 0;
				}
				break;
			}
			
			case AllDifferent:
			{
				for(int i=0; i<8; i++){
					if(allScore[i]>1){
						score = 0;
						break;
					}
					else
						score = 40;
				}
				break;
			}
						
		}
		
		return score;
	}

	public Category getSuggestion(int[] scores){
		int score = 0;
		Category suggestion = null;
		
		for(Category kategory : Category.values()){
			int answer = this.getScore(kategory, scores);
			if(score < answer){
				suggestion = kategory;
				score = answer;
			}
			if(answer == 50){
				break;
			}
			if(answer == 40){
				break;
			}
		}
		
		return suggestion;
	}

}
