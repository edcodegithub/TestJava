package DiceYatch;

public class Main {

	public static void main(String[] args) {
		int[] scores = {5,5,5,5,5};
		Category kategory = Category.AllDifferent;
		Result result = new Result();
		
		int finalScore = result.getScore(kategory, scores);
		System.out.println(finalScore);
		
		kategory = result.getSuggestion(scores);
		System.out.println(kategory);
	}

}
