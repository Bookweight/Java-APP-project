package GUI;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;

public class ImageUtil {

    /**
     * Loads an image from the classpath, scales it to the specified width and height, 
     * and returns an ImageIcon.
     * 
     * @param path The path to the image resource (e.g., "Icons/background2.png")
     * @param width The target width
     * @param height The target height
     * @return ImageIcon, or null if the image could not be loaded
     */
    public static ImageIcon getScaledIcon(String path, int width, int height) {
        try {
            InputStream is = ImageUtil.class.getResourceAsStream(path);
            if (is == null) {
                System.err.println("Resource not found: " + path);
                return null;
            }
            Image img = ImageIO.read(is);
            if (img == null) {
                System.err.println("Failed to read image data from: " + path);
                return null;
            }
            return new ImageIcon(img.getScaledInstance(width, height, Image.SCALE_SMOOTH));
        } catch (IOException e) {
            System.err.println("Exception while loading image: " + path);
            e.printStackTrace();
            return null;
        }
    }
}
