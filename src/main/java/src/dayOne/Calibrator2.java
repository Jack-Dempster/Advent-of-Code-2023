package src.dayOne;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calibrator2 {

  private static final String REG_EX_MATCHER = "one|two|three|four|five|six|seven|eight|nine";

  public List<String> readFile(String filePath) {
    try {
      BufferedReader br = new BufferedReader(new FileReader(filePath));
      List<String> wordList = new ArrayList<>();
      String line;
      while ((line = br.readLine()) != null) {
        wordList.add(line);
      }
      return wordList;
    } catch (IOException e) {
      System.err.println("IO Exception caught");
    }
    return Collections.emptyList();
  }

  public int calibrate(String fileName) {
    List<String> lines = readFile(fileName);

    int result = 0;

    for (String s : lines) {
      String sReversed = new StringBuilder(s).reverse().toString();
      String reversedPattern = "(" + new StringBuilder(REG_EX_MATCHER).reverse() + "|\\d)";
      Matcher firstMatcher = Pattern.compile("(" + REG_EX_MATCHER + "|\\d)").matcher(s);
      Matcher secondMatcher = Pattern.compile(reversedPattern).matcher(sReversed);
      firstMatcher.find();
      secondMatcher.find();
      result +=
          Integer.parseInt(
              numberFromText(firstMatcher.group())
                  + numberFromText(new StringBuilder(secondMatcher.group()).reverse().toString()));
    }

    return result;
  }

  public String numberFromText(String text) {
    switch (text) {
      case "one":
        return "1";
      case "two":
        return "2";
      case "three":
        return "3";
      case "four":
        return "4";
      case "five":
        return "5";
      case "six":
        return "6";
      case "seven":
        return "7";
      case "eight":
        return "8";
      case "nine":
        return "9";
      default:
        return text;
    }
  }
}
