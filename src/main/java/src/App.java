package src;

import java.io.IOException;
import src.dayOne.Calibrator;
import src.dayOne.Calibrator2;

public class App {
  public static void main(String[] args) throws IOException {
    // Day One execution
    Calibrator calibrator = new Calibrator();
    var inputFile = calibrator.readFile("src/main/java/src/dayOne/input.txt");
    //    System.out.println(calibrator.calibratePartOne(inputFile));
    System.out.println(calibrator.calibratePartTwo(inputFile));

    Calibrator2 calibrator2 = new Calibrator2();
    System.out.println(calibrator2.calibrate("src/main/java/src/dayOne/input.txt"));
    System.out.println(
        calibrator2.calibrate("src/test/java/src/dayOne/InputFiles/numbersAsWords.txt"));
  }
}
