package com.lumatest.utils;

import io.qameta.allure.Step;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ProjectUtils {
  private static final Properties properties = new Properties();

  static {
    try (InputStream input = ProjectUtils.class.getClassLoader().getResourceAsStream("config.properties")) {
      if (input == null) {
        System.out.println("Sorry, unable to find config.properties");
      }
      properties.load(input);
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  @Step("Open Base URL")
  public static String getBaseUrl() {
    return properties.getProperty("base.url");
  }

  @Step("Read text from file")
  public static String readFromFile(String filePath) throws IOException {
    StringBuilder contentBuilder = new StringBuilder();
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
      String currentLine;
      while ((currentLine = br.readLine()) != null) {
        contentBuilder.append(currentLine).append("\n");
      }
    }
    return contentBuilder.toString().trim();
  }
}
