import java.util.HashSet;
import java.util.Set;

public class uniqueMorseRepresentations {

	public static void main(String[] args) {
		String[] words = new String[]{"gin", "zen", "gig", "msg"};
		String[] table = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
		Set<String> dic = new HashSet<>();
		
		for (int i = 0; i < words.length; i++){
		    StringBuilder sb = new StringBuilder();
		    
		    for (int j = 0; j < words[i].length(); j++){
		        sb.append(table[(int) words[i].charAt(j) - 97]);
		    }
		    dic.add(sb.toString());
		}
		System.out.println(dic.size());
	}
}
