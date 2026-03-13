package gui;

import java.awt.Toolkit;

public class DynamicSizing {
  public static double getYourWidth() {
    return Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 1920.0;
  }

  public static double getYourHight() {
    return Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 1080.0;
  }
}
