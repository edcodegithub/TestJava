public class LongestPalindrome {
	public String longestPalindrom(String s) {
		String longestPalindrome = "";
		for (int i = 0; i < s.length(); i++) {
			for (int j = s.length() - 1; j >= 0 && j != i; j--) {
				if (isPalindrome(s.substring(i, j + 1))) {
					if (s.substring(i, j + 1).length() > longestPalindrome
							.length()) {
						longestPalindrome = s.substring(i, j + 1);
						return longestPalindrome;
					}
				}
			}
		}
		return longestPalindrome;
	}

	public static boolean isPalindrome(String s) {
		int end = s.length() - 1;
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(end)) {
				return false;
			}
			end--;
		}
		return true;
	}
	public static void main(String[] args){
		LongestPalindrome lp=new LongestPalindrome();
		String s="bbabbabacccccccccccccccaba";
		System.out.println(lp.longestPalindrom(s));
	}

}
