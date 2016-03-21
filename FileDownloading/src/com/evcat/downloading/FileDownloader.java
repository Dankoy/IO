package com.evcat.downloading;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class FileDownloader {
	
	public static void main(String[] args) {
			
		if(args.length!=2) {
			System.out.println("Proper Usage: java FileDownload URL OutputFileName");
			System.exit(0);
		}
		
		InputStream in = null;
		FileOutputStream fOut = null;
		
		try {
			URL remoteFile = new URL(args[0]);
			URLConnection fileStream = remoteFile.openConnection();
			
			// Open output and input streams
			fOut = new FileOutputStream(args[1]);
			in = fileStream.getInputStream();
			
			// Save the file
			int data;
			
			System.out.println("Downloading...");
			
			while((data=in.read())!=-1) {
				fOut.write(data);
			}
			
		} catch (IOException e1) {
			e1.getMessage();
		} finally {
			System.out.println("The file " + args[0]  + " has been downloaded successfully as " + args[1]);
		}
		
		try {
			in.close();
			fOut.flush();
			fOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
