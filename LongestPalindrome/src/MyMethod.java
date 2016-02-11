
public class MyMethod {

	public boolean isPalindrome(String s) {
		int end = s.length() - 1;
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(end)) {
				return false;
			}
			end--;
		}
		return true;
	}
	public void combinations(String s){
		for(int i=0;i<s.length()-1;i++){
			for(int j=s.length()-1;j<=i+1;j--){
				System.out.println(s.substring(i,j+1));
			}
		}
	}
	public static void main(String[] args){
		MyMethod mm=new MyMethod();
		String s="bbabbabacccccccccccccccaba";
		mm.combinations(s);
	}
}
