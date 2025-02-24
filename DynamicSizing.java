package GUI;

import java.awt.Dimension;
import java.awt.Toolkit;

public class DynamicSizing {

    public static double getYourHight() {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        return size.getHeight() / 1080;
    }

    public static double getYourWidth() {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        return size.getWidth() / 1920;
    }

}
