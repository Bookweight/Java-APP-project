package GUI;

import java.awt.Color;
import java.awt.Font;

/** Defines the comprehensive color palette and typography for the redesigned UI. */
public class Theme {
  // Primary Colors
  public static final Color PRIMARY = new Color(74, 144, 226); // A soft blue
  public static final Color PRIMARY_HOVER = new Color(53, 122, 199);

  // Background Colors
  public static final Color BG_MAIN = new Color(245, 247, 250); // Light gray background
  public static final Color BG_CARD = Color.WHITE; // White panels/cards

  // Text Colors
  public static final Color TEXT_MAIN = new Color(44, 62, 80); // Dark slate gray
  public static final Color TEXT_MUTED = new Color(127, 140, 141); // Muted gray

  // Category Colors (for the 5 faces)
  public static final Color ACADEMIC_COLOR = new Color(231, 76, 60); // Red
  public static final Color HOBBY_COLOR = new Color(241, 196, 15); // Yellow
  public static final Color SPORT_COLOR = new Color(46, 204, 113); // Green
  public static final Color SOCIAL_COLOR = new Color(155, 89, 182); // Purple
  public static final Color RELATIONSHIP_COLOR = new Color(52, 152, 219); // Blue

  // Borders & Dividers
  public static final Color BORDER_COLOR = new Color(223, 230, 233);

  // Typography
  public static final Font FONT_TITLE = new Font("SansSerif", Font.BOLD, 24);
  public static final Font FONT_HEADER = new Font("SansSerif", Font.BOLD, 18);
  public static final Font FONT_REGULAR = new Font("SansSerif", Font.PLAIN, 14);
  public static final Font FONT_BUTTON = new Font("SansSerif", Font.BOLD, 15);
}
