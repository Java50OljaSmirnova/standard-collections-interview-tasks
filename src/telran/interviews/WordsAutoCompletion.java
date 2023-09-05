package telran.interviews;

import java.util.ArrayList;
import java.util.*;

public class WordsAutoCompletion implements Words {
	
	TreeSet<String> set = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
	
	@Override
	public boolean addWord(String word) {
		
		return set.add(word);
	}

	@Override
	public List<String> getWordsByPrefix(String prefix) {
		
		return new ArrayList<>(set.subSet(prefix, getPrefixLimit(prefix)));
	}

	private String getPrefixLimit(String prefix) {
		char lastChar = prefix.charAt(prefix.length() - 1);
		char limitChar = (char) (lastChar + 1);
		return prefix.substring(0, prefix.length() - 1) + limitChar;
	};
	

}
