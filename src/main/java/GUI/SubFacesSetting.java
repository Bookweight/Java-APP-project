package GUI;

import GUI.FiveFacesSettingGUI.Faces;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

public class SubFacesSetting {
  private final JFrame appFrame;
  private JPanel mainPanel;
  private final CustomButton returnButton;

  public SubFacesSetting(Faces face) {
    double w = DynamicSizing.getYourWidth();
    double h = DynamicSizing.getYourHight();

    appFrame = new JFrame("Sub-item Settings: " + face);
    appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    appFrame.setSize((int) Math.round(640 * w), (int) Math.round(900 * h));
    appFrame.setLocationRelativeTo(null);

    mainPanel =
        new JPanel(new MigLayout("insets 40, wrap 2, fillx, gapy 15", "[grow, fill][100!]", ""));
    mainPanel.setBackground(Theme.BG_MAIN);

    JLabel title = new JLabel(face.toString().toUpperCase() + " 比重設定");
    title.setFont(Theme.FONT_TITLE);
    title.setForeground(Theme.TEXT_MAIN);
    mainPanel.add(title, "span 2, align center, wrap 40");

    // Example sub-items settings
    for (int i = 1; i <= 4; i++) {
      mainPanel.add(new JLabel("子項目 " + i), "growx");
      JTextField tf = new JTextField("1");
      tf.setHorizontalAlignment(JTextField.CENTER);
      mainPanel.add(tf, "h 40!");
    }

    returnButton = new CustomButton("返回");
    returnButton.setColors(Theme.TEXT_MUTED, Theme.TEXT_MAIN);
    returnButton.setCornerRadius(20);
    returnButton.addActionListener(
        e -> {
          new FiveFacesSettingGUI();
          appFrame.dispose();
        });

    mainPanel.add(returnButton, "span 2, h 60!, w 200!, align center, gaptop 30");

    JPanel functionPanel = new ThreeFunctionButtons(appFrame).getPanel();
    mainPanel.add(functionPanel, "span 2, growx, pushy, aligny bottom");

    appFrame.setContentPane(mainPanel);
    appFrame.setVisible(true);
  }
}
