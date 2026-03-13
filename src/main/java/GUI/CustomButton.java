package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.JButton;

/**
 * A highly customizable rounded button extending JButton. Provides smooth hover effects and flat
 * design out of the box.
 */
public class CustomButton extends JButton {
  private Color hoverBackgroundColor = Theme.PRIMARY_HOVER;
  private Color normalBackgroundColor = Theme.PRIMARY;
  private int cornerRadius = 15;

  public CustomButton(String text) {
    super(text);
    initStyle();
  }

  public CustomButton(String text, Icon icon) {
    super(text, icon);
    initStyle();
  }

  private void initStyle() {
    setOpaque(false);
    setContentAreaFilled(false);
    setFocusPainted(false);
    setBorderPainted(false);
    setBackground(normalBackgroundColor);
    setForeground(Color.WHITE);
    setFont(Theme.FONT_BUTTON);
    setCursor(new Cursor(Cursor.HAND_CURSOR));

    // Hover Effect
    addMouseListener(
        new MouseAdapter() {
          @Override
          public void mouseEntered(MouseEvent e) {
            setBackground(hoverBackgroundColor);
          }

          @Override
          public void mouseExited(MouseEvent e) {
            setBackground(normalBackgroundColor);
          }
        });
  }

  public void setColors(Color normal, Color hover) {
    this.normalBackgroundColor = normal;
    this.hoverBackgroundColor = hover;
    setBackground(normalBackgroundColor);
  }

  public void setCornerRadius(int radius) {
    this.cornerRadius = radius;
    repaint();
  }

  @Override
  protected void paintComponent(Graphics g) {
    Graphics2D g2 = (Graphics2D) g.create();
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2.setColor(getBackground());
    g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
    g2.dispose();
    super.paintComponent(g);
  }
}
