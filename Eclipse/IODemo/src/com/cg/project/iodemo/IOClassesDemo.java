package com.cg.project.iodemo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOClassesDemo {
	public static void fileClassDemo() throws IOException{
		File file=new File("d:\\DataFile.txt");
		System.out.println(file.exists());
		if(!file.exists())
			file.createNewFile();
		System.out.println(file.exists());
		System.out.println(file.canWrite());
		System.out.println(file.canRead());
		System.out.println(file.length());
		System.out.println(file.getPath());
		System.out.println(file.getName());
	}
	public static void byteStreamReadWrite(File fileFrom,File fileTo)throws IOException {
		try(BufferedInputStream srcStream=new BufferedInputStream(new FileInputStream(fileFrom))){
			try(BufferedOutputStream destStream=new BufferedOutputStream(new FileOutputStream(fileTo))){
			/*int a=0;
					while((a=scrStream.read())!=-1){
						destStream.write(a);
					}*/
			/*byte [] dataBuffer=new byte[1024];
					while(scrStream.read(dataBuffer)!=-1){
						destStream.write(dataBuffer);
					}*/
			byte [] dataBuffer=new byte[(int) fileFrom.length()];
						srcStream.read(dataBuffer);
						destStream.write(dataBuffer);
		}
	}
	System.out.println("File has Transfered");
	}

}
