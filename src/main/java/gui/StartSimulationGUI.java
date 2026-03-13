package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import net.miginfocom.swing.MigLayout;

public class StartSimulationGUI {

  private JFrame appFrame;
  private JPanel mainPanel;
  private final JTextField daysTextField;
  private final JTextField hourTextField;
  private final CustomButton nextButton;
  private final CustomButton returnButton;
  private ImageIcon daysIcon;
  private ImageIcon hourIcon;

  public StartSimulationGUI() {
    double w = DynamicSizing.getYourWidth();
    double h = DynamicSizing.getYourHight();

    appFrame = new JFrame("Simulation Setup");
    appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    appFrame.setSize((int) Math.round(640 * w), (int) Math.round(900 * h));
    appFrame.setLocationRelativeTo(null);

    loadIcons(w, h);
    ActionListener btnlistener = new ButtonListener();

    mainPanel =
        new JPanel(
            new MigLayout(
                "insets 40, wrap 2, fillx, gapy 30", "[120!, align center][grow, fill]", ""));
    mainPanel.setBackground(Theme.BG_MAIN);

    JLabel title = new JLabel("模擬參數設定");
    title.setFont(Theme.FONT_TITLE);
    title.setForeground(Theme.TEXT_MAIN);
    mainPanel.add(title, "span 2, align center, wrap 40");

    daysTextField = createTextField();
    hourTextField = createTextField();

    addInputRow("實行天數", daysIcon, daysTextField);
    addInputRow("每日工作時數", hourIcon, hourTextField);

    nextButton = new CustomButton("下一步");
    nextButton.setFont(Theme.FONT_HEADER);
    nextButton.setCornerRadius(20);
    nextButton.addActionListener(btnlistener);

    returnButton = new CustomButton("返回");
    returnButton.setColors(Theme.TEXT_MUTED, Theme.TEXT_MAIN);
    returnButton.setCornerRadius(20);
    returnButton.addActionListener(btnlistener);

    mainPanel.add(nextButton, "span 2, h 60!, w 200!, align center, gaptop 20");
    mainPanel.add(returnButton, "span 2, h 50!, w 200!, align center");

    JPanel functionPanel = new ThreeFunctionButtons(appFrame).getPanel();
    mainPanel.add(functionPanel, "span 2, growx, pushy, aligny bottom");

    appFrame.setContentPane(mainPanel);
    appFrame.setVisible(true);
  }

  private JTextField createTextField() {
    JTextField tf = new JTextField();
    tf.setFont(Theme.FONT_HEADER);
    tf.setHorizontalAlignment(JTextField.CENTER);
    return tf;
  }

  private void addInputRow(String text, ImageIcon icon, JTextField tf) {
    JLabel label = new JLabel(text, icon, SwingConstants.CENTER);
    label.setVerticalTextPosition(JLabel.BOTTOM);
    label.setHorizontalTextPosition(JLabel.CENTER);
    label.setFont(Theme.FONT_BUTTON);
    label.setForeground(Theme.TEXT_MAIN);

    mainPanel.add(label);
    mainPanel.add(tf, "h 60!");
  }

  private class ButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent a) {
      if (a.getSource() == nextButton) {
        new SimulationResultGUI();
        appFrame.dispose();
      } else if (a.getSource() == returnButton) {
        new SimulationGUI();
        appFrame.dispose();
      }
    }
  }

  private void loadIcons(double w, double h) {
    int s = (int) Math.round(60 * w);
    daysIcon = ImageUtil.getScaledIcon("/gui/Icons/dailyImg.png", s, s);
    hourIcon = ImageUtil.getScaledIcon("/gui/Icons/hourImg.png", s, s);
  }
}
