package analysisIndexing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class File {
	
	public static String read (String filePath) throws IOException {
		String fileText = "";
		String line;
		
		FileReader fReader = new FileReader(filePath);
		BufferedReader bReader = new BufferedReader(fReader);		
		
		while ((line = bReader.readLine()) != null) {			
			fileText += line;
		}
		
		bReader.close();
		
		return fileText;
	}
	
}
