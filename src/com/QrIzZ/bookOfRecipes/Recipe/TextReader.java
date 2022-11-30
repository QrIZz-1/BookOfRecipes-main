package com.QrIzZ.bookOfRecipes.Recipe;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextReader {

  String link = "ForEveryDay.txt";

  public static String readAllText(String link) throws IOException {
    BufferedReader reader = Files.newBufferedReader(Paths.get("Resourses/"+link));
    StringBuilder content = new StringBuilder();
    String line;

    while ((line = reader.readLine()) != null) {
      content.append(line);
      content.append(System.lineSeparator());
    }

    return content.toString();
  }
}