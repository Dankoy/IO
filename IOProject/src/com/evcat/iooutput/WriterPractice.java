package com.evcat.iooutput;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class WriterPractice {

	public static void main(String[] args) {
		
		StringBuffer buff = new StringBuffer();
		
		// Trying to read text file
		try (FileInputStream myFile = new FileInputStream("text.txt");
				InputStreamReader inpReader = new InputStreamReader(myFile, "UTF8");
				Reader reader = new BufferedReader(inpReader);) {
			
			int c = 0;
			while((c = reader.read()) > -1) {
				buff.append((char)c);
			}
			
		//	System.out.print(buff.toString());
		} catch (IOException e) {
			System.out.print("Couldn't read file: " + e.getMessage());
		}
		
		buff.append("\nAppended new information!");
		
		
		// Trying to write in text file
		
		try (FileOutputStream myFile = new FileOutputStream("writetext.txt");
				OutputStreamWriter outpWriter = new OutputStreamWriter(myFile, "UTF8");
				Writer out = new BufferedWriter(outpWriter);) {
			
			out.write(buff.toString());
			System.out.print(buff);
			
		} catch (IOException e1) {
			System.out.print("Couldn't write in file: " + e1.getMessage());
		}
		
	}

}
