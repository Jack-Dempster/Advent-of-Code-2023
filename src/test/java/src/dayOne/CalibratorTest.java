package src.dayOne;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class CalibratorTest {
  Calibrator calibrator;

  @BeforeEach
  void beforeEach() {
    calibrator = new Calibrator();
  }

  @Nested
  class partOne {
    @Test
    public void when_properly_formatted_string_return_contacted_first_and_last_digit() {
      List<String> inputFile =
          calibrator.readFile("src/test/java/src/dayOne/InputFiles/testExample.txt");
      var result = calibrator.calibratePartOne(inputFile);
      Assertions.assertEquals(142, result);
    }

    @Test
    public void when_empty_file_catch_exception_and_return_empty_list() {
      List<String> inputFile = calibrator.readFile("src/test/java/src/dayOne/InputFiles/empty.txt");
      var result = calibrator.calibratePartOne(inputFile);
      Assertions.assertEquals(0, result);
    }

    @Test
    public void when_all_numbers_return_correctly() {
      List<String> inputFile =
          calibrator.readFile("src/test/java/src/dayOne/InputFiles/allNumbers.txt");
      var result = calibrator.calibratePartOne(inputFile);
      Assertions.assertEquals(19, result);
    }
  }

  @Nested
  class partTwo {

    @Test
    public void when_properly_formatted_string_return_contacted_first_and_last_digit() {
      List<String> inputFile =
          calibrator.readFile("src/test/java/src/dayOne/InputFiles/numbersAsWords.txt");
      var result = calibrator.calibratePartTwo(inputFile);
      Assertions.assertEquals(281, result);
    }

    @Test
    public void when_properly_formatted_string_return_contacted_first_and_last_digit_summed() {
      List<String> inputFile =
          calibrator.readFile("src/test/java/src/dayOne/InputFiles/otherNumbers.txt");
      var result = calibrator.calibratePartTwo(inputFile);
      Assertions.assertEquals(96, result);
    }
  }
}
