package gui;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ScreenshotRunner {
  public static void main(String[] args) {
    FlatLightLaf.setup();
    MainGUI mainGui = new MainGUI();

    // Give the GUI a moment to render
    try {
      Thread.sleep(2000); // Wait 2 seconds

      Robot robot = new Robot();
      // Get the precise bounds of the frame
      Rectangle captureRect = mainGui.getFrame().getBounds();
      // Add a slight margin since window drop shadows might clip
      captureRect.x += 8;
      captureRect.y += 8;
      captureRect.width -= 16;
      captureRect.height -= 16;

      BufferedImage screenFullImage = robot.createScreenCapture(captureRect);

      File outputfile = new File("screenshot.png");
      ImageIO.write(screenFullImage, "png", outputfile);
      System.out.println("Screenshot saved to screenshot.png");

      System.exit(0);
    } catch (InterruptedException | AWTException | IOException ex) {
      System.err.println("Failed to capture screenshot: " + ex.getMessage());
      System.exit(1);
    }
  }
}
