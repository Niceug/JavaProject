package com.ltp.codecount;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class CodeLine {
	public static int COUNT = 0;
	public static StringBuilder sBuilder = new StringBuilder();
	public static void countCodeLine(File file, String...args) throws IOException {
		if(file.isDirectory()) {
			File[] files = file.listFiles();
			for(File file2 : files) {
				countCodeLine(file2, args);
			}
		} else {
			for(String str : args) {
				if("".equals(str) || null == str)
					break;
				if(file.getName().endsWith(str)) {
					LineNumberReader  lnr = new LineNumberReader(new FileReader(file));
					lnr.skip(Long.MAX_VALUE);
					int lineNum = lnr.getLineNumber() + 1;
					sBuilder.append(file.getName() + "    ÐÐÊý£º" + lineNum + "\n");
					COUNT += lnr.getLineNumber() + 1;
					lnr.close();
				}
			}
			
		}
	}
}
