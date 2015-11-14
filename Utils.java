package Utils;

import java.util.Scanner;
import java.text.DecimalFormat;

public class Utils {
  public static String getInput(String message) {
    Scanner scan = new Scanner(System.in);
    System.out.print(message);
    return scan.nextLine();
  }

  public static double getNumberInput(String message) {
    try {
      return Double.parseDouble(getInput(message));
    } catch (NumberFormatException e) {
      return 0;
    }
  }

  public static double getNumberInput() {
    return getNumberInput("Enter a number: ");
  }

  public static String formatNumber(double d) {
    return new DecimalFormat("#.##").format(d);
  }
}
