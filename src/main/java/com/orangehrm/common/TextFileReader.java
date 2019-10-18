package com.orangehrm.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextFileReader {
public static void main(String arg[]) throws IOException {
String fileName="C:/Users/User/Contacts/Desktop/kiran.txt";
File File=new File(fileName);

FileReader fr = new FileReader(File);
BufferedReader br=new BufferedReader(fr);
String line;
String [][]data=new String[3][2];
int i= 0;
while((line=br.readLine()) !=null){

		
	//process the line
	System.out.println(line);
	String []tempdata=line.split(",");
data[i]=tempdata;
i =i+1;


}
System.out.println(data);
//return data;
}
}
