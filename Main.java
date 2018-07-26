package analysisIndexing;

import java.util.HashMap;
import analysisIndexing.analysis.*;
import analysisIndexing.analysis.Sorting.SortMapBy;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashMap<String, Integer> wordsNumberMap;
		HashMap<String, Integer> wordsNumberMapSByK;
		HashMap<String, Integer> wordsNumberMapSByV;
		String text;
		WordCounter wordCounter = new WordCounter();
		
		text = "hallo du da.. hallo er da,    er Sie sie \n \"Der\" Herr Platz\tKönner\nKönner.\'hallo";
		
		System.out.println("Text:");
		System.out.println(text + "\n");
		
		wordsNumberMap = wordCounter.countWords(text);
		wordsNumberMapSByK = (HashMap<String, Integer>) Sorting.sortMap(wordsNumberMap, SortMapBy.KEY);
		wordsNumberMapSByV = (HashMap<String, Integer>) Sorting.sortMap(wordsNumberMap, SortMapBy.VALUE);
		
		System.out.println("Unsorted:");
		wordCounter.printNumbers(wordsNumberMap);
		
		System.out.println("\nSorted By Key:");
		wordCounter.printNumbers(wordsNumberMapSByK);
		
		System.out.println("\nSorted By Value:");
		wordCounter.printNumbers(wordsNumberMapSByV);
	}

}
