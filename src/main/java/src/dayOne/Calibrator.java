package src.dayOne;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calibrator {

  private static final String NUMBER_WORD_REGEX =
      "(one|two|three|four|five|six|seven|eight|nine|\\d)";
  private static final String NUMBER_REGEX = "\\d";
  private final Map<String, String> numberValues = new HashMap<>();

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

  public int calibratePartOne(List<String> wordList) {
    return wordList.stream()
        .mapToInt(
            word -> {
              var intList = getNumbersFromString(word, NUMBER_REGEX);
              return Integer.parseInt(concatFirstAndLastDigit(intList));
            })
        .sum();
  }

  public int calibratePartTwo(List<String> wordList) {
    numberValues.put("one", "1");
    numberValues.put("two", "2");
    numberValues.put("three", "3");
    numberValues.put("four", "4");
    numberValues.put("five", "5");
    numberValues.put("six", "6");
    numberValues.put("seven", "7");
    numberValues.put("eight", "8");
    numberValues.put("nine", "9");
    return wordList.stream()
        .mapToInt(
            word -> {
              var intList = getNumbersFromString(word, NUMBER_WORD_REGEX);
              var result = convertWordNumbersToNumbers(intList);
              return Integer.parseInt(concatFirstAndLastDigit(result));
            })
        .sum();
  }

  private String concatFirstAndLastDigit(List<String> intList) {
    String firstDigit = intList.getFirst();
    String lastDigit = intList.getLast();
    return firstDigit + lastDigit;
  }

  private List<String> getNumbersFromString(String value, String regex) {
    Matcher matcher = Pattern.compile(regex).matcher(value);
    ArrayList<String> intList = new ArrayList<>();
    while (matcher.find()) {
      intList.add(matcher.group());
    }
    return intList;
  }

  private List<String> convertWordNumbersToNumbers(List<String> stringList) {
    return stringList.stream()
        .map(word -> numberValues.get(word) != null ? numberValues.get(word) : word)
        .toList();
  }
}
