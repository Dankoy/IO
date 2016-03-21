package com.evcat.ioinput;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class NewJavaIO {

	// With try with resources
	// Working only if I know that this file contains text
	// No need to close files and streams in "Finally" block
	
	public static void main(String[] args) throws IOException {
		
		StringBuffer buff = new StringBuffer();
		
		try (FileInputStream myFile = new FileInputStream("text.txt");
				InputStreamReader inpReader = new InputStreamReader(myFile, "UTF8");
				Reader reader = new BufferedReader(inpReader);) {
			
			int c = 0;
			while((c = reader.read()) > -1) {
				buff.append((char)c);
			}
			
			System.out.print(buff.toString());
		} catch (IOException e) {
			System.out.print("Couldn't read file: " + e.getMessage());
		}
		
	}

}
