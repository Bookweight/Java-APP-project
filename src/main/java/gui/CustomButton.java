package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class CustomButton extends JButton {
  private Color backgroundColor = Theme.PRIMARY;
  private Color hoverColor = Theme.PRIMARY.darker();
  private Color currentColor = Theme.PRIMARY;
  private int cornerRadius = 30;

  public CustomButton(String text) {
    super(text);
    init();
  }

  public CustomButton(String text, ImageIcon icon) {
    super(text, icon);
    init();
  }

  private void init() {
    setContentAreaFilled(false);
    setFocusPainted(false);
    setBorderPainted(false);
    setForeground(Color.WHITE);
    setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    addMouseListener(
        new MouseAdapter() {
          @Override
          public void mouseEntered(MouseEvent e) {
            currentColor = hoverColor;
            repaint();
          }

          @Override
          public void mouseExited(MouseEvent e) {
            currentColor = backgroundColor;
            repaint();
          }
        });
  }

  public void setColors(Color normal, Color hover) {
    this.backgroundColor = normal;
    this.hoverColor = hover;
    this.currentColor = normal;
  }

  public void setBackgroundColor(Color color) {
    this.backgroundColor = color;
    this.hoverColor = color.darker();
    this.currentColor = color;
  }

  public void setCornerRadius(int radius) {
    this.cornerRadius = radius;
  }

  @Override
  protected void paintComponent(Graphics g) {
    Graphics2D g2 = (Graphics2D) g.create();
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2.setColor(currentColor);
    g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
    super.paintComponent(g2);
    g2.dispose();
  }
}
