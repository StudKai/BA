package analysisIndexing.analysis;

import java.util.*;

public class WordCounter {
	
	public HashMap<String, Integer> countWords (String text) {
		HashMap<String, Integer> wordsNumberMap = new HashMap<String, Integer>();
		String[] words;
		
		text = text.toLowerCase();
		text = this.replaceSymbols(text, ' ');
		text = this.removeToMuchBlanks(text);
		
		words = text.split(" ");
		
		for (String w : words) {
			if (w.length() < 1) continue;
			if (wordsNumberMap.containsKey(w)) {
				wordsNumberMap.put(w, wordsNumberMap.get(w) + 1);
			}
			else {
				wordsNumberMap.put(w, 1);
			}
		}
		
		return wordsNumberMap;
	}
	
	private String replaceSymbols (String text, char newChar) {
		text = text.replace(',', newChar);
		text = text.replace(';', newChar);
		text = text.replace(':', newChar);
		text = text.replace('.', newChar);
		text = text.replace('!', newChar);
		text = text.replace('?', newChar);
		text = text.replace('"', newChar);
		text = text.replace('\'', newChar);
		text = text.replace('(', newChar);
		text = text.replace(')', newChar);
		text = text.replace('/', newChar);
		text = text.replace('\n', newChar);
		text = text.replace('\t', newChar);
		text = text.replace('\r', newChar);
		
		return text;
	}
	
	private String removeToMuchBlanks (String text) {
		char[] charArray = text.toCharArray();
		int length = charArray.length;
		int j;
		int numberSpaces;
		
		for (int i = 0; i < length; i++) {
			if (Character.isWhitespace(charArray[i])) {
				numberSpaces = 0;
				
				for (j = i + 1; Character.isWhitespace(charArray[j]); j++);
				
				numberSpaces = j - i;
				
				if (numberSpaces > 1) {
					text = text.substring(0, i) + text.substring(j - 1);
					charArray = text.toCharArray();
					length = charArray.length;
				}
			}
			
		}		
		
		return text;
	}
	
	public void printNumbers (HashMap<String, Integer> wordsNumberMap) {
		Set<String> wordsSet;
		Iterator<String> it;
		String word;
		Integer number;
		int i = 1;
		
		wordsSet = wordsNumberMap.keySet();
		it = wordsSet.iterator();
		
		while (it.hasNext()) {
			word = it.next();
			number = wordsNumberMap.get(word);
			
			System.out.println(String.valueOf(i++) + ".\t" + word + ": " + String.valueOf(number));
		}
	}
	
}
