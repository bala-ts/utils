package com.tsb.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileUtil {
	
	public static List<String> getFileContent(String fileName) {
		List<String> wordList = new ArrayList<String>();
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			stream.forEach(wordList::add);
		} catch (IOException e) { e.printStackTrace(); }
		return wordList;
	}
	
}
