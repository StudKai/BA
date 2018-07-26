package analysisIndexing.analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Sorting {
	
	public enum SortMapBy {
		KEY,
		VALUE
	}
	
	// https://javabeginners.de/Grundlagen/Objekte_sortieren.php
	// https://stackoverflow.com/questions/109383/sort-a-mapkey-value-by-values
	// https://stackoverflow.com/questions/2827585/what-is-super-t-syntax
	// https://docs.oracle.com/javase/tutorial/extra/generics/morefun.html
	public static <K, V extends Comparable<? super V>> Map<K, V> sortMap (Map<K, V> map, SortMapBy sortMapBy) {
        List<Entry<K, V>> list;
        Map<K, V> treeMap;
        Map<K, V> result;
        
        switch (sortMapBy)
        {
        	case KEY:
        		treeMap = new TreeMap<K, V>(map);
        		
        		return new LinkedHashMap<K, V>(treeMap);
        	case VALUE:
        		list = new ArrayList<Entry<K, V>>(map.entrySet());
        		list.sort(Entry.comparingByValue());
        		result = new LinkedHashMap<K, V>();
                
                for (Entry<K, V> entry : list) {
                    result.put(entry.getKey(), entry.getValue());
                }
                
        		return result;
        	default:
        		System.out.println("Error: Map has not been sorted.");
        		return map;
        }
    }
	
}
