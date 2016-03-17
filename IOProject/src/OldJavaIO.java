import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class OldJavaIO {

	// Without try with resources
	// Working only if I know that this file contains text
	
	private static Reader reader;

	public static void main(String[] args) {
		
		StringBuffer buff = new StringBuffer();
		
		FileInputStream myFile = null;
		
		try {
			myFile = new FileInputStream("/home/evcat/git/IO/IOProject/src/text.txt");
			
			InputStreamReader inpReader = new InputStreamReader(myFile, "UTF8");
			
			reader = new BufferedReader(inpReader);
			
			int c = 0;
			
			while((c=reader.read()) > -1) {
				buff.append((char)c);
			}
			System.out.print(buff.toString());
		} catch (IOException e) {
			System.out.print("Couldn't read file: " + e.getMessage());
		} finally {
			if (myFile != null) {
				try {
					reader.close();
					myFile.close();
				} catch (IOException e1) {
					e1.getMessage();
				}
			}
		}
		
	}

}
