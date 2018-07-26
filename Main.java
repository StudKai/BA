package analysisIndexing;

import java.io.IOException;
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
		String textStd = "hallo du da.. hallo er da,    er Sie sie \n \"Der\" Herr Platz\tKönner\nKönner.\'hallo";
		WordCounter wordCounter = new WordCounter();		
		
		if (args.length > 0)
		{			
			try {
				text = File.read(args[0]);
			}
			catch (IOException ex) {
				System.out.println("Error while reading file: " + ex.getMessage() + "\n Standard text will be used.\n");
				text = textStd;
			}
		}
		else {
			text = textStd;
		}		
		
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
